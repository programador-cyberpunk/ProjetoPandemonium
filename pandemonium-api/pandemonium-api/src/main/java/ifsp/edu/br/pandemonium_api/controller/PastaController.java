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
    public class PastaController{
   @Autowired
   private PastaService pastaService;

   @PostMapping
   public ResponseEntity<Pasta> criarPasta(
          @RequestParam("nome") String nome,
          @RequestParam(value = "descricao", required = false) String descricao,
          @RequestParam(value = "usuarioId", required = false) Integer usuarioId){

       Pasta pasta = pastaService.criarPasta(nome, descricao, usuarioId);
       return ResponseEntity.ok(pasta);
   }
   @GetMapping("/usuarios/{usuarioId}")
   public ResponseEntity<List<Pasta>> listarPorUsuario(@PathVariable("usuarioId") Integer usuarioId){
       List<Pasta> lista = pastaService.listarPorUsuario(usuarioId);
       return ResponseEntity.ok(lista);
   }
   @GetMapping("/{id}")
    public ResponseEntity<Pasta> buscarPorId(@PathVariable("id") Long id){
            return pastaService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleta(@PathVariable("id") Long id){
       pastaService.deletaPasta(id);
       return ResponseEntity.noContent().build();
    }

}