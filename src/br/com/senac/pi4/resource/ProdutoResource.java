package br.com.senac.pi4.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.ProdutoDTO;
import br.com.senac.pi4.services.ProdutoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/produto"})
@Path("/produto")
public class ProdutoResource {
	
	ProdutoServiceImpl produtoServiceImpl = new ProdutoServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ProdutoDTO.class)
	        
	   })
	   @ApiOperation(value = "Salva um produto na base de dados",
	           response = ProdutoDTO.class)
	public Response saveProduto(ProdutoDTO produtoDTO) {
		try {
			produtoDTO = produtoServiceImpl.saveProduto(produtoDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (produtoDTO == null)
			return Response.status(404).entity("Produto nao encontrado").build();

		return Response.status(200).entity(produtoDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ProdutoDTO.class)
	        
	   })
	   @ApiOperation(value = "Atualiza um produto na base de dados",
	           response = ProdutoDTO.class)
	public Response updateProduto(ProdutoDTO produtoDTO) {
		try {
			produtoDTO = produtoServiceImpl.updateProduto(produtoDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (produtoDTO == null)
			return Response.status(404).entity("Produto nao atualizado").build();

		return Response.status(200).entity(produtoDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@DELETE
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ProdutoDTO.class)
	        
	   })
	   @ApiOperation(value = "Remove um produto na base de dados",
	           response = ProdutoDTO.class)
	public Response deleteProduto(@PathParam("param") String produtoId) {
		
		String resposta = null;
		try {
			resposta = produtoServiceImpl.deleteProduto(produtoId);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (resposta == null)
			return Response.status(404).entity("Produto nao removido").build();

		return Response.status(200).entity(resposta).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/getAllProductsById/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ProdutoDTO.class)
	        
	   })
	   @ApiOperation(value = "Seleciona todos os produtos postados pelo usuario",
	           response = ProdutoDTO.class)
	public Response selectAllProductsByIdUser(@PathParam("param") String produtoId) {
		
		List<ProdutoDTO> historiaDTOs = new ArrayList<ProdutoDTO>();
		try {
			historiaDTOs = produtoServiceImpl.selectAllProductsByIdUser(produtoId);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (historiaDTOs == null)
			return Response.status(404).entity("Nenhum produto foi encontrado").build();

		return Response.status(200).entity(historiaDTOs).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ProdutoDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna um produto da base de dados de acordo com o parametro id passado",
	           response = ProdutoDTO.class)
	public Response selectUsuario(@PathParam("param") String produtoId) {

		ProdutoDTO listPg = null;

		try {
			listPg = produtoServiceImpl.selectProdutoById(produtoId);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (listPg == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(listPg).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}

}
