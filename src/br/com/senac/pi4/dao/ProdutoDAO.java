package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.pi4.model.ProdutoDTO;
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.Database;

public class ProdutoDAO {
	
	public ProdutoDTO saveProduto(ProdutoDTO produtoDTO) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Produto" + "(id_usuario, nome, descricao) VALUES" + "(?,?,?)");

			psta.setLong(1, produtoDTO.getUsuario().getId());
			psta.setString(2, produtoDTO.getNome());			
			psta.setString(3, produtoDTO.getDescricao());			

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
		return produtoDTO;
	}
	
public ProdutoDTO updateProduto(ProdutoDTO produto) throws Exception {
		
		Connection conn = null;
		PreparedStatement psta = null;
		Integer pID = null;
		pID = produto.getId().intValue();

		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("UPDATE Produto SET nome =?, "
                    + "descricao =?"
                    + " WHERE id =?");
			
			psta.setString(1, produto.getNome());
			psta.setString(2, produto.getDescricao());
			psta.setInt(3, pID);

			psta.execute();

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
		return produto;
	}
	
	public String deleteProduto(String produtoId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;

		Integer pID = null;
		pID = Integer.parseInt(produtoId);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("delete from Produto where id = ?");
			psta.setInt(1, pID);
			
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
		
		return "Produto removido com sucesso.";
	}
	
	public List<ProdutoDTO> selectAllProductsByIdUser(String usuarioId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;
		Integer pID = null;
		pID = Integer.parseInt(usuarioId);
		List<ProdutoDTO> listPg = new ArrayList<ProdutoDTO>();

		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select p.id as id_prod, p.nome as nome_prod, p.descricao as desc_prod, p.data_criacao as dt_prod, u.id as id_usuario, u.foto as usuario_foto, u.nome as nome_usuario from produto p INNER JOIN usuario u on p.id_usuario = u.id where id_usuario = ?;");
			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				ProdutoDTO pg = new ProdutoDTO();
				pg.setId(rs.getLong("id_prod"));
				pg.setNome(rs.getString("nome_prod"));
				pg.setDescricao(rs.getString("desc_prod"));
				pg.setDataCriacao(rs.getDate("dt_prod"));
				pg.setUsuario(new UsuarioDTO(rs.getLong("id_usuario"), rs.getString("nome_usuario"), rs.getString("usuario_foto")));
				
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
	
	public ProdutoDTO selectProdutoById(String produtoId) throws Exception {
		// exemplo de select
		Connection conn = null;
		PreparedStatement psta = null;

		ProdutoDTO pg = null;
		Integer pID = null;
		pID = Integer.parseInt(produtoId);
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("select p.id as id_prod, p.nome as nome_prod, p.descricao as desc_prod, p.data_criacao as dt_prod, u.foto as usuario_foto,u.id as id_usuario, u.nome as nome_usuario from produto p INNER JOIN usuario u on p.id_usuario = u.id where p.id = ?;");
			psta.setInt(1, pID);

			ResultSet rs = psta.executeQuery();

			while (rs.next()) {
				pg = new ProdutoDTO();
				pg.setId(rs.getLong("id_prod"));
				pg.setNome(rs.getString("nome_prod"));
				pg.setDescricao(rs.getString("desc_prod"));
				pg.setDataCriacao(rs.getDate("dt_prod"));
				pg.setUsuario(new UsuarioDTO(rs.getLong("id_usuario"), rs.getString("nome_usuario"), rs.getString("usuario_foto")));

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
		return pg;
	}

}
