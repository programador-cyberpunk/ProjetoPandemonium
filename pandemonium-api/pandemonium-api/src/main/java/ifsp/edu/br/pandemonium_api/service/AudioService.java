package ifsp.edu.br.pandemonium_api.service;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Files;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@Service
public class AudioService {
    //upload
    public boolean arquivoAudio(MultipartFile arquivo){
        String tipoMime = arquivo.getContentType();
        return tipoMime != null && tipoMime.startsWith("audio/");// rapaiz isso aqui quebra um galho da porra
    }
    //verificar os bang
    public boolean ArquivoAudio(File arquivo) {
        try {
            String tipoMime = Files.probeContentType(arquivo.toPath());
            return tipoMime != null && tipoMime.contains("audio/");
        } catch (IOException e) {
            return false;
        }
    }
}
