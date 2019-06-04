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
		get("/usuario/:username", (req, res) -> {
			List<Usuario> usuariosEncontrados = model.buscarUsuarioPorNome(req.params(":username"));	
			return new Gson().toJson(usuariosEncontrados);
		});
	}
	
	//public void logarUsuario(){
		//get("/usuario/:email/:senha", (req, res) -> {
			
			//List<Usuario> usuarioEncontrado = model.logar(new Login(req.params(":email"), req.params(":senha")));
			//return new Gson().toJson(usuarioEncontrado);
			
		//});
	//}
	
	public void adicionarConteudo(){
		
		get("/conteudos/:tipo/:nome/:nota/:ano", (req, res) -> {
			model.cadastrarConteudo(req.params(":tipo"),req.params(":nome"),req.params(":nota"),req.params(":ano"));
			return new Gson().toJson("Sucesso!");
		});
	}
	
	public void buscarConteudo(){
		get("/conteudo/:tipo/:nome", (req, res) -> {
			List<Conteudo> conteudosEncontrados = model.buscarConteudo(req.params(":tipo"), req.params(":nome"));	
			return new Gson().toJson(conteudosEncontrados);
		});
	}
	
	public void buscarConteudoPorTipo(){
		get("/conteudo/:tipo", (req, res) -> {
			List<Conteudo> conteudosEncontrados = model.buscarConteudoPorTipo(req.params(":tipo"));	
			return new Gson().toJson(conteudosEncontrados);
		});
	}
	

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
