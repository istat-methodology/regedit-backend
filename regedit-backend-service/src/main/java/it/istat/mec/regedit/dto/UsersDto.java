package it.istat.mec.regedit.dto;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsersDto implements Serializable {
	
	private static final long serialVersionUID = -5524009610812626199L;
	private Integer id;
    private String email;
    private String name; 
    private String surname;
    private Integer role; 
    
    public UsersDto(Integer id, String email, String name, String surname, Integer role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
}
