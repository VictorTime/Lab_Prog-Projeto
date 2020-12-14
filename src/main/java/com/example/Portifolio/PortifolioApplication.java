package com.example.Portifolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Portifolio.model.repositorio.AtividadeRepositorio;
import com.example.Portifolio.model.repositorio.CurriculoRepositorio;
import com.example.Portifolio.model.repositorio.UsuarioRepositorio;
import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.Usuario;

@EnableWebMvc
@SpringBootApplication
public class PortifolioApplication  implements CommandLineRunner, WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry cors) {
		cors.addMapping("/**")
			.allowedMethods("GET", "PUT", "DELETE", "POST", "OPTIONS");
	}

	public static void main(String[] args) {
		SpringApplication.run(PortifolioApplication.class, args);
	}
	
	@Autowired
	private UsuarioRepositorio repository;

	@Autowired
	private CurriculoRepositorio curRepository;

	@Autowired 
	private AtividadeRepositorio atvRepository;
	

	@Override
    public void run(String...args) throws Exception {
        Usuario robson= this.repository.save(new Usuario(1,"a", "abc@gmail.com",1,"1"));
        this.repository.save(new Usuario(37183718,"Ramesh", "rameshsss@gmail.com",0,"1"));
		this.repository.save(new Usuario(99999999,"Ramesh", "rameshwwwww@gmail.com",1,"1"));
		
		Curriculo rob =this.curRepository.save(new Curriculo(1,"a", "a",robson));
		Atividade rep =this.atvRepository.save(new Atividade(1,"a","a","a","a", robson));
		Atividade rep2 =this.atvRepository.save(new Atividade(2,"b","b","b","b", robson));
    }
}	
