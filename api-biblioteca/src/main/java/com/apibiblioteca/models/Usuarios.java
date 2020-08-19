package com.apibiblioteca.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_users")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "O nome é obrigatório.")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotNull(message = "O cpf é obrigatório.")
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "data")
	private LocalDate data = LocalDate.now();
	
	@NotNull(message = "A data de nascimento é obrigatória.")
	@Column(name = "data_nascimento", nullable = true)
	private Date dataDeNascimento;
	
	@NotNull(message = "O celular é obrigatório.")
	@Column(name = "celular", nullable = false)
	private int celular;
	
	@NotNull(message = "O email é obrigatório.")
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull(message = "O numero é obrigatório.")
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@NotNull(message = "A rua é obrigatória.")
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@NotNull(message = "O bairro é obrigatório")
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Livros> livros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

