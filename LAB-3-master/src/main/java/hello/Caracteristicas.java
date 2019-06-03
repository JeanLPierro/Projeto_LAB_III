package hello;

public class Caracteristicas {

	
	private String nome;
	private String nota;
	private String ano;
	
	public Caracteristicas(String nome, String nota, String ano) {
	this.nome = nome;
	this.nota = nota;
	this.ano = ano;
	}
	
	public String getNome() {
	return nome;
	}
	
	public void setNome(String nome) {
	this.nome = nome;
	}
	
	public String getNota() {
	return nota;
	}
	
	public void setNota(String nota) {
	this.nota = nota;
	}
	
	public String getAno() {
		return ano;
	}
		
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public boolean comparar(Caracteristicas caracteristicas){
	if(this.nome.equals(caracteristicas.nome) && this.nota.equals(caracteristicas.nota) && this.ano.equals(caracteristicas.ano)){
	return true;
	} else {
	return false;
	}
	}
	
}
