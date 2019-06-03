package hello;

import static spark.Spark.*;


public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

        inicializarConteudos();
        
        
		//Servir conteudo html, css e javascript
		staticFileLocation("/static");


		Controller controller = new Controller(model);
		
		//controller.buscarConteudo();
		//controller.buscarConteudoTipo();
		//controller.adicionarConteudo();
		//controller.buscarConteudoNota();
		//controller.buscarConteudoAno();
		//controller.buscarConteudoNome();
		controller.adicionarUsuario();//usar esse metodo para a criacao da view de cadastro de usuario
		controller.buscarUsuarioNome();//metodo de teste da classe usuario(remover apos termino dos metodos relacionados a classe)
		//controller.logarUsuario();
    }
    
    public static void inicializarConteudos(){
    	//model.cadastrarConteudo(new Conteudo("Serie", new Caracteristicas("Friends", "10", "1999")));
    	
    	//model.cadastrarConteudo(new Conteudo("Filme", new Caracteristicas("Pulp Fiction", "9", "1984")));
    	
    	//model.cadastrarConteudo(new Conteudo("Serie", new Caracteristicas("Doctor Who", "9", "2000")));
    	
    	//model.cadastrarConteudo(new Conteudo("Podcast", new Caracteristicas("NerdCast", "9", "2018")));
    	
    	//model.cadastrarConteudo(new Conteudo("Filme", new Caracteristicas("Matrix", "9", "1999")));
    	
    	//inicializacao de usuarios
    	model.cadastroUsuario(new Usuario("Sgt.Pepper", "yellowsub@gmail.com", "SunKing", "Happiness is a warm gun", "Masculino"));

    	model.cadastroUsuario(new Usuario("Mr. Mojo Risin", "lizzardking@gmail.com", "MorrisonHotel", "People Are Strange", "Masculino"));

    }
}
