import Login.TelaLogin;
import Usuario.Usuario;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import javafx.sound.sampled.*;
import java.io.File;

public class Main extends javax.swing.JFrame{

    public static void main(String[] args){
        try{
            com.sun.javafx.application.PlataformImpl.startup(()-> {});
        }catch (Exception ignored){
            // ta no nome o que faz ne
        }
        SwingUtilities.invokerLater(new Runnable(){
            Override
            public void run(){
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true); // E COMEÇA O PANDEMONIUM
            }
        });
    }
}