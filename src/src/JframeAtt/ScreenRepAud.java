package JframeAtt;

import javax.swing.*;
import java.awt.*;

public class ScreenRepAud extends JFrame
{
    public ScreenRepAud()
    {
        setTitle("Reprodução de Áudio");
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);



        JButton jButton6 = new JButton("Menu");
        jButton6.setBounds(150, 350, 250, 40);
        jButton6.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        jButton6.setForeground(new Color(0, 0, 0));
        jButton6.setBackground(new Color(124, 104, 104));

        add(jButton6);

        JButton jButton7 = new JButton("Gerar Novo Áudio");
        jButton7.setBounds(450, 350, 250, 40);
        jButton7.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        jButton7.setForeground(new Color(0, 0, 0));
        jButton7.setBackground(new Color(124, 104, 104));

        add(jButton7);

        JButton jButton8 = new JButton("Gerar Novo Áudio");
        jButton8.setBounds(450, 350, 250, 40);
        jButton8.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        jButton8.setForeground(new Color(0, 0, 0));
        jButton8.setBackground(new Color(124, 104, 104));

        add(jButton8);
    }
}
