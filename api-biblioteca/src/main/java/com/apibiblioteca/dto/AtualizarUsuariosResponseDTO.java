package com.apibiblioteca.dto;

import java.io.Serializable;

public class AtualizarUsuariosResponseDTO implements Serializable {

	private static final long serialVersionUID = 4288587693073658944L;

	public AtualizarUsuariosResponseDTO(boolean success, String details) {
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
