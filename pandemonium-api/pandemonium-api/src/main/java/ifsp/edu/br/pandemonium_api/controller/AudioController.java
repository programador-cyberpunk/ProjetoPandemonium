package com.pandemonium.controller;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.support.ResourceRegion;
import java.util.List;
import java.io.IOException;
import ifsp.edu.br.pandemonium_api.model.Audio;
import ifsp.edu.br.pandemonium_api.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")// pra liberar as rota dos bagulho
@RestController
@RequestMapping("/audio")
    public class AudioController{
    @Autowired
    private AudioService audioService;
        @PostMapping("/upload")
        public ResponseEntity<Audio> uploadAudio(@RequestParam("file") MultipartFile file,
              @RequestParam(value = "idUsuario", required = false, defaultValue = "1"){
            try{
                Audio audioSalvo = audioService.salvaAudio(file, idUsuario);
                    return ResponseEntity.ok(audioSalvo);
            }catch(IOException e){
                return ResponseEntity.internalServerError().build();
            }
        }
    @GetMapping
    public String listarAudios(){
        return "Lista dos audios";    }
}

    @GetMapping("/stream/{nomeArquivoSalvo}")
    public ResponseEntity<ResourceRegion> streamAudio(
            @PathVariable String nomeArquivoSalvo,
            @RequestHeader HttpHeaders headers){
        try{
            Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
            long contentLenght = recurso.contentLength();
            HttpRange range = headers.getRange().isEmpty() ? null : headers.get();
            ResourceRegion region;
                if(range !=null){
                    long start = range.getRangeStart(contentLength);
                    long end = range.getRangeEnd(contentLenght);
                    long rangeLength = Math.min(1024 * 1024L, end - start + 1);
                    region = new ResourceRegion(recurso, start, rangeLength);
                }else{
                    long rangeLength = Math.min(1024 * 1024L, contentLength);
                    region = new ResourceRegion(recurso, 0, rangeLength);
                }
             return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                     .contentType(MediaTypeFactory.getMediaType(recurso).orElse(MediaType.APPLICATION_OCTET_STREAM))
                             .body(region);
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }