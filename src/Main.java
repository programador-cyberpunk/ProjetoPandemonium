import Login.TelaLogin;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true); // AQUI COMEÇA O PANDEMONIUM
            }
        });
    }

    public static void setVisible(boolean b) {
    }
}
