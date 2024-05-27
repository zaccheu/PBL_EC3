package JframeAtt;

import javax.swing.*;
import java.awt.*;

public class ScreenSimAud extends JFrame
    {
        public ScreenSimAud()
        {
            JCheckBox jCheckBox;
            JCheckBox jCheckBox2;
            JCheckBox jCheckBox3;
            JCheckBox jCheckBox4;


            setTitle("Simuação Áudio");
            setVisible(true);
            setSize(800, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);


            JLabel jLabel2 = new JLabel("Preencha os campos para realizar a simulação");
            jLabel2.setBounds(200, 50, 600, 40);
            jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            add(jLabel2);

            JLabel jLabel3 = new JLabel("Velocidade do Observador:");
            jLabel3.setBounds(100, 160, 300, 40);
            jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            add(jLabel3);

            JLabel jLabel4 = new JLabel("Velocidade doa Fonte:");
            jLabel4.setBounds(450, 160, 300, 40);
            jLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            add(jLabel4);

            JLabel jLabel5 = new JLabel("Frequencia Emitida:");
            jLabel5.setBounds(300, 285, 300, 40);
            jLabel5.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            add(jLabel5);

            JTextField text = new JTextField("Clique aqui");
            text.setBounds(100, 200, 200, 40);
            text.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            text.setForeground(new Color(104, 104, 104));
            text.setBackground(new Color(165, 165, 165));

            add(text);

            jCheckBox = new JCheckBox("m/s");
            jCheckBox.setBounds(300, 187, 60, 40);

            add(jCheckBox);

            jCheckBox2 = new JCheckBox("Km/h");
            jCheckBox2.setBounds(300, 213, 60, 40);

            add(jCheckBox2);


            JTextField text2 = new JTextField("Clique aqui");
            text2.setBounds(450, 200, 200, 40);
            text2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            text2.setForeground(new Color(104, 104, 104));
            text2.setBackground(new Color(165, 165, 165));

            add(text2);

            jCheckBox3 = new JCheckBox("m/s");
            jCheckBox3.setBounds(650, 187, 60, 40);

            add(jCheckBox3);

            jCheckBox4 = new JCheckBox("Km/h");
            jCheckBox4.setBounds(650, 213, 60, 40);

            add(jCheckBox4);

            JTextField text3 = new JTextField("Clique aqui");
            text3.setBounds(300, 325, 200, 40);
            text3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            text3.setForeground(new Color(104, 104, 104));
            text3.setBackground(new Color(165, 165, 165));

            add(text3);

            JButton jButton4 = new JButton("Menu");
            jButton4.setBounds(100, 400, 200, 40);
            jButton4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            jButton4.setForeground(new Color(0, 0, 0));
            jButton4.setBackground(new Color(124, 104, 104));

            add(jButton4);

            JButton jButton5 = new JButton("Gerar Áudio");
            jButton5.setBounds(500, 400, 200, 40);
            jButton5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            jButton5.setForeground(new Color(0, 0, 0));
            jButton5.setBackground(new Color(124, 104, 104));

            add(jButton5);
        }

    }

