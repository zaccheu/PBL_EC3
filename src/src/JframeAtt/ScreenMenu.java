package JframeAtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenMenu extends JFrame implements ActionListener
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

        JButton jButton = new JButton("Simular Áudio");
        jButton.setBounds(200, 310, 250, 80);
        jButton.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(235, 235, 235));
        jButton.setFocusable(false);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenSimAud(ScreenMenu.this);
                dispose();
            }
        });
        add(jButton);

        JButton jButton2 = new JButton("Histórico");
        jButton2.setBounds(540, 310, 250, 80);
        jButton2.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(235, 235, 235));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenHistorico(ScreenMenu.this);
                dispose();
            }
        });
        add(jButton2);

        JLabel jLabel = new JLabel("MENU");
        jLabel.setBounds(30, 10, 250, 60);
        jLabel.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        jLabel.setVisible(true);
        add(jLabel);

        JLabel jLabel2 = new JLabel("Escolha uma das opções a seguir para dar início ao experimento: ");
        jLabel2.setBounds(110, 170, 900, 100);
        jLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        add(jLabel2);

        //Label de fundo do título
        JLabel jLabel3 = new JLabel();
        jLabel3.setBounds(0, 35, 1000, 5);
        jLabel3.setBackground(Color.white);
        jLabel3.setVisible(true);
        jLabel3.setOpaque(true);
        add(jLabel3);

        //Label de fundo do título
        JLabel jLabel4 = new JLabel();
        jLabel4.setBounds(0, 45, 1000, 5);
        jLabel4.setBackground(Color.white);
        jLabel4.setVisible(true);
        jLabel4.setOpaque(true);
        add(jLabel4);

        //Label de fundo principal
        JLabel jLabel5 = new JLabel();
        jLabel5.setBounds(0, 120, 1000, 350);
        jLabel5.setBackground(new Color(210, 195, 180));
        jLabel5.setVisible(true);
        jLabel5.setOpaque(true);
        add(jLabel5);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}



