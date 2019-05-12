package br.com.senac.pi4.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
*
* @author Francini
*/
@ApiModel(value = "Produto", description = "Classe que modela um objeto do tipo produto")
public class ProdutoDTO {
	
	private Long id;
	private UsuarioDTO usuario;
    private String nome;
    private String descricao;
    private Date dataCriacao;
    
    public ProdutoDTO() {	
    	super();
    }
    
    public ProdutoDTO(String nome, String descricao, UsuarioDTO usuario, Date dataCriacao) {
		this();
		this.usuario = usuario;
		this.descricao = descricao;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
	}

	@ApiModelProperty(value = "id do produto", required = true)
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

	@ApiModelProperty(value = "nome do produto", required = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ApiModelProperty(value = "descricao do produto", required = true)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ApiModelProperty(value = "data de criacao do produto", required = true)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
    

}
