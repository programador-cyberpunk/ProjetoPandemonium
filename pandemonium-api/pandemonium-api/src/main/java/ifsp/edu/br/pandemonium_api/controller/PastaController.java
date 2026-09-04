package ifsp.edu.br.pandemonium_api.controller;
import ifsp.edu.br.pandemonium_api.model.Pasta;
import ifsp.edu.br.pandemonium_api.service.PastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pastas")
@CrossOrigin(origins = "*")
public class PastaController {
    @Autowired
    private PastaService pastaService;

    @PostMapping
    public ResponseEntity<Pasta> criarPasta(
            @RequestParam("nome") String nome,@RequestParam(value = "descricao", required = false)
            String descricao,
            @RequestParam(value = "usuarioId", required = false) Integer usuarioId)
    Pasta pasta = pastaService.criarPasta(nome, descricao,usuarioId);
    return ResponseEntity.ok(pasta);
    }
    
@GetMapping("/usuario/{usuario}")
public ResponseEntity<List<Pasta>> listarPorUsuario(@PathVariable Integer usuarioId){
    return ResponseEntity.ok(pastas);
}
