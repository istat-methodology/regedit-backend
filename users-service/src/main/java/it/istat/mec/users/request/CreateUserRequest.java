package it.istat.mec.users.request;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreateUserRequest implements Serializable {

	
	private static final long serialVersionUID = 4145077658932991811L;
	private Integer id;
    private String email;
    private String name;
    private String surname;
    private String password;
    //private String role;
    private Integer idRole;
}
