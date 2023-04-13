package br.com.unifacisa.Ouvidoria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String numeroDeTelefone;
	private String senha;
	private Integer tipoDeRegistro;

	public Person() {

	}

	public Person(String name, String email, String numeroDeTelefone, String senha,
			Integer tipoDeRegistro) {
		this.name = name;
		this.email = email;
		this.numeroDeTelefone = numeroDeTelefone;
		this.senha = senha;
		this.tipoDeRegistro = tipoDeRegistro;
	}

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

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipoDeRegistro() {
		return tipoDeRegistro;
	}

	public void setTipoDeRegistro(Integer tipoDeRegistro) {
		this.tipoDeRegistro = tipoDeRegistro;
	}

	@Override
	public String toString() {
		return "Person " + "id= " + id + "name=" + name + ", email=" + email + ", senha=" + senha + "]\n";
	}

}
