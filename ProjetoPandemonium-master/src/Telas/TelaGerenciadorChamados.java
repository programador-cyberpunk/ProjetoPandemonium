
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaGerenciadorChamados extends JFrame {

    private ChamadoDAO chamadoDAO;
    private JTable tabelaChamados;
    private DefaultTableModel modeloTabela;
    private JTextField txtTitulo;
    private JTextArea txtDescricao;
    private JComboBox<String> cbStatus;
    private JButton btnSalvar, btnNovo, btnExcluir;
    private Chamado chamadoSelecionado = null;

    public TelaGerenciadorChamados() {
        super("Gerenciar Chamados");
        chamadoDAO = new ChamadoDAO();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Título", "Status"}, 0);
        tabelaChamados = new JTable(modeloTabela);
        JScrollPane painelTabela = new JScrollPane(tabelaChamados);

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; painelFormulario.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        txtTitulo = new JTextField(20);
        painelFormulario.add(txtTitulo, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painelFormulario.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        txtDescricao = new JTextArea(5, 20);
        painelFormulario.add(new JScrollPane(txtDescricao), gbc);

        gbc.gridx = 0; gbc.gridy = 2; painelFormulario.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        cbStatus = new JComboBox<>(new String[]{"Aberto", "Em Andamento", "Fechado"});
        painelFormulario.add(cbStatus, gbc);

        JPanel painelBotoes = new JPanel();
        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        painelFormulario.add(painelBotoes, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelTabela, painelFormulario);
        splitPane.setDividerLocation(400);
        add(splitPane);

        tabelaChamados.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaChamados.getSelectedRow() != -1) {
                int linhaSelecionada = tabelaChamados.getSelectedRow();
                int idChamado = (int) modeloTabela.getValueAt(linhaSelecionada, 0);

                chamadoDAO.listarTodos().stream()
                        .filter(c -> c.getId() == idChamado)
                        .findFirst()
                        .ifPresent(this::preencherFormulario);
            }
        });

        btnNovo.addActionListener(e -> limparFormulario());

        btnExcluir.addActionListener(e -> excluirChamado());

        btnSalvar.addActionListener(e -> salvarChamado());

        atualizarTabela();
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        List<Chamado> lista = chamadoDAO.listarTodos();
        for (Chamado c : lista) {
            modeloTabela.addRow(new Object[]{c.getId(), c.getTitulo(), c.getStatus()});
        }
    }

    private void preencherFormulario(Chamado chamado) {
        chamadoSelecionado = chamado;
        txtTitulo.setText(chamado.getTitulo());
        txtDescricao.setText(chamado.getDescricao());
        cbStatus.setSelectedItem(chamado.getStatus());
        btnExcluir.setEnabled(true);
    }

    private void limparFormulario() {
        chamadoSelecionado = null;
        tabelaChamados.clearSelection();
        txtTitulo.setText("");
        txtDescricao.setText("");
        cbStatus.setSelectedIndex(0);
        txtTitulo.requestFocus();
        btnExcluir.setEnabled(false);
    }
    private void salvarChamado() {
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String status = (String) cbStatus.getSelectedItem();

        if (titulo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O título não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (chamadoSelecionado == null) { // Criando um novo chamado
            Chamado novoChamado = new Chamado(0, titulo, descricao, status);
            chamadoDAO.adicionarChamado(novoChamado);
            JOptionPane.showMessageDialog(this, "Chamado criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            chamadoSelecionado.setTitulo(titulo);
            chamadoSelecionado.setDescricao(descricao);
            chamadoSelecionado.setStatus(status);
            chamadoDAO.atualizarChamado(chamadoSelecionado);
            JOptionPane.showMessageDialog(this, "Chamado atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        atualizarTabela();
        limparFormulario();
    }

    private void excluirChamado() {
        if (chamadoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um chamado para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o chamado '" + chamadoSelecionado.getTitulo() + "'?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            chamadoDAO.deletarChamado(chamadoSelecionado.getId());
            atualizarTabela();
            limparFormulario();
        }
    }
}