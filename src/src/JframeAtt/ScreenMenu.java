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
        setSize( 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        //getContentPane().setBackground(Color.GRAY);

        JButton jButton = new JButton("Simular Áudio");
        jButton.setBounds(120, 215, 240, 70);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        jButton.setForeground(new Color(0, 0, 0));
        jButton.setBackground(new Color(124, 104, 104));

        add(jButton);

        JButton jButton2 = new JButton("Histórico");
        jButton2.setBounds(440, 215, 250, 70);
        jButton2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        jButton2.setForeground(new Color(0, 0, 0));
        jButton2.setBackground(new Color(124, 104, 104));
        add(jButton2);


        JLabel jLabel = new JLabel("Escoha uma das opções a seguir :");
        jLabel.setBounds(146, 100, 700, 100);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        add(jLabel);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}



