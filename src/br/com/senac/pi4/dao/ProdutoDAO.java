package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
