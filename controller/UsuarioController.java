package ifsp.edu.br.pandemonium_api.controller;
import ifsp.edu.br.pandemonium_api.model.Usuario;
import ifsp.edu.br.pandemonium_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario dados) { // Usando a própria classe Usuario para simplificar
        return repository.findByUsernameAndSenha(dados.getUsername(), dados.getSenha())
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.status(401).build());
    }

    @PostMapping("/add")
    public void add(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}

