package Login;
import Usuario.UsuariosDAO;
import Usuario.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TelaPrincipal.TelaPrincipal;
public class TelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private UsuariosDAO usuarioDAO;

    public TelaLogin() {

        super("Login - Pandemonium");

        usuarioDAO = new UsuariosDAO();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Componentes da tela
        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField(15);

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(15);

        btnEntrar = new JButton("Entrar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnEntrar, gbc);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }

    public void actionPerformed(Action e) {
        String username = txtUsuario.getText();
        String senha = txtSenha.getText();

        UsuariosDAO dao = new UsuariosDAO();
        Usuario u = dao.apiLogin(username, senha);
        if (u != null) {
            JOptionPane.showMessageDialog(this, "Login realizado caralho!");
            new TelaPrincipal().setVisible(true); // Abre a principal
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos, tente outra vez");
        }
    }
}