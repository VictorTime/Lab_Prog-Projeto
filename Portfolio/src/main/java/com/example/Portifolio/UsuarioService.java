package com.example.Portifolio;

@Service // Para ser Service no Spring
public class UsuarioService {

    @Autowired  // injeção de dependência
    UsuarioRepository repository;
}