package Magicka;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// nao me faz pergunta dificil porra

public class Audio {
    private int idAudio;
    private String nomeAudio;
    private String pathLocal;
    private long tamanho;
    private int id_Usuario;

    //agora vem a magicka
    public Audio(int idAudio, String nomeAudio, String pathLocal, long tamanho , int id_Usuario) {
        this.idAudio = idAudio;
        this.nomeAudio = nomeAudio;
        this.pathLocal = pathLocal;
        this.tamanho = tamanho;
        this.id_Usuario = id_Usuario;
    }
    public int getIdAudio() {
        return idAudio;
    }
    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public String getFilename(){
        return nomeAudio;
    }
    public void setFilename(String filename){
        this.nomeAudio = filename;
    }

    public String getPathLocal() {
        return pathLocal;
    }
    public void setPathLocal(String pathLocal){
        this.pathLocal = pathLocal;
    }

    public long getSize(){
        return tamanho;
    }
    public void setSize(long size){
        this.tamanho = tamanho;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }
    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
}
