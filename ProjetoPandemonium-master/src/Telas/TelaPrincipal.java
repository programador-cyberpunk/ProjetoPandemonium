package TelaLogin;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent.;
import java.awt.event.ActionListener;
import java.io.File;
import Magicka.AudioDAO;
import Login.TelaLogin;
import javax.sound.sampled.*;
public class TelPrinciapl extends JFrame(){
        super("Menu - PANDEMONIUM");

setSize(800,600);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLocstionRelativeTo(null);

setLayout( new FlowLayout());

//menu do desktop
JMenuBar menuBar = new JMenuBar();
JMenu menuArquivo = new JMenu("Arquivo");
JMenuItem itemSair = new JMenuItem("Sair");
       menuArquivo.

add(itemSair);

//chamados
JMenu menuChamados = new JMenu("Chamados")
JMenuItem itemGerenciarChamados = new JMenuItem("Gerenciar chamados");
       menuChamados.

add(itemGerenciarChamados);
       menuBar.

add(menuArquivo);
       menuBar.

add(menuChamados);

// acoes do menu
       set.

JMenuBar(menuBar);
       itemSair.

addActionListener( new ActionListener() {
    @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }
});

        itemGerenciarChamados.

addActionListener( new ActionListener() {
    @Override
    public void actionPerformed (ActionEvent e){
        TelaGerenciadorChamados telaChamados = new TelaGereniadorChamados();
        telaChamados.setVisible(true);
    }
});

JButton btnUpload = new JButton("Selecionar arquivo");
btnUpload.addActionListener( new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo configurado");

        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int retorno = fileChooser.showOpenDialog(TelPrinciapl.this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            File arquivo = fileChooser.getSelectefFile();

            if(audioDAO.Upload(arquivo, 1)){
                JOptionPane.showMessageDialog(TelPrinciapl.this, "Arquivo enviado com suceso");
            }else {
                JOptionPane.showMessageDialog(TelPrinciapl.this, "Deu ruim, nao deu pra enviar seu arquivo");
            }
        }
    }
});
add(btnUpload);
        }
                }