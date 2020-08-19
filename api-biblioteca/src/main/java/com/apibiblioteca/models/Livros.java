package com.apibiblioteca.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_livros")
public class Livros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "O titulo é obrigatório.")
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@NotNull(message = "O autor é obrigatório.")
	@Column(name = "autor", nullable = false)
	private String autor;
	
	@NotNull(message = "A editora é obrigatória.")
	@Column(name = "editora", nullable = false)
	private String editora;
	
	@NotNull(message = "O ano de publicação é obrigatório.")
	@Column(name = "ano_publicacao", nullable = true)
	private Date anoPublicacao;
	
	@NotNull(message = "O gênero é obrigatório.")
	@Column(name = "genero", nullable = false)
	private String genero;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = true, updatable = true, nullable = false)
	private Usuarios usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
}



