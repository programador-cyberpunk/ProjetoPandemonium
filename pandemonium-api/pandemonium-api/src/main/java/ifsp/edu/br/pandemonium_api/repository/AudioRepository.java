package ifsp.edu.br.pandemonium-api.repository;
import ifsp.edu.br.pandemonium-api.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.list;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long>{
    List<Audio> findByUsuarioId(Integer usuarioId;)
}