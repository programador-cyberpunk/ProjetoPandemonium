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
import javafx.embed.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends javax.swing.JFrame{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true); // AQUI COMEÇA O PANDEMONIUM
            }
        });

    }

}
