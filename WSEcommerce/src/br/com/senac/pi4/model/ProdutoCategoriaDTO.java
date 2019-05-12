package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
*
* @author Francini
*/
@ApiModel(value = "ProdutoCategoria", description = "Classe que modela um objeto do tipo produto_categoria")
public class ProdutoCategoriaDTO {
	
	private Long id;
	private ProdutoDTO idProduto;
	private CategoriaDTO idCategoria;
	
	@ApiModelProperty(value = "id produto_categoria", required = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "id produto", required = true)
	public ProdutoDTO getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(ProdutoDTO idProduto) {
		this.idProduto = idProduto;
	}
	
	@ApiModelProperty(value = "id categoria", required = true)
	public CategoriaDTO getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(CategoriaDTO idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	
	


}
