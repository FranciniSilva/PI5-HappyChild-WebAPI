package br.com.senac.pi4.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Chat", description = "Classe que modela um objeto do tipo chat")
public class ChatDTO {
	
	private Long id;
	private UsuarioDTO usuario;
	private ProdutoDTO produto;
	private String texto;
	private Date dataCriacao;
	
	@ApiModelProperty(value = "id do chat", required = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "id do usuario", required = true)
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	@ApiModelProperty(value = "id do produto", required = true)
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	
	@ApiModelProperty(value = "texto do chat", required = true)
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@ApiModelProperty(value = "data de criacao do texto", required = true)
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	

}
