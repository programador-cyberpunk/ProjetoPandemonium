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
import java.util.Locale;
import java.util.Optional;
import java.io.InputStream;
import javax.sound.sampled.*;

   public class AudioDAO{
       public boolean upload(File arquivo, int idUsuario){
           if(!isAudio(arquivo)){
               return false;
           }
           try (FileInputStream fis = new FileInputStream(arquivo)){
               Armazenamento  storage = new Armazenamento();
               storage.salvar(arquivo.getName(),fis);
               Audio novoAudio = new  Audio(0, arquivo.getName(), arquivo.getAbsolutePath(), arquivo.length(), idUsuario);
               System.out.println("Audio catalogado com sucesso: " + novoAudio.getFilename());
               return true;
           }catch (IOException e){
               e.printStackTrace();
               return false;
           }
       }
       //verificação de arquivo
       private boolean isAudio(File arquivo){
           try{
               String tipoMime = Files.probeContentType(arquivo.toPath());
               return tipoMime != null && tipoMime.contains("audio/*");
           }catch (IOException e){
               String nome = arquivo.getName().toLowerCase();
               return nome.endsWith(".mp3") || nome.endsWith(".wav") || nome.endsWith(".ogg");
           }
       }
   }