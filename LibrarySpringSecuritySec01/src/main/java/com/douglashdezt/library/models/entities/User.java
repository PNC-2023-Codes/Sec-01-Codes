package com.douglashdezt.library.models.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = { "bookLoans" })
@Entity
@Table(name = "user", schema = "public")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code")
	private UUID code;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	@JsonIgnore
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BookLoan> bookLoans;

	public User(String username, String email, String password, String name) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
	}
}
