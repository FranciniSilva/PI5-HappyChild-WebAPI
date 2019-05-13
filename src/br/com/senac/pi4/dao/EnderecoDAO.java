package br.com.senac.pi4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senac.pi4.model.EnderecoDTO;
import br.com.senac.pi4.services.Database;

public class EnderecoDAO {
	
	public EnderecoDTO saveEndereco(EnderecoDTO enderecoDTO) throws Exception {

		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = Database.get().conn();
			psta = conn.prepareStatement("INSERT INTO Endereco" + "(id_usuario, cep, logradouro, bairro, localidade, uf, latitude, longitude) VALUES" + "(?,?,?,?,?,?,?,?)");

			psta.setLong(1, enderecoDTO.getUsuario().getId());
			psta.setString(2, enderecoDTO.getCep());			
			psta.setString(3, enderecoDTO.getLogradouro());	
			psta.setString(4, enderecoDTO.getBairro());			
			psta.setString(5, enderecoDTO.getLocalidade());			
			psta.setString(6, enderecoDTO.getUf());			
			psta.setString(7, enderecoDTO.getLatitude());			
			psta.setString(8, enderecoDTO.getLongitude());			

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
		return enderecoDTO;
	}
	
	

}
