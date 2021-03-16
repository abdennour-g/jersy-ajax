package com.example.demo.ent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)    
	 @XmlAttribute(name = "id")
	 private Long id;
	 @XmlAttribute(name = "username")
    private String username;
	 @XmlAttribute(name = "email")
    private String email;
	 @XmlAttribute(name = "password")
    private String password;
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    public User(Long id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	

    
}
