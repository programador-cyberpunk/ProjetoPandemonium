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
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AudioService{
    private final Path pastaUploads = Paths.get("uploads", "audios");

    //agora o final vai injetar automaticamente o dados
    private final AudioRepository audioRepository;
    private final UsuarioRepository usuarioRepository;
    public Audio salvaAudio(MultipartFile arquivo, Long usuarioId)
        throws IOException{
            if(!Files.exists(pastaUploads)){
                Files.createDirectories(pastaUploads);
            }

    String nomeOriginal =  arquivo.getOriginalFilename();
    String extensao = "";
            if(nomeOriginal != null && nomeOriginal.contains(".")){
                extensao = nomeOriginal.substring(nomeOriginal.lastIndexOf("."));
            }
    String nomeArquivoSalvo = UUID.randomUUID().toString() + extensao;
    Path caminhoDestino = pastaUploads.resolve(nomeArquivoSalvo);
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

    //processa assincronamente pra extrair a duração e waveform
    processarAudio(caminhoDestino.toFile(), salvo.getId());
    return salvo;
    }
}