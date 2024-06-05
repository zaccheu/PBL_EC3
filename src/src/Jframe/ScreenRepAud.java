package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenRepAud extends JFrame {
    private ScreenMenu screenMenu; // Adicione essa linha

    public ScreenRepAud(ScreenMenu screenMenu) {
        this.screenMenu = screenMenu; // Adicione essa linha

        setTitle("Reprodução de Áudio");
        setVisible(true);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 225, 210));

        JLabel labelTitulo = new JLabel("ÁUDIO");
        labelTitulo.setBounds(30, 10, 250, 60);
        labelTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        labelTitulo.setVisible(true);
        add(labelTitulo);

        // Label de fundo principal
        JLabel labelFundoCentral = new JLabel();
        labelFundoCentral.setBounds(0, 150, 1000, 200);
        labelFundoCentral.setBackground(new Color(210, 195, 180));
        labelFundoCentral.setVisible(true);
        labelFundoCentral.setOpaque(true);

        // Configurar o layout do labelFundoSuperior para centralizar o ícone
        labelFundoCentral.setLayout(new GridBagLayout());
        add(labelFundoCentral);

        // Carregar a imagem
        ImageIcon imagemPlayer = new ImageIcon(getClass().getResource("playerIcon.png"));
        Image imagemPlayerRedimensionada = imagemPlayer.getImage();
        Image imagemAjustada = imagemPlayerRedimensionada.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Ajustar o tamanho conforme necessário
        ImageIcon iconeImagem = new ImageIcon(imagemAjustada);

        // Adicionar o ícone ao painel
        JLabel labelImagem = new JLabel(iconeImagem);
        labelFundoCentral.add(labelImagem, new GridBagConstraints());

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

        JButton botaoMenu = new JButton("Menu");
        botaoMenu.setBounds(225, 450, 250, 50);
        botaoMenu.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        botaoMenu.setForeground(new Color(0, 0, 0));
        botaoMenu.setBackground(new Color(235, 235, 235));
        botaoMenu.setFocusable(false);
        botaoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenMenu.setVisible(true); // Altere aqui para usar screenMenu
                dispose();
            }
        });
        add(botaoMenu);

        JButton botaoGerarNovoAudio = new JButton("Gerar Novo Áudio");
        botaoGerarNovoAudio.setBounds(525, 450, 250, 50);
        botaoGerarNovoAudio.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        botaoGerarNovoAudio.setForeground(new Color(0, 0, 0));
        botaoGerarNovoAudio.setBackground(new Color(235, 235, 235));
        botaoGerarNovoAudio.setFocusable(false);
        botaoGerarNovoAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenSimAud(screenMenu).setVisible(true); // Altere aqui para usar screenMenu
                dispose();
            }
        });
        add(botaoGerarNovoAudio);
    }
}
