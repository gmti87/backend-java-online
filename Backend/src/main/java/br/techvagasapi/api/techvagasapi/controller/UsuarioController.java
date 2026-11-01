package br.techvagasapi.api.techvagasapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.techvagasapi.api.techvagasapi.model.Usuario;
import br.techvagasapi.api.techvagasapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")

@CrossOrigin(origins = "*")

public class UsuarioController {
	
	private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Cadastrar usuario
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    // Listar usuarios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }
    
}
