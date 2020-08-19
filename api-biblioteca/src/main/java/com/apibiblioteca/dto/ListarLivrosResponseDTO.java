package com.apibiblioteca.dto;

import java.io.Serializable;

public class ListarLivrosResponseDTO implements Serializable {

	private static final long serialVersionUID = 6281525018762913600L;
	
	public ListarLivrosResponseDTO(boolean success, String details) {
		this.message = new MessageDTO(success, details);
	}

	private MessageDTO message;

	public MessageDTO getMessage() {
		return message;
	}

	public void setMessage(MessageDTO message) {
		this.message = message;
	}
}
