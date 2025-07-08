
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        super("Menu Principal - Sistema Gravador");
        
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