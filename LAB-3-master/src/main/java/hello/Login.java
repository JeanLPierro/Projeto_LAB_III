package hello;

public class Login {
	
	
	private String email;
	private String senha;
	
	
	
	public Login(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
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
	
	public boolean match(Login log){
		if(email.equals(log.email) && senha.equals(log.senha)) return true;
		else return false;
	}
}
