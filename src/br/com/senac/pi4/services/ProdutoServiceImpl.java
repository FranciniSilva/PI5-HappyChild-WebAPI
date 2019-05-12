package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.ProdutoDAO;
import br.com.senac.pi4.model.ProdutoDTO;

public class ProdutoServiceImpl {
	ProdutoDAO produtoDAO = new ProdutoDAO();

	public ProdutoDTO saveProduto(ProdutoDTO produtoDTO) throws Exception {
		return produtoDAO.saveProduto(produtoDTO);
	}
}
