package JframeAtt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class ScreenRepAud extends JFrame
{
    public ScreenRepAud(JFrame ScreenSimAud)
    {
        setTitle("Reprodução de Áudio");
        setVisible(true);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 225, 210));

        JLabel jLabel = new JLabel("ÁUDIO");
        jLabel.setBounds(30, 10, 250, 60);
        jLabel.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        add(jLabel);

        // Label de fundo principal
        JLabel jLabel2 = new JLabel();
        jLabel2.setBounds(0, 150, 1000, 200);
        jLabel2.setBackground(new Color(210, 195, 180));
        jLabel2.setOpaque(true);
        add(jLabel2);

        // Carregar e redimensionar a imagem
        ImageIcon icon = new ImageIcon(getClass().getResource("playerIcon.png"));
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Label para exibir a imagem centralizada
        JLabel imageLabel = new JLabel(scaledIcon);
        int x = (jLabel2.getWidth() - scaledIcon.getIconWidth()) / 2;
        int y = (jLabel2.getHeight() - scaledIcon.getIconHeight()) / 2;
        imageLabel.setBounds(x, y, scaledIcon.getIconWidth(), scaledIcon.getIconHeight());
        jLabel2.add(imageLabel);

        JButton jButton6 = new JButton("Menu");
        jButton6.setBounds(225, 450, 250, 50);
        jButton6.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        jButton6.setBackground(new Color(235, 235, 235));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenMenu();
                dispose();
            }
        });
        add(jButton6);

        JButton jButton7 = new JButton("Gerar Novo Áudio");
        jButton7.setBounds(525, 450, 250, 50);
        jButton7.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        jButton7.setBackground(new Color(235, 235, 235));
        jButton7.setFocusable(false);
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenSimAud(ScreenRepAud.this);
                dispose();
            }
        });
        add(jButton7);
    }

}
