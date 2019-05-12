package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senac.pi4.model.CategoriaDTO;
import br.com.senac.pi4.services.Database;

public class CategoriaDAO {
	
	public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Categoria" + "(nome) VALUES" + "(?)");

			psta.setString(1, categoriaDTO.getNome());
			
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
		return categoriaDTO;
	}

}
