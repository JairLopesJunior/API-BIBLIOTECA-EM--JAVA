package com.apibiblioteca.models;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Endereco {

	@NotNull(message = "O numero é obrigatório.")
	@Column(name = "numero")
	private int numero;
	
	@NotNull(message = "A rua é obrigatória.")
	@Column(name = "rua")
	private String rua;
	
	@NotNull(message = "O bairro é obrigatório")
	@Column(name = "bairro")
	private String bairro;
}
