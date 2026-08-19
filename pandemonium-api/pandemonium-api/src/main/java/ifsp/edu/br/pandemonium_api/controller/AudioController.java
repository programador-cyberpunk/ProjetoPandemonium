package ifsp.edu.br.pandemonium-api.controller;
import ifsp.edu.br.pandemonium-api.model.Audio;
import org.springframework.beans.factoryannotation.Autowired;
import ifsp.edu.br.pandemonium-api.service.AudioService;
import org.springfreamework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bin.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@CrossOrifin(origins = "*") //pro front
@RestController
@RequestMapping("/api/audios")
    public class AudioController{

@Autowired
private AudioService audioservice;
    //rota de upload
    @PostMapping("/upload")
    public ResponseEntity<Audio> uploadAudio(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "idUsuario", required = false ,defaultValue =  "1" ) Integer idUsuario){
        try{
            Audio audioSalvo = audioService.salvarAudio(file, idUsuario);
            return ResponseEntity.ok(audioSalvo);
        } catch(IOException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    // rota das listas
   @GetMapping
   public ResponseEntity<List<Audio>> listar(){
        return ResponseEntity.ok(audioService.listarTodos());
   }

// PRA TOCAR O ADIO NO APP
@GetMapping("/ouvir/{nomeArquivoSalvo}")
public ResponseEntity<Resource> ouvirAudio(@PathVariable String nomeArquivoSalvo){
        try{
          Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
          return ResponseEntity.ok()
                  .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + recurso.getFilename() + "\"")
                  .contentType(MediaType.parseMediaType("audio/mpeg"))
                  .body(recurso);
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
}

@GetMapping("/stream/{nomeArquivoSalvo}")
    public ResponseEntity<ResourceRegion> streamAudio(
            @PathVariable String nomeArquivoSalvo,
            @RequestHeaders headers) {
        try{
            Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
            long contentLength = recurso.contentLength();

            HttpRange range = headers.getRange().isEmpty() ? null : headers.getRange().get(0);
            ResourceRegion region;

                if(range != null){
                    long start = range.getRangeStart(contentLength);
                    long end = range.getRangeEnd(contentLength);
                    long rangeLength = Math.min(1024 * 1024, end - start + 1);
                    region = new ResourceRegion(recurso, start, rangeLength);
                }else{
                    long rangeLentgh = Math,min(1024 * 1024L, contentLength);
                    region = new ResourceRegion(recurso, 0 ,rangeLentgh);
                }
             return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                     .contentType(MediaTypeFactory.getMediaType(recurso))
                     .body(region);
        }catch(IOException e){
            return ResponseEntity.notFound().build();
        }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarAudioo(@PathVariable Long id){
        try{
            audioService.deletarAudio(id);
            return ReponseEntity.noContent().build();
        }catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }
)
}