package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model store){
		this.model = store;
	}
	
	public void adicionarUsuario(){
		
		get("/usuarios/:username/:email/:senha/:descricao/:genero", (req, res) -> {
			model.cadastrarUsuario(req.params(":username"),req.params(":email"),req.params(":senha"),req.params(":descricao"),req.params(":genero"));
			return new Gson().toJson("Sucesso!");
		});
	}
	
	public void buscarUsuarioNome(){
		get("/usuario/:username", new Route() {
				@Override
		public Object handle(final Request request, final Response response) {
					
					response.header("Access-Control-Allow-Origin", "*");
					
					
					String username = request.params(":username");
					
					try {
						List<Usuario> usuarios = model.buscarUsuarioPorNome(username);
						
						JSONArray jsonResult = new JSONArray();
						
						
						
							for(Usuario usuario:usuarios) {
								JSONObject jsonObj = new JSONObject();
								jsonObj.put("username", usuario.getUsername());
								jsonObj.put("email", usuario.getEmail());
								jsonObj.put("senha", usuario.getSenha());
								jsonObj.put("descricao", usuario.getDescricao());
								jsonObj.put("genero", usuario.getGenero());
								
								jsonResult.put(jsonObj);
							}
							
							return jsonResult;
							
					} catch(JSONException e) {
						
						e.printStackTrace();
						
					}
				
					return null;
					
				}
		});
	}
	
	//public void logarUsuario(){
		//get("/usuario/:email/:senha", (req, res) -> {
			
			//List<Usuario> usuarioEncontrado = model.logar(new Login(req.params(":email"), req.params(":senha")));
			//return new Gson().toJson(usuarioEncontrado);
			
		//});
	//}
	
	//public void adicionarConteudo(){
	//	get("/conteudo/:tipo/:nome/:nota/:ano", (req, res) -> {
	//		
	//		model.cadastrarConteudo(new Conteudo(req.params(":tipo"), new Caracteristicas(req.params(":nome"), req.params(":nota"), req.params(":ano"))));
	//		return "";
	//		
	//	});
	//}
	
	//public void buscarConteudo(){
	//	get("/busca/:nome/:nota/:ano", (req, res) -> {
	//		
	//		Caracteristicas caract = new Caracteristicas(req.params(":nome"), req.params(":nota"), req.params(":ano"));	
	//		List<Conteudo> conteudosEncontrados = model.buscarConteudoPorCaracteristicas(caract);	
	//		return new Gson().toJson(conteudosEncontrados);
	//			
	//	});
	//}
	

	
	//public void buscarConteudoTipo(){
	//	get("/conteudo/:tipo", (req, res) -> {
	//	
	//		List<Conteudo> conteudosEncontrado = model.buscarConteudoPorTipo(req.params(":tipo"));	
	//		return new Gson().toJson(conteudosEncontrado);
	//		
	//	});
	//}
	
	//public void buscarConteudoNota() {
	//	get("/nota/:tipo/:nota", (req, res) -> {
	//	
	//		List<Conteudo> conteudosEncontrado = model.buscarConteudoPorNota(req.params(":tipo"), (req.params(":nota")));	
	//		return new Gson().toJson(conteudosEncontrado);
	//	});
	//}
	
	//public void buscarConteudoAno() {
	//	get("/ano/:tipo/:ano", (req, res) -> {
	//		
	//		List<Conteudo> conteudosEncontrado = model.buscarConteudoPorAno(req.params(":tipo"), (req.params(":ano")));	
	//		return new Gson().toJson(conteudosEncontrado);
	//	});
	//}
	
	//public void buscarConteudoNome() {
	//	get("/nome/:tipo/:nome", (req, res) -> {
	//		
	//		List<Conteudo> conteudosEncontrado = model.buscarConteudoPorNome(req.params(":tipo"), (req.params(":nome")));	
	//		return new Gson().toJson(conteudosEncontrado);
	//	});
	//}

}
