package br.com.mongodb.dto;

import java.io.Serializable;

import br.com.mongodb.doman.User;

public class AuthorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.nome = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
