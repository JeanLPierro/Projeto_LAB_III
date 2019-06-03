package hello;


import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model {
	
	ObjectContainer usuariosbd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
	ObjectContainer conteudosbd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/conteudos.db4o");
	ObjectContainer caracteristicasbd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/caracteristicas.db4o");

		
	
	public boolean cadastroUsuario(Usuario usuario){
		if(isUsuarioDisponivel(usuario.getEmail())) {
			usuariosbd.store(usuario);
			usuariosbd.commit();
			return true;
		}
		return false;
	}
	
	public void cadastrarUsuario(String username, String email, String senha, String descricao, String genero) {

		cadastroUsuario(new Usuario (username, email, senha, descricao, genero));
	}
	
	public boolean isUsuarioDisponivel(String email){
		Query query = usuariosbd.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> Usuariosbd = query.execute();
		
;		for(Usuario usuario:Usuariosbd){
			if(usuario.getEmail().equals(email)) {
				return false; 
			}
		}
		return true;
	}
	
	
	//public List<Usuario> logar(Login log) {
		//List<Usuario> UsuarioEncontrado = new LinkedList<Usuario>();
		//for(Usuario usuario:usuarios){
		//if(usuario.getLog().match(log)) UsuarioEncontrado.add(usuario);
		//}
		//return UsuarioEncontrado;
	//}
	
	
	public List<Usuario> buscarUsuarioPorNome(String username){
		List<Usuario> result = new LinkedList<Usuario>();
		
		Query query =  usuariosbd.query();
		query.constrain(Usuario.class);
		
		ObjectSet<Usuario> allUsuariosbd = query.execute();
		
		for(Usuario usuario:allUsuariosbd) {
			if(usuario.getUsername().equals(username)) result.add(usuario);
			
		}
		
		 return result;
	}
	
	
	//public void cadastrarConteudo(Conteudo conteudo){
	//	if(verificarConteudoRepetido(conteudo.getCaract())) {
	//		//conteudos.add(conteudo);
	//	}
	//}
	
	
	//public boolean verificarConteudoRepetido(Caracteristicas caract){
	//	for(Conteudo conteudo:conteudos){
	//		if(conteudo.getCaract().comparar(caract)) return false; 
	//	}
	//	return true;
	//}
	
	
	//public List<Conteudo> buscarConteudoPorTipo(String tipo){
	//List<Conteudo> conteudosEncontrados = new LinkedList<Conteudo>();
	//for(Conteudo conteudo:conteudos){
	//if(conteudo.getTipo().equals(tipo)) conteudosEncontrados.add(conteudo);
	//}
	//return conteudosEncontrados;
	//}
	
	
	//public List<Conteudo> buscarConteudoPorCaracteristicas(Caracteristicas caract){
	//List<Conteudo> conteudosEncontrados = new LinkedList<Conteudo>();
	//for(Conteudo conteudo:conteudos){
	//if(conteudo.getCaract().comparar(caract)) conteudosEncontrados.add(conteudo);
	//}
	//return conteudosEncontrados;
	//}
	
	
	//public List<Conteudo> buscarConteudoPorNota(String tipo, String nota){
	//	List<Conteudo> conteudosEncontrados = new LinkedList<Conteudo>();
	//	for(Conteudo conteudo:conteudos){
	//	if(conteudo.getTipo().equals(tipo) && conteudo.getCaract().getNota().equals(nota)) conteudosEncontrados.add(conteudo);
	//	}
	//	return conteudosEncontrados;
	//	}
	
	
	//public List<Conteudo> buscarConteudoPorAno(String tipo, String ano){
	//	List<Conteudo> conteudosEncontrados = new LinkedList<Conteudo>();
	//	for(Conteudo conteudo:conteudos){
	//	if(conteudo.getTipo().equals(tipo) && conteudo.getCaract().getAno().equals(ano)) conteudosEncontrados.add(conteudo);
	//	}
	//	return conteudosEncontrados;
	//	}
	
	
	//public List<Conteudo> buscarConteudoPorNome(String tipo, String nome){
	//	List<Conteudo> conteudosEncontrados = new LinkedList<Conteudo>();
	//	for(Conteudo conteudo:conteudos){
	//	if(conteudo.getTipo().equals(tipo) && conteudo.getCaract().getNome().equals(nome)) conteudosEncontrados.add(conteudo);
	//	}
	//	return conteudosEncontrados;
	//	}
	
	
	//public List<Conteudo> getConteudos(){
	//return conteudos;
	//}

}
