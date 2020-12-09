package it.istat.is2.apigateway.service;

import it.istat.is2.apigateway.beans.IS2UserDetails;
import it.istat.is2.apigateway.domain.UserRolesEntity;
import it.istat.is2.apigateway.domain.UsersEntity;
import it.istat.is2.apigateway.exceptions.CustomException;
import it.istat.is2.apigateway.repository.UserRespository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService  {

    private final UserRespository userRepository;

    public UserService(UserRespository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByEmail(email);
        if (user == null || user.getRole() == null) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String [] authorities = new String[List.of(user.getRole()).size()];
        int count=0;
        for (UserRolesEntity role : List.of(user.getRole())) {
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }
        IS2UserDetails userDetails = new IS2UserDetails(user.getEmail(),user.getPassword(),1, false, false, true, authorities);
        return userDetails;
    }
}
