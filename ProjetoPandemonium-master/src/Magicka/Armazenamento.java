package Magicka;
import Usuario.Usuario;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import javafx.sound.sampled.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// vamo importa tudo e torce pra dar certo

public class Armazenamento {
    private final Path raiz = Path.get("upload-dir");

    private void salvaArmazenamento(String nomeArquivo, InputStream audioInput){
            try{
                if(!Files.existis(raiz)){
                    Files.createDirectories(raiz);
                }
              Path destino = this.raiz.resolve(nomeArquivo);
              Files.copy(audioInput, destino, StandartCopyOption.REPLACE_EXISTING);
            }catch (Exception e){
                throw  new RuntimeException("Deu bosta ao salvar os arquivos... Tente de novo" + e.getMessage());
            }

    }
}