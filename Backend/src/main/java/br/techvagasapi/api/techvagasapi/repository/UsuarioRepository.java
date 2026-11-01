package br.techvagasapi.api.techvagasapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.techvagasapi.api.techvagasapi.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    Optional<Usuario> findByEmail(String email);

}
