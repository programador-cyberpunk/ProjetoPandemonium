import Login.TelaLogin;
import Magicka.AudioDAO;
import Usuario.Usuario;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[] args) {
        try {
            com.sun.javafx.application.PlattformImpl.startu(() -> {
            });
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
        }
