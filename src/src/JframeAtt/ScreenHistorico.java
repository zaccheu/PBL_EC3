package JframeAtt;

import BancoDados.Armazem;
import BancoDados.LancaDados;
import BancoDados.Simulacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class ScreenHistorico extends JFrame {
    public ScreenHistorico(JFrame screenMenu) {
        setTitle("Histórico");
        setVisible(true);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 225, 210));

        JLabel jLabel = new JLabel("HISTÓRICO");
        jLabel.setBounds(30, 10, 250, 60);
        jLabel.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        jLabel.setVisible(true);
        add(jLabel);

        // Label de fundo do Título
        JLabel jLabel3 = new JLabel();
        jLabel3.setBounds(0, 35, 1000, 5);
        jLabel3.setBackground(Color.white);
        jLabel3.setVisible(true);
        jLabel3.setOpaque(true);
        add(jLabel3);

        // Label de fundo do Título
        JLabel jLabel4 = new JLabel();
        jLabel4.setBounds(0, 45, 1000, 5);
        jLabel4.setBackground(Color.white);
        jLabel4.setVisible(true);
        jLabel4.setOpaque(true);
        add(jLabel4);

        // Painel para exibir as simulações em tabela
        JPanel tabelaPanel = new JPanel();
        tabelaPanel.setBounds(10, 110, 960, 350);
        tabelaPanel.setBackground(new Color(210, 195, 180));
        tabelaPanel.setLayout(new BorderLayout());

        // Colunas da tabela
        String[] colunas = {"ID", "Frequência Inicial", "Amplitude Senoidal", "Velocidade Relativa", "Distância Inicial", "Tempo de Simulação", "Frequência Observada"};

        // Modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        // Buscar as simulações do usuário logado
        String usuario = Armazem.getInstance().getUsuario();
        LancaDados lancaDados = new LancaDados();
        List<Simulacao> simulacoes = lancaDados.buscarSimulacoesPorUsuario(usuario);

        // Preencher a tabela com os dados das simulações
        for (Simulacao simulacao : simulacoes) {
            Object[] linha = {
                    simulacao.getSimulacaoID(),
                    simulacao.getFrequenciaInicial(),
                    simulacao.getAmplitudeSenoidal(),
                    simulacao.getVelocidadeRelativa(),
                    simulacao.getDistanciaInicial(),
                    simulacao.getTempoSimulacao(),
                    simulacao.getFreqObservado()
            };
            modeloTabela.addRow(linha);
        }

        // Criar a tabela com o modelo
        JTable tabela = new JTable(modeloTabela);

        // Adicionar a tabela a um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabelaPanel.add(scrollPane, BorderLayout.CENTER);

        add(tabelaPanel);

        JButton jButton3 = new JButton("Menu");
        jButton3.setBounds(410, 480, 180, 50);
        jButton3.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setBackground(new Color(235, 235, 235));
        jButton3.setFocusable(false);
        jButton3.addActionListener(e -> {
            new ScreenMenu();
            dispose();
        });
        add(jButton3);
    }
}
