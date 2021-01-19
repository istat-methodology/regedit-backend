package it.istat.mec.users.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsersDto {
	
	private static final long serialVersionUID = -5524009610812626199L;
	private Integer id;
    private String email;
    private String name; 
    private String role; 
}
