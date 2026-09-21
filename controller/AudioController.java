package ifsp.edu.br.pandemonium_api.controller;
import ifsp.edu.br.pandemonium_api.model.Audio;
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

@CrossOrigin(origins = "*") //pro front
@RestController
@RequestMapping("/api/audios")

public class AudioController{
    @Autowired
    private AudioService audioService;

    // primeiro, rota do upload
    @PostMapping("/upload")
    public ResponseEntity<Audio> upoloadAudio(@RequestParam("file")MultipartFile file,
                                              @RequestParam(value = "usuarioId", required = false, defaultValue = "1") Integer usuarioId){

        try{
            Audio audioSalvo = audioService.salvaAudio(file, usuarioId);
            return ResponseEntity.ok(audioSalvo);
    } catch(IOException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    //rota de listas
    @GetMapping
    public ResponseEntity<List<Audio>> listarAudio(){
        return ResponseEntity.ok(audioService.listarAudio());
    }

    // a parte mais treta, tocar o audio direto no app
    @GetMapping("/ouvir/{nomeArquivoSalvo}")
    public ResponseEntity<Resource> ouvirAudio(@PathVariable String nomeArquivoSalvo){
        try{
            Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + recurso.getFilename() + "\"")
                    .contentType(MediaType.parseMediaType("audio/mpeg"))
                    .body(recurso);
        } catch (IOException e){
            return ResponseEntity.notFound().build();
        }
    }


    // rota pra rodar a musica em pedaços
    @GetMapping("/stream/{nomeArquivoSalvo}")
    public ResponseEntity<ResourceRegion> streamAudio(
            @PathVariable String nomeArquivoSalvo,
            @RequestHeader HttpHeaders headers){
        try{
            Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
            long contentLength = headers.getContentLength();
            HttpRange range = headers.getRange().isEmpty() ? null : headers.getRange().get(0);
            ResourceRegion region;
                if(range != null){
                    long start = range.getRangeStart(contentLength);
                    long end = range.getRangeEnd(contentLength);
                    long rangeLength = Math.min(1024 * 1024L, end - start + 1);
                    region = new ResourceRegion(recurso, start, rangeLength);
                }else{
                    long rangeLength = Math.min(1024 * 1024L, contentLength);
                    region = new ResourceRegion(recurso, 0, rangeLength);
                }

            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                    .contentType(MediaTypeFactory.getMediaType(recurso).orElse(MediaType.parseMediaType("audio/mpeg")))
                    .body(region);
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }
    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAudio(@PathVariable Long id){
        try{
           audioService.deletarAudio(id);
           return ResponseEntity.noContent().build();
        } catch (IOException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}