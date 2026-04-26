package ifsp.edu.br.pandemonium_api.service;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Files;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
@Service
public class AudioService {
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
