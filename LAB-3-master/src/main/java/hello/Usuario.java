package hello;

import java.util.LinkedList;
import java.util.List;

public class Usuario {

	
	private String username;
	private String email;
	private String senha;
	private String descricao;
	private String genero;
	private List<Conteudo> conteudouser;
	
	public Usuario(String username, String email, String senha, String descricao, String genero) {
		super();
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.genero = genero;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Conteudo> getConteudouser() {
		return conteudouser;
	}

	public void setConteudouser(List<Conteudo> conteudouser) {
		this.conteudouser = conteudouser;
	}
	
}
	
	
