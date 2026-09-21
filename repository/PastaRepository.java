package ifsp.edu.br.pandemonium_api.repository;
import ifsp.edu.br.pandemonium_api.model.Pasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PastaRepository extends JpaRepository<Pasta, Long>{
    List<Pasta> findByUsuarioId(Integer usuarioId);
}
