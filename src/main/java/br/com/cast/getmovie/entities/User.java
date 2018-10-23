package br.com.cast.getmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user", schema="getmovie")
public class User {
	
	@Id
	@SequenceGenerator(name="generator_id_user", schema="getmovie", sequenceName="user_id_seq",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator_id_user")
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
