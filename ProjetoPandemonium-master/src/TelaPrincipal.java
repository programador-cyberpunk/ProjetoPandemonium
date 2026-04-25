
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;

import Usuario.UsuariosDAO;
import javazoom.jl.player.Player;

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
                JButton btnUpload = new JButton("Selecionar Áudio");
                btnUpload.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        JFileChooser fileChooser = new JFileChooser();
                        //agora é onde o filtro começa a agir
                        FileNameExtensionFilter filtro = new  FileNameExtensionFilter("Arquivos de AUDIO (*.mp3. *.wav, *.ogg,) mp3, wav, ogg.\n NÂO ME INVENTA MERDA !!!!!!");
                        fileChooser.setFileFilter(filtro);
                        fileChooser.setAcceptAllFileFilterUsed(false);

                        int retorno = fileChooser.showOpenDialog(null);
                        if (retorno == JFileChooser.APPROVE_VALUE){// sei la pq ta dando esse erro, eu fiz tudo certinho
                            File arquivo = fileChooser.getSelectedFile();
                        if(UsuariosDAO.arquivoAudio(audioSelecionado)){
                            JOptionPane.showMessageDialog(null, "Arquivo selecionado com sucesso" + arquivo);
                        }else {
                            JOptionPane.showMessageDialog(null, "Deu ruim, esse arquivo eh invalido");
                        }
                        }
                    }
                });
                AbstractButton itemGerenciadorChamados = null;// foi do jeito que deu porra
                itemGerenciadorChamados.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        TelaGerenciadorChamados telaChamados = new TelaGerenciadorChamados();
                        telaChamados.setVisible(true);
                    }
                });
            }
        }
