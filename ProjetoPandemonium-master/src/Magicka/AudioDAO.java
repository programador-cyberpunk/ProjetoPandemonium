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
import javafx.sound.sampled.*;

    public class AudioDAO{
        //primeira etapa de verificação
        public boolean Upload(File arquivo, int idUsuario){
        if(!isAudio(arquivo)){
            return false;
        }
        try(FileInputStream fis = new FileInuputStream((arquivo)){
            Armazenamnto storage = new Armazenamento();
            storage.salvarArmazenamento(arquivo.getName(), fis);

            Audio novoAudio = new Audio(0, arquivo.getName(), arquivo.getAbsolutePath(), arquivo.length(), idUsuario);
            System.out.printLn("Audio salvo: " +novoAudio.getFileName());
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean isAudio(File arquivo){
            try{
                String tipoMime = Files.probeContentType(arquivo.toPath());
                return tipoMime != null && tipoMime.contains("audio/");
            }catch (IOException e){
                return false;
            }
    }
    }