package Magicka;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// vamo importa tudo e torce pra dar certo

public class Armazenamento {
    //se pa, aqui vai ficar os arquivos, eu acho pelo menos
    private final Path raiz = Paths.get("upload-dir");
        public void salvarArmazenamento( String nomeArquivo, InputStream arquivoInput){
            try{
                if(!Files.exists(raiz)) Files.createDirectory(raiz);
                Files.copy(arquivoInput, this.raiz.resolve(nomeArquivo));
                System.out.println("Taake salvo com sucesso em: " + nomeArquivo); //nao estraga minha piada
            } catch (Exception e){
                throw new RuntimeException("Erro ao salvar arquivo: " + e.getMessage());
            }
        }
}
