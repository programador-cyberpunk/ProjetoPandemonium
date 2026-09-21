package ifsp.edu.br.pandemonium_api.repository;
import ifsp.edu.br.pandemonium_api.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AudioRepository extends JpaRepository<Audio, Long>{
    List<Audio> findByUsuarioId(Integer usuarioId);
}