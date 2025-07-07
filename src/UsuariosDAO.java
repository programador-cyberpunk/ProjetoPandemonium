import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class UsuariosDAO {

        private static final List<Usuario> usuarios = new ArrayList<>();
        private static int proximoId = 1;

        static {

            usuarios.add(new Usuario(proximoId++, "admin", "admin123"));
            usuarios.add(new Usuario(proximoId++, "user", "senha123"));
        }


        public Usuario validarLogin(String username, String password) {
            for (Usuario u : usuarios) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u;
                }
            }
            return null;
        }

        // Por exemplo:
        // public void adicionarUsuario(String username, String password) { ... }
        // public void deletarUsuario(int id) { ... }
        // public void atualizarUsuario(Usuario usuario) { ... }
    }
}
