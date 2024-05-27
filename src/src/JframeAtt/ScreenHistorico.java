package JframeAtt;

import javax.swing.*;
import java.awt.*;

class ScreenHistorico extends JFrame
{
    public ScreenHistorico()
    {
        setTitle("Histórico");
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton jButton3 = new JButton("Menu");
        jButton3.setBounds(300, 325, 200, 40);
        jButton3.setFont(new Font("Times New Roman",Font.PLAIN, 30));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setBackground(new Color(124, 104, 104));

        add(jButton3);

    }

}
