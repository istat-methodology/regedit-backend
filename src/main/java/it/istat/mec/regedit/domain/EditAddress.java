package it.istat.mec.regedit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "EDIT_ADDRESS")
@JsonIgnoreProperties(ignoreUnknown=true)
public class EditAddress implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER")
	private Integer user;
	@Column(name = "ADDRESS")
	private Integer address;
	@Column(name = "STATE")
	private String state;
	@Column(name = "DATE_TIME")
	private String dateTime;
	
	@ManyToOne
    @JoinColumn(name = "ID")
    @JsonManagedReference
    private Address addressParent;
}
