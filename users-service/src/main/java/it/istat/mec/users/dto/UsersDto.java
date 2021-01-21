package it.istat.mec.users.dto;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsersDto implements Serializable {
	
	private static final long serialVersionUID = -4955160323170629969L;
	private Integer id;
    private String email;
    private String name; 
    private Integer IdRole; 
}
