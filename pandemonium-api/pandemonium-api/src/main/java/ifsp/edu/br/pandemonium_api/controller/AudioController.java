package ifsp.edu.br.pandemonium_api.controller;
import ifsp.edu.br.pandemonium_api.model.Audio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ifsp.edu.br.pandemonium_api.service.AudioService;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/audios")
@RequiredArgsConstructor
public class AudioController {
    private final AudioService audioService;

    //upload
    @PostMapping("/upload")
    public ResponseEntity<Audio> uploadAudio(
            @RequestParam("arquivo") MultipartFile arquivo,
            @RequestParam(value = "usuarioId", required = false) Long usuarioId)
                throws IOException{
                Audio audioSalvo = audioService.salvaAudio(arquivo, usuarioId);
                return ResponseEntity.status(HttpStatus.CREATED).body(audioSalvo);
    }

    //listagem
    @GetMapping("/arquivo/{nomeArquivoSalvo}")
    public ResponseEntity<Resource> carregarAudio(@PathVariable String nomeArquivoSalvo)
        throws IOException{
        Resource recurso = audioService.carregarAudio(nomeArquivoSalvo);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);

    }

    // deletar esas porra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaAudio(@PathVariable Long id)
        throws IOException{
            audioService.deletaAudio(id);
            return ResponseEntity.noContent().build();
    }
}