package ifsp.edu.br.pandemonium_api.repository;
import ifsp.edu.br.pandemonium_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username, String senha);
}
