package ifsp.edu.br.pandemonium_api.controller;
import ifsp.edu.br.pandemonium_api.repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController{
    @Autowired
    private UsuarioRepository repository;
        @PostMapping("/login")
    public ResponseEntity<?> login(RequestBody LoginDTO dados){
            return repository.findByUsernameAndSenha(dados.user(), dados.senha()){
                .map(u -> ResponseEntity.ok()u)
                        .orElse(ResponseEntity.status(401).build());
            }
        }
    }

