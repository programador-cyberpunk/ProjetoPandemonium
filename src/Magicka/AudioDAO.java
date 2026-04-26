package Magicka;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javazoom.jl.player.Player;

public class AudioDAO {
    public boolean arquivoAudio(File arquivo){
        try{
            String tipoMime = Files.probeContentType(arquivo.toPath());
            return tipoMime != null && tipoMime.contains("audio/");

        }catch(IOException e){
            return false;
        }
    }
}
