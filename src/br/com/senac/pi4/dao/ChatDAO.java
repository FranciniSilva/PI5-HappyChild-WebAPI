package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.pi4.model.ChatDTO;
import br.com.senac.pi4.model.ProdutoDTO;
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.Database;

public class ChatDAO {
	
	public ChatDTO saveChat(ChatDTO chatDTO) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(
					"INSERT INTO Chat" + "(id_usuario, id_produto, texto) VALUES" + "(?,?,?)");
			psta.setLong(1, chatDTO.getUsuario().getId());
			psta.setLong(2, chatDTO.getProduto().getId());
			psta.setString(3, chatDTO.getTexto());

			psta.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}
		return chatDTO;
	}
	
	public List<ChatDTO> getAllChatByIdUsuario(String idUsuario) throws Exception {
		Connection conn = null;
		PreparedStatement psta = null;

		List<ChatDTO> listPg = new ArrayList<ChatDTO>();
		Integer pID = null;
		pID = Integer.parseInt(idUsuario);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement(
					"select distinct c.id, c.id_usuario, c.id_produto, c.texto, c.data_criacao, u.nome, p.nome as nome_produto, p.descricao as descricao_produto, p.id_usuario as usuario_produto, p.data_criacao as data_produto from Chat c INNER JOIN Produto p on c.id_produto = p.id inner join usuario u on u.id = c.id_usuario where c.id_usuario = ? order by c.data_criacao ASC;");

			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				ChatDTO pg = new ChatDTO();
				pg.setId(rs.getLong("id"));
				pg.setUsuario(new UsuarioDTO(rs.getLong("id_usuario"), rs.getString("nome")));
				pg.setProduto(new ProdutoDTO(rs.getString("nome_produto"), rs.getString("descricao_produto"), new UsuarioDTO(rs.getLong("usuario_produto")), rs.getDate("data_produto")));
				pg.setTexto(rs.getString("texto"));

				listPg.add(pg);
			}

		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (psta != null)
				psta.close();
			if (conn != null)
				conn.close();
		}

		return listPg;
	}

}
