package JframeAtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ScreenHistorico extends JFrame
{
    public ScreenHistorico(JFrame ScreenMenu)
    {
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

        //Label de fundo principal
        JLabel jLabel2 = new JLabel();
        jLabel2.setBounds(0, 95, 1000, 360);
        jLabel2.setBackground(new Color(210, 195, 180));
        jLabel2.setVisible(true);
        jLabel2.setOpaque(true);
        add(jLabel2);

        //Label de fundo do Título
        JLabel jLabel3 = new JLabel();
        jLabel3.setBounds(0, 35, 1000, 5);
        jLabel3.setBackground(Color.white);
        jLabel3.setVisible(true);
        jLabel3.setOpaque(true);
        add(jLabel3);

        //Label de fundo do Título
        JLabel jLabel4 = new JLabel();
        jLabel4.setBounds(0, 45, 1000, 5);
        jLabel4.setBackground(Color.white);
        jLabel4.setVisible(true);
        jLabel4.setOpaque(true);
        add(jLabel4);

        JButton jButton3 = new JButton("Menu");
        jButton3.setBounds(410, 480, 180, 50);
        jButton3.setFont(new Font("Century Gothic",Font.PLAIN, 25));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setBackground(new Color(235, 235, 235));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenMenu();
                dispose();
            }
        });
        add(jButton3);

    }

}
