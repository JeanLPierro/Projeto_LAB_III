package hello;

public class Conteudo {

	private String tipo;
	private Caracteristicas caract;
	
	public Conteudo(String tipo, Caracteristicas caract) {
	this.tipo = tipo;
	this.caract = caract;
	}
	
	public String getTipo() {
	return tipo;
	}
	
	public void setTipo(String tipo) {
	this.tipo = tipo;
	}
	
	public Caracteristicas getCaract() {
	return caract;
	}
	
	public void setCaract(Caracteristicas caract) {
	this.caract = caract;
	}
	
}
