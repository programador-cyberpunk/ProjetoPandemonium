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

// pra tocar o audio, ou garantir seu funciionamento
@GetMapping
public ResponseEntity<List<Audio>> listar() {
    return ResponseEntity.ok(audioService.listarTodos());
}
    @GetMapping("/ouvir/{nomeArquivoSalvo}")
    public ResponseEntity<Resource> ouvirAudio(@PathVariable String nomeArquivoSalvo){
        try{
            Resource recurso = audioService.carregarArquivo(nomeArquivoSalvo);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\"" + recurso.getFilename() + "\"")
                    .contentType(MediaType.parseMediaType("audio/mpeg"))
                    .body(recurso);
        }  catch(IOException e){
           return ResponseEntity.notFound().build();
        }
    }