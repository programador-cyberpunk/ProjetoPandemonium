import br.com.gravador.model.Chamado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChamadoDAO {

    private static final List<Chamado> chamados = new ArrayList<>();
    private static int proximoId = 1;

    // Bloco para já iniciar com alguns dados de exemplo
    static {
        chamados.add(new Chamado(proximoId++, "Computador não liga", "O PC da recepção não dá sinal de vida.", "Aberto"));
        chamados.add(new Chamado(proximoId++, "Impressora sem tinta", "A impressora do financeiro está falhando a cor preta.", "Aberto"));
    }

    public void adicionarChamado(Chamado chamado) {
        chamado.setId(proximoId++);
        chamados.add(chamado);
    }

    public List<Chamado> listarTodos() {
        return new ArrayList<>(chamados);
    }

    public void atualizarChamado(Chamado chamadoAtualizado) {
        for (int i = 0; i < chamados.size(); i++) {
            if (chamados.get(i).getId() == chamadoAtualizado.getId()) {
                chamados.set(i, chamadoAtualizado);
                return;
            }
        }
    }

    public void deletarChamado(int id) {
        chamados.removeIf(chamado -> chamado.getId() == id);
    }
}