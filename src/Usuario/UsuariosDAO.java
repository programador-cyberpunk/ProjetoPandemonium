package Usuario;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuariosDAO {

    public Usuario validarLogin(String username, String senha) {
       return ApiLogin(username, senha);
    }
    public void addUsuario (String usuario,  String senha){
        httpClient.post("http://localhost:8080/api/usuarios", username, senha);
    }

    public void atualizarUsuario(Usuario usuarioAtualizado) {

            }
        }

    public boolean deletarUsuario(int id) {
        boolean removido = usuarios.removeIf(usuario -> usuario.getId() == id);
        if (removido) {
            System.out.println("Usuário de ID " + id + " foi chutado.");
        } else {
            System.out.println("Usuário de ID " + id + " não encontrado.");
        }
        return removido;
    }
}
