package it.istat.is2.apigateway.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsersDto {
	private Integer id;
    private String email;
    private String name;
}
