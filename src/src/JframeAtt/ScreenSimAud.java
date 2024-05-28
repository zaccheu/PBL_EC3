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


            setTitle("Simulação Áudio");

            setSize(1000, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);
            getContentPane().setBackground(new Color(240, 225, 210));

            JLabel jLabel = new JLabel("SIMULADOR");
            jLabel.setBounds(30, 10, 250, 60);
            jLabel.setFont(new Font("Century Gothic", Font.PLAIN, 35));
            jLabel.setVisible(true);
            add(jLabel);

            //Label de fundo principal
            JLabel jLabel8 = new JLabel();
            jLabel8.setBounds(0, 180, 1000, 230);
            jLabel8.setBackground(new Color(210, 195, 180));
            jLabel8.setVisible(true);
            jLabel8.setOpaque(true);


            //Label de fundo do Título
            JLabel jLabel7 = new JLabel();
            jLabel7.setBounds(0, 35, 1000, 5);
            jLabel7.setBackground(Color.white);
            jLabel7.setVisible(true);
            jLabel7.setOpaque(true);
            add(jLabel7);

            //Label de fundo do Título
            JLabel jLabel6 = new JLabel();
            jLabel6.setBounds(0, 45, 1000, 5);
            jLabel6.setBackground(Color.white);
            jLabel6.setVisible(true);
            jLabel6.setOpaque(true);
            add(jLabel6);

            JLabel jLabel2 = new JLabel("Preencha os campos abaixo para realizar a simulação: ");
            jLabel2.setBounds(150, 110, 800, 50);
            jLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 27));
            jLabel2.setVisible(true);
            add(jLabel2);

            //Campo DISTÃNCIA
            JLabel jLabel3 = new JLabel("Distância inicial:");
            jLabel3.setBounds(50, 240, 250, 40);
            jLabel3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel3.setVisible(true);
            add(jLabel3);

            JTextField text = new JTextField();
            text.setBounds(50, 280, 200, 40);
            text.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text.setForeground(new Color(104, 104, 104));
            text.setBackground(new Color(165, 165, 165));
            text.setBorder(new EmptyBorder(0,10,0,10));
            add(text);

            jCheckBox = new JCheckBox("m");
            jCheckBox.setBounds(250, 270, 60, 40);
            jCheckBox.setVisible(true);
            jCheckBox.setOpaque(false);
            add(jCheckBox);

            jCheckBox2 = new JCheckBox("Km");
            jCheckBox2.setBounds(250, 290, 60, 40);
            jCheckBox2.setVisible(true);
            jCheckBox2.setOpaque(false);
            add(jCheckBox2);

            //Campo VELOCIDADE
            JLabel jLabel4 = new JLabel("Velocidade da Fonte:");
            jLabel4.setBounds(380, 240, 300, 40);
            jLabel4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel4.setVisible(true);
            add(jLabel4);

            JTextField text2 = new JTextField();
            text2.setBounds(380, 280, 200, 40);
            text2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text2.setForeground(new Color(104, 104, 104));
            text2.setBackground(new Color(165, 165, 165));
            text2.setBorder(new EmptyBorder(0,10,0,10));
            add(text2);

            jCheckBox3 = new JCheckBox("m/s");
            jCheckBox3.setBounds(580, 270, 60, 40);
            jCheckBox3.setVisible(true);
            jCheckBox3.setOpaque(false);
            add(jCheckBox3);

            jCheckBox4 = new JCheckBox("Km/h");
            jCheckBox4.setBounds(580, 290, 60, 40);
            jCheckBox4.setVisible(true);
            jCheckBox4.setOpaque(false);
            add(jCheckBox4);

            //Campo FREQUÊNCIA
            JLabel jLabel5 = new JLabel("Frequência Emitida (Hz):");
            jLabel5.setBounds(700, 240, 250, 40);
            jLabel5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            jLabel5.setVisible(true);
            add(jLabel5);

            JTextField text3 = new JTextField();
            text3.setBounds(700, 280, 200, 40);
            text3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
            text3.setForeground(new Color(104, 104, 104));
            text3.setBackground(new Color(165, 165, 165));
            text3.setBorder(new EmptyBorder(0,10,0,10));
            add(text3);

            //Botôes Menu e Gerar áudio
            JButton jButton4 = new JButton("Menu");
            jButton4.setBounds(235, 480, 220, 40);
            jButton4.setFont(new Font("Century Gothic", Font.PLAIN, 23));
            jButton4.setForeground(new Color(0, 0, 0));
            jButton4.setBackground(new Color(235, 235, 235));
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
            jButton5.setBounds(535, 480, 220, 40);
            jButton5.setFont(new Font("Century Gothic", Font.PLAIN, 23));
            jButton5.setForeground(new Color(0, 0, 0));
            jButton5.setBackground(new Color(235, 235, 235));
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

            add(jLabel8);
            setVisible(true);
        }
    }

