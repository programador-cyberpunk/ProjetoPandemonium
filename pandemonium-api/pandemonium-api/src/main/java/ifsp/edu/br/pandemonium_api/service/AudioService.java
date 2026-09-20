package ifsp.edu.br.pandemonium_api.service;
import ifsp.edu.br.pandemonium_api.model.Audio;
import ifsp.edu.br.pandemonium_api.model.Usuario;
import ifsp.edu.br.pandemonium_api.repository.AudioRepository;
import ifsp.edu.br.pandemonium_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import javax.sound.midi.Patch;
import javax.sound.sampled.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AudioService{
    private final Path pastaUpoloads = Paths.get("uploads", "audios");

   @Autowired
   private AudioRepository audioRepository;

   @Autowired
    private UsuarioRepository usuarioRepository;

    public Audio salvarAudio(MultipartFile arquivo, Integer usuarioId) throws  IOException{
        if(!Files.exists(pastaUpoloads)){
            Files.createDirectories(pastaUpoloads);
        }
    String nomeOriginal = arquivo.getOriginalFilename();
        String extensao = "";
       if(nomeOriginal != null && nomeOriginal.contains(".")){
           extensao = nomeOriginal.substring(nomeOriginal.lastIndexOF("."));
       }

       String nomeArquivoSalvo = UUID.randomUUID().toString() + extensao;
       Path caminhoDestino = pastaUpoloads.resolve(nomeArquivoSalvo);
       Files.copy(arquivo.getInputStream(), caminhoDestino, StandardCopyOption.REPLACE_EXISTING);

       Usuario usuario = null;
        if(usuarioId != null){
            usuario = usuarioRepository.findById(usuarioId).orElse(null);
        }

        Audio audio = new Audio();
        audio.setNomeOriginal(nomeOriginal);
        audio.setNomeArquivoSalvo(nomeArquivoSalvo);
        audio.setUsuario(usuario);
        audio.setTipoConteudo(arquivo.getContentType());
        audio.setTamanho(arquivo.getSize());

        Audio salvo = audioRepository.save(audio);

        //processo de duração assincrono em wavefgrm
        processarAudio(caminhoDestino.toFile(), salvo.getId());
        return salvo;
    }

    // ta no nome ja ne caralho
    public List<Audio> listarAudios(){
        return audioRepository.findAll();
    }

    //loadar os arquivos de audio
    public Resource carregarAudio(String nomeArquivoSalvo) throws IOException{
        Path caminhoArquivo = pastaUpoloads.resolve(nomeArquivoSalvo).normalize();
        Resource recurso = new UrlResource(caminhoArquivo.toUri());

           if(recurso.exists() && recurso.isReadable()){
               return recurso;
           }else{
               throw new FileNotFoundException("Audio nao encontrado: " + nomeArquivoSalvo);
           }
    }

    public void deletarAudio(Long id) throws IOException{
        Audio audio = audioRepository.findById(id).orElseThrow(()-> new FileNotFoundException("ID do audio: " + id + "nao foi encontrado"));
        Path caminhoArquivo = pastaUpoloads.resolve(audio.getNomeArquivoSalvo()).normalize();
        Files.deleteIfExists(caminhoArquivo);
        audioRepository.deleteById(id);
    }

    @Async
}