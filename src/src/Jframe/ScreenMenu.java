package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenMenu extends JFrame
{
    public ScreenMenu()
    {
        setTitle("Menu");
        setVisible(true);
        setSize( 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 225, 210));



        JLabel labelMenu = new JLabel("MENU");
        labelMenu.setBounds(30, 10, 250, 60);
        labelMenu.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        labelMenu.setVisible(true);
        add(labelMenu);

        JLabel labelTextoExplicativo = new JLabel("Escolha uma das opções a seguir para dar início ao experimento: ");
        labelTextoExplicativo.setBounds(110, 170, 900, 100);
        labelTextoExplicativo.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        add(labelTextoExplicativo);

        JButton botaoSimularAudio = new JButton("Simular Áudio");
        botaoSimularAudio.setBounds(200, 310, 250, 80);
        botaoSimularAudio.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        botaoSimularAudio.setForeground(new Color(0, 0, 0));
        botaoSimularAudio.setBackground(new Color(235, 235, 235));
        botaoSimularAudio.setFocusable(false);
        botaoSimularAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenSimAud(ScreenMenu.this);
                dispose();
            }
        });
        add(botaoSimularAudio);

        JButton botaoHistorico = new JButton("Histórico");
        botaoHistorico.setBounds(540, 310, 250, 80);
        botaoHistorico.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        botaoHistorico.setForeground(new Color(0, 0, 0));
        botaoHistorico.setBackground(new Color(235, 235, 235));
        botaoHistorico.setFocusable(false);
        botaoHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenHistorico(ScreenMenu.this);
                dispose();
            }
        });
        add(botaoHistorico);
        //Label de fundo do título
        JLabel labelFundoSuperior = new JLabel();
        labelFundoSuperior.setBounds(0, 35, 1000, 5);
        labelFundoSuperior.setBackground(Color.white);
        labelFundoSuperior.setVisible(true);
        labelFundoSuperior.setOpaque(true);
        add(labelFundoSuperior);

        //Label de fundo do título
        JLabel labelFundoSuperior2 = new JLabel();
        labelFundoSuperior2.setBounds(0, 45, 1000, 5);
        labelFundoSuperior2.setBackground(Color.white);
        labelFundoSuperior2.setVisible(true);
        labelFundoSuperior2.setOpaque(true);
        add(labelFundoSuperior2);

        //Label de fundo principal
        JLabel labelFundoCentral = new JLabel();
        labelFundoCentral.setBounds(0, 120, 1000, 350);
        labelFundoCentral.setBackground(new Color(210, 195, 180));
        labelFundoCentral.setVisible(true);
        labelFundoCentral.setOpaque(true);
        add(labelFundoCentral);


    }
}