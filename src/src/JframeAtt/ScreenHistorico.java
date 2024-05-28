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
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton jButton3 = new JButton("Menu");
        jButton3.setBounds(300, 325, 200, 40);
        jButton3.setFont(new Font("Century Gothic",Font.PLAIN, 30));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setBackground(new Color(124, 104, 104));
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
