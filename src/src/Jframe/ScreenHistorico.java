package Jframe;

import BancoDados.Armazem;
import BancoDados.BancoDeDados;
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

        JLabel labelTitulo = new JLabel("HISTÓRICO");
        labelTitulo.setBounds(30, 10, 250, 60);
        labelTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        labelTitulo.setVisible(true);
        add(labelTitulo);

        // Label de fundo do Título
        JLabel labelFundoSuperior = new JLabel();
        labelFundoSuperior.setBounds(0, 35, 1000, 5);
        labelFundoSuperior.setBackground(Color.white);
        labelFundoSuperior.setVisible(true);
        labelFundoSuperior.setOpaque(true);
        add(labelFundoSuperior);

        // Label de fundo do Título
        JLabel labelFundoSuperior2 = new JLabel();
        labelFundoSuperior2.setBounds(0, 45, 1000, 5);
        labelFundoSuperior2.setBackground(Color.white);
        labelFundoSuperior2.setVisible(true);
        labelFundoSuperior2.setOpaque(true);
        add(labelFundoSuperior2);

        // Painel para exibir as simulações em tabela
        JPanel painelTabela = new JPanel();
        painelTabela.setBounds(10, 110, 960, 350);
        painelTabela.setBackground(new Color(210, 195, 180));
        painelTabela.setLayout(new BorderLayout());

        // Colunas da tabela
        String[] colunas = {"Frequência Inicial(Hz)", "Amplitude Senoidal", "Velocidade Relativa(m/s)", "Distância Inicial(m)", "Tempo de Simulação(s)", "Frequência Observada(Hz)"};

        // Modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        // Buscar as simulações do usuário logado
        String usuario = Armazem.getInstance().getUsuario();
        BancoDeDados lancaDados = new BancoDeDados();
        List<Simulacao> simulacoes = lancaDados.buscarSimulacoesPorUsuario(usuario);

        // Preencher a tabela com os dados das simulações
        for (Simulacao simulacao : simulacoes) {
            Object[] linha = {
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
        painelTabela.add(scrollPane, BorderLayout.CENTER);

        add(painelTabela);

        JButton botaoMenu = new JButton("Menu");
        botaoMenu.setBounds(410, 480, 180, 50);
        botaoMenu.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        botaoMenu.setForeground(new Color(0, 0, 0));
        botaoMenu.setBackground(new Color(235, 235, 235));
        botaoMenu.setFocusable(false);
        botaoMenu.addActionListener(e -> {
            new ScreenMenu();
            dispose();
        });
        add(botaoMenu);
    }
}
