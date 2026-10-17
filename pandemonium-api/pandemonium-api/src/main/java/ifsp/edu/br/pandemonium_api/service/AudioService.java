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
               usuario = usuarioRepository.findById(usuarioId.intValue()).orElse(null);
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

   public List<Audio> listarAudio(){
        return audioRepository.findAll();
   }

   public Resource carregarAudio(String nomeArquivoSalvo)
           throws IOException{
        Path caminhoArquivo = pastaUploads.resolve(nomeArquivoSalvo).normalize();
        Resource recurso = new UrlResource(caminhoArquivo.toUri());

            if(recurso.exists() && recurso.isReadable()){
                return recurso;
            } else{
                throw new FileNotFoundException("Deu bosta, arquivo nao encontrado: " + nomeArquivoSalvo);
            }
   }
   public void deletaAudio(Long id) throws IOException {
       Audio audio = audioRepository.findById(id)
               .orElseThrow(() -> new FileNotFoundException("ID do som: " + id + "que nao foi encontrado"));

       Path caminhoArquivo = pastaUploads.resolve(audio.getNomeArquivoSalvo()).normalize();
       Files.deleteIfExists(caminhoArquivo);
       audioRepository.deleteById(id);
   }

@Async
public CompletableFuture<Void> processarAudio(File arquivoAqudio, Long audioId) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivoAqudio);
        AudioFormat format = audioInputStream.getFormat();
        Long totalFrames = audioInputStream.getFrameLength();

        float segundos = totalFrames / format.getSampleRate();
        byte[] bytes = audioInputStream.readAllBytes();
        List<Integer> waveform = extrairPicos(bytes, 100);

        audioRepository.findById(audioId).ifPresent(audio -> {
            audio.setDuracao(segundos);
            audio.setWavefromJson(waveform.toString());
            audioRepository.save(audio);
        });
        audioInputStream.close();
    } catch (UnsupportedAudioFileException | IOException e) {
        System.err.println("Erro ao processar o audio: " + e.getMessage());
    }
    return CompletableFuture.completedFuture(null);
}
// pra selecionar minutagem
private List<Integer> extrairPicos(byte[] audioBytes, int pontosDesejados) {
    List<Integer> picos = new ArrayList<>();
    if (audioBytes == null || pontosDesejados == 0 || audioBytes.length == 0) {
        return picos;
    }
    int tamanho = Math.max(1, audioBytes.length / pontosDesejados);
    for (int i = 0; i < audioBytes.length && picos.size() < pontosDesejados; i += tamanho) {
        int max = 0;
        int fim = Math.min(i + tamanho, audioBytes.length);
        for (int j = i; j < fim; j++) {
            int valor = Math.abs(audioBytes[j]);
            if (valor > max) {
                max = valor;
            }
        }
        picos.add(max);
    }
    return picos;
}
}