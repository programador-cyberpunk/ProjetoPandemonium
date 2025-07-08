import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// package br.com.gravador.dao;

import br.com.gravador.model.Usuario; // Certifique-se de importar sua classe Usuario
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static int proximoId = 1;

    static {
        usuarios.add(new Usuario(proximoId++, "admin", "admin123"));
        usuarios.add(new Usuario(proximoId++, "user", "senha123"));
    }

    public void adicionarUsuario(String username, String password) {
        Usuario novoUsuario = new Usuario(proximoId++, username, password);
        usuarios.add(novoUsuario);
        System.out.println("Usuário adicionado: " + username);
    }

    public Usuario validarLogin(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    /**
     * READ: Retorna uma cópia da lista de todos os usuários.
     * @return Uma lista com todos os usuários.
     */
    public List<Usuario> listarTodos() {
        // Retornamos uma nova lista para evitar que a lista original seja modificada externamente
        return new ArrayList<>(usuarios);
    }

    public void atualizarUsuario(Usuario usuarioAtualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId() == usuarioAtualizado.getId()) {
                usuarios.set(i, usuarioAtualizado);
                System.out.println("Usuário atualizado: " + usuarioAtualizado.getUsername());
                return;
            }
        }
    }


    public boolean deletarUsuario(int id) {
        boolean removido = usuarios.removeIf(usuario -> usuario.getId() == id);
        if (removido) {
            System.out.println("Usuário de ID " + id + " foi removido.");
        } else {
            System.out.println("Usuário de ID " + id + " não encontrado.");
        }
        return removido;
    }
}
