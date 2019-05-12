package br.com.senac.pi4.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.ChatDTO;
import br.com.senac.pi4.services.ChatServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(tags = {"/chat"})
@Path("/chat")
public class ChatResource {
	
	ChatServiceImpl chatServiceImpl = new ChatServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ChatDTO.class)
	        
	   })
	   @ApiOperation(value = "Associa um comentario de um usuario a um produto",
	           response = ChatDTO.class)
	public Response saveComentario(ChatDTO chatDTO) {
		try {
			chatDTO = chatServiceImpl.saveComentario(chatDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (chatDTO == null)
			return Response.status(404).entity("Comentario nao foi inserido").build();
		
		return Response.status(200).entity(chatDTO).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}
	
	@GET
	@Path("/chatByIdUsuario/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = ChatDTO.class)
	        
	   })
	   @ApiOperation(value = "seleciona todos os comentarios de um historico de um usuario especifico",
	           response = ChatDTO.class)
	public Response getAllComentariosByIdUsuario(@PathParam("param") String idUsuario) {

		List<ChatDTO> listPg = null;

		try {
			listPg = chatServiceImpl.getAllChatByIdUsuario(idUsuario);
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
