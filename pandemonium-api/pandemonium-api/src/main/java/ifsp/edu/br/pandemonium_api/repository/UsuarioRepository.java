package ifsp.edu.br.pandemonium_api.repository;
import ifsp.edu.br.pandemonium_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public class UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsernameAndAndSenha(String username, String senha){
        return findByUsernameAndAndSenha(username, senha);
    }
}
