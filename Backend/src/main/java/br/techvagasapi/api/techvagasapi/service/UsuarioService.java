package br.techvagasapi.api.techvagasapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.techvagasapi.api.techvagasapi.model.Usuario;
import br.techvagasapi.api.techvagasapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {

        // Verifica se o email ja existe
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email ja cadastrado!");
        }

        // Salva o usuario no MongoDB
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
	
}
