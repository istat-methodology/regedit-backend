package it.istat.mec.users.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wp1_user_roles", schema = "regedit_users", catalog = "")
public class UserRolesEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @JsonBackReference    
    @OneToMany(mappedBy = "role")
    private List<UsersEntity> userEntity= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRolesEntity that = (UserRolesEntity) o;
        return id == that.id &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

	@Override
	public String toString() {
		return role;
	}
    
}
