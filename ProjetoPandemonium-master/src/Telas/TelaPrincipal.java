    package Telas;
    import javax.swing.*;
    import javax.swing.filechooser.FileNameExtensionFilter;
    import java.awt.FlowLayout;
    import java.awt.event.ActionEvent.*;
    import java.awt.event.ActionListener;
    import java.io.File;
    import Magicka.AudioDAO;
    import Login.TelaLogin;
    import javax.sound.sampled.*;
    import javax.swing.*;
    import javax.swing.filechooser.FileNameExtensionFilter;
    import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.File;
    import Magicka.AudioDAO;
    import Chamado.ChamadoDAO;
    import Chamado.Chamado;

        public class TelaPrincipal extends JFrame {

            public TelaPrincipal() {
                super("Menu Principal - Pandemonium");

                setSize(800, 600);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(new FlowLayout());

                // Menu
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

                // Ações
                itemSair.addActionListener(e -> System.exit(0));

                itemGerenciarChamados.addActionListener(e -> {
                    TelaGerenciadorChamados telaChamados = new TelaGerenciadorChamados();
                    telaChamados.setVisible(true);
                });

                // Botão Upload
                JButton btnUpload = new JButton("Selecionar Áudio");
                btnUpload.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Áudio (*.mp3, *.wav, *.ogg)", "mp3", "wav", "ogg");
                        fileChooser.setFileFilter(filtro);
                        fileChooser.setAcceptAllFileFilterUsed(false);

                        int retorno = fileChooser.showOpenDialog(TelaPrincipal.this);

                        if (retorno == JFileChooser.APPROVE_OPTION) {
                            File arquivo = fileChooser.getSelectedFile();

                            AudioDAO audioDAO = new AudioDAO();
                            if (audioDAO.upload(arquivo, 1)) {
                                JOptionPane.showMessageDialog(TelaPrincipal.this, "Arquivo enviado e catalogado!");
                            } else {
                                JOptionPane.showMessageDialog(TelaPrincipal.this, "Arquivo inválido ou erro no envio!");
                            }
                        }
                    }
                });

                add(btnUpload);
            }
        }