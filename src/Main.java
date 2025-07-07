import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Main {
 public class SistemaGravador{
     private static List<Usuarios> usuarios = new ArrayList<>();
     private static List<Chamados> chamados = new ArrayList<>();
     private static Usuarios usuarioLogado = null;

 public static void main(String[] args){
     usuarios.add(new Usuario("admin", "admin123", true));
     usuarios.add(new Usuario("user", "user123", false));
 }

  SwingUtilities.invokeLater(() ->{mostrarTelaLogin();})

 private static boolean autenticarUsuario(String usuario, String senha){
     for(Usuario u: usuarios){
         if(u.getUsuario().equals(usuaio)&& u.getSenha().equals(senha)){
             return true;
         }
        return false;
 private static void mostrarTelaLogin(){
     JFrame login = new JFrame("Pandemonium Login");
     JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JFrame.setSize(350, 250);
     JFrame.setLayout(new BorderLayout(10, 10));

     JPanel panel = new JPanel(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
     gbc.insets = new Insets(5, 5,5,5);
     gbc.gridx = 0;
     gbc.gridy = 0;

     JLabel lblTitulo = new JLabel("Login");
     lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
     gbc.griwidth = 2;
     panel.add(lblTitulo, gbc);

     gbc.gridy++;
     gbc.gridwidth = 1;
     panel.add(new JLabel("Usuário:"), gbc);
     gbc.gridx++;
     JTextField txtUsuario = new JTextField(15);
     panel.add(txtUsuario, gbc);

     gbc.gridy++;
     gbc.gridx = 0;
     panel.add(new JLabel("Senha:"), gbc);
     gbc.gridx++;
     JPasswordField txtSenha = new JPasswordField(15);
     panel.add(txtSenha, gbc);
             gbc.gridy++;
             gbc.gridx = 0;
             JButton btnLogin = new JButton("Login");
             btnLogin.addActionListener(e -> {
                 String usuario = txtUsuario.getText();
                 String senha = new String(txtSenha.getPassword());

                 if (autenticarUsuario(usuario, senha)) {
                     frame.dispose();
                     mostrarMenuPrincipal();  // Avança para o menu principal
                 } else {
                     JOptionPane.showMessageDialog(frame,
                             "Usuário ou senha inválidos!",
                             "Erro",
                             JOptionPane.ERROR_MESSAGE);
                 }
             });
             panel.add(btnLogin, gbc);

         }
 }
}

