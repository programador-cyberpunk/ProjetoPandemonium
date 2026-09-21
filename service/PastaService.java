package ifsp.edu.br.pandemonium_api.service;
import ifsp.edu.br.pandemonium_api.model.Pasta;
import ifsp.edu.br.pandemonium_api.model.Usuario;
import ifsp.edu.br.pandemonium_api.repository.PastaRepository;
import ifsp.edu.br.pandemonium_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PastaService{
    @Autowired
    private PastaRepository pastaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

        public Pasta criarPasta(String nome, String descricao, Integer usuarioId){
            Usuario usuario = null;
            if(usuarioId != null){
                usuario = usuarioRepository.findById(usuarioId).orElse(null);
            }
            Pasta pasta = new Pasta();
            pasta.setNome(nome);
            pasta.setDescricao(descricao);
            pasta.setUsuario(usuario);
            pasta.setDataCriacao(LocalDateTime.now());
            return pastaRepository.save(pasta);
        }
        public List<Pasta> listarPorUsuario(Integer usuarioId){
            return pastaRepository.findByUsuarioId(usuarioId);
        }
        public Optional<Pasta> buscarPorId(Long id){
            return pastaRepository.findById(id);
        }
        public void deletaPasta(Long id){
            pastaRepository.deleteById(id);
        }
}