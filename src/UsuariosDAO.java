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

        // READ: Método para validar o login
        public Usuario validarLogin(String username, String password) {
            for (Usuario u : usuarios) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u; // Retorna o usuário se as credenciais estiverem corretas
                }
            }
            return null; // Retorna nulo se o usuário não for encontrado ou a senha estiver errada
        }

        // Aqui estariam os outros métodos do CRUD que você poderia implementar
        // Por exemplo:
        // public void adicionarUsuario(String username, String password) { ... }
        // public void deletarUsuario(int id) { ... }
        // public void atualizarUsuario(Usuario usuario) { ... }
    }
}
