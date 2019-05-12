 package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.ChatDAO;
import br.com.senac.pi4.model.ChatDTO;

public class ChatServiceImpl {
	
	ChatDAO chatDAO = new ChatDAO();

	public ChatDTO saveComentario(ChatDTO chatDTO) throws Exception {
		return chatDAO.saveChat(chatDTO);
	}

	public List<ChatDTO> getAllChatByIdUsuario(String idUsuario) throws Exception {
		return chatDAO.getAllChatByIdUsuario(idUsuario);
	}

}
