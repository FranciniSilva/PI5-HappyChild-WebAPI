package br.com.senac.pi4.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Categoria", description = "Classe que modela um objeto do tipo categoria")
public class CategoriaDTO {
	
	private Long id;
    private String nome;
    
	@ApiModelProperty(value = "id da categoria", required = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "nome da categoria", required = true)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    

}
