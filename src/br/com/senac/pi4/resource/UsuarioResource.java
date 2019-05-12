package br.com.senac.pi4.resource;

import java.io.ByteArrayInputStream;
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
import br.com.senac.pi4.model.UsuarioDTO;
import br.com.senac.pi4.services.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/usuario"})
@Path("/usuario")
public class UsuarioResource {
	
	UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Salva um usuario na base de dados",
	           response = UsuarioDTO.class)
	public Response saveUsuario(UsuarioDTO usuario) {
		try {
			usuario = usuarioServiceImpl.saveUsuario(usuario);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (usuario == null)
			return Response.status(404).entity("Usuario nao encontrado").build();

		return Response.status(200).entity(usuario).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna todos os usuarios disponiveis na base de dados",
	           response = UsuarioDTO.class)
	public Response selectAllUsuario() {
		List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
		try {
			usuarioDTOs = usuarioServiceImpl.selectAllUsuario();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (usuarioDTOs == null)
			return Response.status(404).entity(null).build();

		return Response.status(200).entity(usuarioDTOs).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna um usuario da base de dados de acordo com o parametro id passado",
	           response = UsuarioDTO.class)
	public Response selectUsuario(@PathParam("param") String usuarioId) {

		UsuarioDTO listPg = null;

		try {
			listPg = usuarioServiceImpl.selectUsuario(usuarioId);
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
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Faz o login do usurio na aplicacao",
	           response = UsuarioDTO.class)
	public Response login(UsuarioDTO usuarioDTO) {

		try {
			usuarioDTO = usuarioServiceImpl.login(usuarioDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (usuarioDTO == null)
			return Response.status(200).entity("Usuario nao encontrado").build();

		return Response.status(200).entity(usuarioDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/image/{param}")
	@Produces("image/jpg")
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Retorna uma imagem relacionada a um usuario",
	           response = UsuarioDTO.class)
	public Response selectImage(@PathParam("param") String usuarioId) {


		byte[] image = null;

		try {

			image = usuarioServiceImpl.selectImage(usuarioId);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			return Response.status(500).entity(e.getMessage()).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

		}
		if(image == null){
			return Response.status(400).entity("Imagem nula").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
		}
		return Response.status(200).entity(new ByteArrayInputStream(image)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Atualiza um usuario na base de dados",
	           response = UsuarioDTO.class)
	public Response updateProduto(UsuarioDTO usuarioDTO) {
		try {
			usuarioDTO = usuarioServiceImpl.updateUsuario(usuarioDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (usuarioDTO == null)
			return Response.status(404).entity("Usuario nao atualizado").build();

		return Response.status(200).entity(usuarioDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = UsuarioDTO.class)
	        
	   })
	   @ApiOperation(value = "Remove um usuario na base de dados",
	           response = UsuarioDTO.class)
	public Response deleteProduto(String usuarioId) {
		
		String resposta = null;
		try {
			resposta = usuarioServiceImpl.deleteUsuario(usuarioId);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (resposta == null)
			return Response.status(404).entity("Usuario nao removido").build();

		return Response.status(200).entity(resposta).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	
	
}
