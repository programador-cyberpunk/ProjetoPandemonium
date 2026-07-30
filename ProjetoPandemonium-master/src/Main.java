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


public class Main extends javax.swing.JFrame{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true); // AQUI COMEÇA O PANDEMONIUM
            }try

            {
                com.sun.javafx.application.PlataformImpl.startup(() -> {
                });

            }catch(
            Exception ignored)

        });
    }