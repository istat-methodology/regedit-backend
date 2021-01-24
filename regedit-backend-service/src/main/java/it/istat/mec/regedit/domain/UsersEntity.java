package it.istat.mec.regedit.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "wp1_users")
public class UsersEntity implements Serializable {
   
 
	private static final long serialVersionUID = -6358578038094502164L;

	
	private Integer id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private UserRolesEntity role;
    
    public UsersEntity(Integer id) {
		super();
		this.id = id;
	}
	public UsersEntity() {
		super();
		 
	}
	
    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    public UserRolesEntity getRole() {
        return role;
    }

    public void setRole(UserRolesEntity role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	@Override
	public String toString() {
		return   String.valueOf(id);
	}
}
