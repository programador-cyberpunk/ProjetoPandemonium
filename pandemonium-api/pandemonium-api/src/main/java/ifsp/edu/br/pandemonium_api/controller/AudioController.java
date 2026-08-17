package com.pandemonium.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaTypeFactory;
import org.springframework.core.io.support,ResourceRegion;

@CrossOrigin(origins = "*")// pra liberar as rota dos bagulho
@RestController
@RequestMapping("/audios")
    public class AudioController{

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