package br.com.senac.pi4.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.pi4.model.CategoriaDTO;
import br.com.senac.pi4.model.ProdutoDTO;
import br.com.senac.pi4.services.CategoriaServiceImpl;
import br.com.senac.pi4.services.ProdutoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"/categoria"})
@Path("/categoria")
public class CategoriaResource {
		
	CategoriaServiceImpl categoriaServiceImpl = new CategoriaServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiResponses(value = {
	           @ApiResponse(code = 200, message =  "Service executed without errors", response = CategoriaDTO.class)
	        
	   })
	   @ApiOperation(value = "Salva uma categoria na base de dados",
	           response = CategoriaDTO.class)
	public Response saveProduto(CategoriaDTO categoriaDTO
			) {
		try {
			categoriaDTO = categoriaServiceImpl.saveCategoria(categoriaDTO);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		if (categoriaDTO == null)
			return Response.status(404).entity("Categoria nao encontrada").build();

		return Response.status(200).entity(categoriaDTO
				).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
	}


}
