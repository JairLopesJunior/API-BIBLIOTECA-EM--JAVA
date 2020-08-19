package com.apibiblioteca.dto;

import java.io.Serializable;

public class RemoverUsuariosResponseDTO implements Serializable {

	private static final long serialVersionUID = 1748770794824985427L;

	public RemoverUsuariosResponseDTO(boolean success, String details) {
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
