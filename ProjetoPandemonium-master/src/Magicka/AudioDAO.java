package Magicka;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.InputStream;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//import javazoom.jl.player.Player;//

public class AudioDAO {
    public boolean Upload(File arquivo, int idUsuario) {
        //tentativa primaria de barrar outros tipos de arquivo
        if (!isAudio(arquivo)) {
            System.out.println("Esse arquivo nao eh valido");
            return false;
        }
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            Armazenamento storage = new Armazenamento();
            //criar essa porra caso não exista
            Audio novoAudio = new Audio(
                    0,
                    arquivo.getName(),
                    arquivo.getAbsolutePath(),
                    arquivo.length(),
                    idUsuario
            );
            //mensagem de sucesso se o burro nao mandou um arquivo e tive que criar
            System.out.println("Audio catalogado com sucesso: " + novoAudio.getFilename());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isAudio(File arquivo) {
        try {
            String tipoMime = Files.probeContentType(arquivo.toPath());
            return tipoMime != null && tipoMime.contains("audio/");
        } catch (IOException e) {
            return false;
        }
    }
}
