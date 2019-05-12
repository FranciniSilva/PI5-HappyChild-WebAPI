package br.com.senac.pi4.services;

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
}
