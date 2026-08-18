package ifsp.edu.br.pandemonium_api.service;
import ifsp.edu.br.pandemonium_api.model.Audio;
import ifsp.edu.br.pandemonium_api.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Files;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import javax.sound.sampled.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AudioService {

    @Autowired
    private AudioRepository audioRepository;

    @Async
    public CompletableFuture<Void>processarAudio(File arquivoAudio, Long audioId){
        try{
            //fruxo do audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivoAudio);
            AudioFormat format = audioInputStream.getFormat();
            Long totalFrames = audioInputStream.getFrameLength();

            //calcula os segundos
            float Segundos = totalFrames / format.getFrameRate();

            //le os bytes pra pegar os pico de amplitude no waveform
            byte[] bytes = audioInputStream.readAllBytes();
            List<Integer> waveform = extrairPicos(bytes, 100);

            //atualiza a entidade no banco de dados com metadados calculados
            audioRepository.findById(audioId).ifPresent(audio ->{
                audio.setDuracao(Segundos);
                audio.setWaveformJson(waveform.toString());
                audioRepository.save(audio);
            });
            audioInputStream.close();
        } catch (UnsupportedAudioFileException | IOException e){
            System.err.println("Deu bosta ao ler o arquivo: " + e.getMessage());
        }
        return CompletableFuture.completedFuture(null);
    }

    // mais porra vindo ai

    //upload
    public boolean arquivoAudio(MultipartFile arquivo){
        String tipoMime = arquivo.getContentType();
        return tipoMime != null && tipoMime.startsWith("audio/");// rapaiz isso aqui quebra um galho da porra
    }
    //verificar os bang
    public void salvaAudio(MultipartFile arquivo,String pastaUsuario) throws IOException{
        Path diretorioDestino = Paths.get("uploads", pastaUsuario);
        if (!Files.exists(diretorioDestino)){
         Files.createDirectories(diretorioDestino);
        }
        Path caminhoFinal = diretorioDestino.resolve(arquivo.getOriginalFilename());
        Files.copy(arquivo.getInputStream(), caminhoFinal, StandardCopyOption.REPLACE_EXISTING);
    }

}
