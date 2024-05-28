package JframeAtt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSimAud extends JFrame
    {
        public ScreenSimAud(JFrame ScreenMenu)
        {
            JCheckBox jCheckBox;
            JCheckBox jCheckBox2;
            JCheckBox jCheckBox3;
            JCheckBox jCheckBox4;


            setTitle("Simuação Áudio");

            setSize(800, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);


            JLabel jLabel2 = new JLabel("Preencha os campos para realizar a simulação");
            jLabel2.setBounds(200, 50, 600, 40);
            jLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel2.setVisible(true);
            add(jLabel2);

            JLabel jLabel3 = new JLabel("Distância inicial:");
            jLabel3.setBounds(100, 160, 300, 40);
            jLabel3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel3.setVisible(true);

            add(jLabel3);

            JLabel jLabel4 = new JLabel("Velocidade da Fonte:");
            jLabel4.setBounds(450, 160, 300, 40);
            jLabel4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel4.setVisible(true);
            add(jLabel4);

            JLabel jLabel5 = new JLabel("Frequência Emitida (Hz):");
            jLabel5.setBounds(300, 285, 300, 40);
            jLabel5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel5.setVisible(true);
            add(jLabel5);

            JTextField text = new JTextField();
            text.setBounds(100, 200, 200, 40);
            text.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text.setForeground(new Color(104, 104, 104));
            text.setBackground(new Color(165, 165, 165));
            text.setBorder(new EmptyBorder(0,10,0,10));
            add(text);

            jCheckBox = new JCheckBox("m");
            jCheckBox.setBounds(300, 187, 60, 40);
            jCheckBox.setVisible(true);
            add(jCheckBox);

            jCheckBox2 = new JCheckBox("Km");
            jCheckBox2.setBounds(300, 213, 60, 40);
            jCheckBox2.setVisible(true);
            add(jCheckBox2);


            JTextField text2 = new JTextField();
            text2.setBounds(450, 200, 200, 40);
            text2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text2.setForeground(new Color(104, 104, 104));
            text2.setBackground(new Color(165, 165, 165));
            text2.setBorder(new EmptyBorder(0,10,0,10));
            add(text2);

            jCheckBox3 = new JCheckBox("m/s");
            jCheckBox3.setBounds(650, 187, 60, 40);
            jCheckBox3.setVisible(true);
            add(jCheckBox3);

            jCheckBox4 = new JCheckBox("Km/h");
            jCheckBox4.setBounds(650, 213, 60, 40);
            jCheckBox4.setVisible(true);
            add(jCheckBox4);

            JTextField text3 = new JTextField();
            text3.setBounds(300, 325, 200, 40);
            text3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text3.setForeground(new Color(104, 104, 104));
            text3.setBackground(new Color(165, 165, 165));
            text3.setBorder(new EmptyBorder(0,10,0,10));

            add(text3);

            JButton jButton4 = new JButton("Menu");
            jButton4.setBounds(100, 400, 200, 40);
            jButton4.setFont(new Font("Century Gothic", Font.PLAIN, 30));
            jButton4.setForeground(new Color(0, 0, 0));
            jButton4.setBackground(new Color(124, 104, 104));
            jButton4.setVisible(true);
            jButton4.setFocusable(false);
            jButton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ScreenMenu.setVisible(true);
                    dispose();
                }
            });
            add(jButton4);

            JButton jButton5 = new JButton("Gerar Áudio");
            jButton5.setBounds(500, 400, 200, 40);
            jButton5.setFont(new Font("Century Gothic", Font.PLAIN, 30));
            jButton5.setForeground(new Color(0, 0, 0));
            jButton5.setBackground(new Color(124, 104, 104));
            jButton5.setVisible(true);
            jButton5.setFocusable(false);
            add(jButton5);
            jButton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ScreenRepAud(ScreenSimAud.this);
                    dispose();
                }
            });
            setVisible(true);
        }
    }

