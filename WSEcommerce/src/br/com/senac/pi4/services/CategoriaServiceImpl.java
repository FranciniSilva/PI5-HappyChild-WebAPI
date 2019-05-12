package br.com.senac.pi4.services;

import br.com.senac.pi4.dao.CategoriaDAO;
import br.com.senac.pi4.model.CategoriaDTO;

public class CategoriaServiceImpl {
	
	CategoriaDAO categoriaDAO = new CategoriaDAO();

	public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) throws Exception {
		return categoriaDAO.saveCategoria(categoriaDTO);
	}
}
