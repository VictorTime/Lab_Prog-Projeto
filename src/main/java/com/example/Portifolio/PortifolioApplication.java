package com.example.Portifolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Portifolio.model.repositorio.UsuarioRepositorio;
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

	@Override
    public void run(String...args) throws Exception {
        this.repository.save(new Usuario(37777283,"Ramesh", "rameshffff@gmail.com",0,"kkaksdj"));
        this.repository.save(new Usuario(37183718,"Ramesh", "rameshsss@gmail.com",0,"kkaksdj"));
        this.repository.save(new Usuario(99999999,"Ramesh", "rameshwwwww@gmail.com",1,"masmdmas"));
    }
}	
