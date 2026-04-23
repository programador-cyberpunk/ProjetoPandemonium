package Magicka;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// nao me faz pergunta dificil porra
public class Audio {
    private int idAudio;
    private String filename;
    private String pathLocal;
    private long size;
    private int id_Usuario;

    //agora vem a magicka
    public Audio(int idAudio, String filename, String pathLocal, long size , int id_Usuario) {
        this.idAudio = idAudio;
        this.filename = filename;
        this.pathLocal = pathLocal;
        this.size = size;
        this.id_Usuario = id_Usuario;
    }
    public int getIdAudio() {
        return idAudio;
    }
    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public String getFilename(){
        return filename;
    }
    public void setFilename(String filename){
        this.filename = filename;
    }

    public String getPathLocal() {
        return pathLocal;
    }
    public void setPathLocal(String pathLocal){
        this.pathLocal = pathLocal;
    }

    public long getSize(){
        return size;
    }
    public void setSize(long size){
        this.size = size;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }
    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
}
