// O nome do pacote foi mantido, mas a convenção é usar letras minúsculas (ex: br.com.pandemonium.model)
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {

    // O código aqui estava correto, o problema era a falta dos imports acima.
    private static final List<Chamado> chamados = new ArrayList<>();
    private static int proximoId = 1;

    static {
        chamados.add(new Chamado(proximoId++, "Gravador com defeito", "O gravador de bateria nao esta funcionando.", "Aberto"));
        chamados.add(new Chamado(proximoId++, "Faixa não salva", "A faixa da segunda guitarra nao foi salva", "Aberto"));
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