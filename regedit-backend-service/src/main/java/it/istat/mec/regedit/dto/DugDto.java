package it.istat.mec.regedit.dto;


import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DugDto implements Serializable {

 
	private static final long serialVersionUID = -6905546979001300372L;
	private Integer id;
	private String name;
	
}
