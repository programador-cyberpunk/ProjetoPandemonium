package Usuario;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// importei tudo de novo foda se

public class Usuario{

        private int id_Usuario;
        private String username;
        private String senha;
        private String nome;
        private String email;

        public Usuario(int id_Usuario, String username, String senha, String email) {
            this.id_Usuario = id_Usuario;
            this.username = username;
            this.senha = senha;
            this.email = email;
        }
        public int getId() {

            return id_Usuario;
        }

        public void setId(int id_Usuario) {

            this.id_Usuario = id_Usuario;
        }

        public String getUsername() {

            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {

            return senha;
        }

        public void setPassword(String senha) {

            this.senha = senha;
        }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){

            this.email = email;
    }
}
