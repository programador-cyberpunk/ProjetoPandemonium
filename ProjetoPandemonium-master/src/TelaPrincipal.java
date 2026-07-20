
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Magicka.AudioDAO;
import Usuario.UsuariosDAO;
import javax.swing.JFrame;
import TelaLogin.TelaLogin;
//import javazoom.jl.player.Player;//fodase isso aqui
    public class TelaPrincipal extends JFrame {
            public TelaPrincipal() {
                super("Menu Principal - Pandemonium");

                setSize(800, 600);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);

                JMenuBar menuBar = new JMenuBar();

                JMenu menuArquivo = new JMenu("Arquivo");
                JMenuItem itemSair = new JMenuItem("Sair");
                menuArquivo.add(itemSair);

                JMenu menuChamados = new JMenu("Chamados");
                JMenuItem itemGerenciarChamados = new JMenuItem("Gerenciar Chamados");
                menuChamados.add(itemGerenciarChamados);

                menuBar.add(menuArquivo);
                menuBar.add(menuChamados);

                setJMenuBar(menuBar);

                itemSair.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.exit(0);
                    }
                });

                // implementando o botao pra fazer a magica acontecer no bom sentido
                JButton btnUpload = new JButton("Selecionar audio");
                btnUpload.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JFileChooser fileChooser = new JFileChooser();
                            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo alguma coisa");
                            fileChooser.setFileFilter(filtro);
                            fileChooser.setAcceptAllFileFilterUsed(false);
                                int retorno = fileChooser.showOpenDialog(null);
                                    if(retorno == JFileChooser.APPROVE_OPTION){
                                        File arquivo = fileChooser.getSelectedFile();
                                    }

                                    // porra do AudioDAO certo
                                AudioDAO audioDAO = new AudioDAO();
                                    if(audioDAO.processarUpload(arquivo, 1)){
                                        JOptionPane.showMessageDialog(null, "Arquivo enviado e catalogado, gg");
                                    }else {
                                        JOptionPane.showMessageDialog(null, "Deu ruim, esse arquivo ta lombrado")
                                    }
                    }
                }
                }
            });

            JButton itemGerenciadorChamados = new JButton("Gerenciador de chamados");
                itemGerenciadorChamados.addActionListener(new ActionListener(){
                    @Override
                     public void actionPerformed(ActionEvent e){
                        TelaGerenciadorChamados telaChamados = new TelaGerenciadorChamados();
        }
    });