package br.com.senac.pi4.services;

import java.util.List;

import br.com.senac.pi4.dao.ProdutoDAO;
import br.com.senac.pi4.model.ProdutoDTO;
import br.com.senac.pi4.model.UsuarioDTO;

public class ProdutoServiceImpl {
	ProdutoDAO produtoDAO = new ProdutoDAO();

	public ProdutoDTO saveProduto(ProdutoDTO produtoDTO) throws Exception {
		return produtoDAO.saveProduto(produtoDTO);
	}
	
	public ProdutoDTO updateProduto(ProdutoDTO produtoDTO) throws Exception {
		return produtoDAO.updateProduto(produtoDTO);
	}
	
	public String deleteProduto(String produtoId) throws Exception {
		return produtoDAO.deleteProduto(produtoId);
	}
	
	public List<ProdutoDTO> selectAllProductsByIdUser(String usuarioId) throws Exception {
		return produtoDAO.selectAllProductsByIdUser(usuarioId);
	}
	
	public ProdutoDTO selectProdutoById(String produtoId) throws Exception {
		return produtoDAO.selectProdutoById(produtoId);
	}
}
