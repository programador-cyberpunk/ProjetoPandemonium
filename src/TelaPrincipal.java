import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class TelaPrincipal extends JFrame {

        public TelaPrincipal() {

            super("Menu Principal - Sistema Gravador");

            setSize(800, 600); // Um tamanho maior para a tela principal
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao clicar no 'X'
            setLocationRelativeTo(null); // Centraliza na tela

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
                    // Fecha a aplicação
                    System.exit(0);
                }
            });

            itemGerenciarChamados.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(
                            TelaPrincipal.this,
                            "A tela para gerenciar os chamados será aberta aqui!",
                            "Em Construção",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    // O CÓDIGO PARA ABRIR A TELA DE CHAMADOS VIRÁ AQUI DEPOIS
                    // TelaGerenciarChamados telaChamados = new TelaGerenciarChamados();
                    // telaChamados.setVisible(true);
                }
            });
        }
    }