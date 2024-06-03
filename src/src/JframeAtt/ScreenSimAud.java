package JframeAtt;

import Audio.*;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ScreenSimAud extends JFrame {
    double frequenciaEmitida;
    double distanciaInicial;
    double velociadadeFonte;
    boolean unidadeDistanciaKm;
    boolean unidadeVelocidadeKmh;

    public ScreenSimAud(JFrame ScreenMenu) {
        JCheckBox metrosDistancia;
        JCheckBox kilometrosDistancia;
        JCheckBox metrosVelocidade;
        JCheckBox kilometrosVelocidade;

        setTitle("Simulação Áudio");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 225, 210));

        JLabel txtPrincipal = new JLabel("SIMULADOR");
        txtPrincipal.setBounds(30, 10, 250, 60);
        txtPrincipal.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        txtPrincipal.setVisible(true);
        add(txtPrincipal);

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

        //Campo DISTÂNCIA
        JLabel jLabel3 = new JLabel("Distância inicial:");
        jLabel3.setBounds(50, 240, 250, 40);
        jLabel3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        jLabel3.setVisible(true);
        add(jLabel3);

        JTextField distInicial = new JTextField();
        distInicial.setBounds(50, 280, 200, 40);
        distInicial.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        distInicial.setForeground(new Color(104, 104, 104));
        distInicial.setBackground(new Color(165, 165, 165));
        distInicial.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(distInicial);

        metrosDistancia = new JCheckBox("m");
        metrosDistancia.setBounds(250, 270, 60, 40);
        metrosDistancia.setVisible(true);
        metrosDistancia.setOpaque(false);
        add(metrosDistancia);

        kilometrosDistancia = new JCheckBox("Km");
        kilometrosDistancia.setBounds(250, 290, 60, 40);
        kilometrosDistancia.setVisible(true);
        kilometrosDistancia.setOpaque(false);
        add(kilometrosDistancia);

        metrosDistancia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (metrosDistancia.isSelected()) {
                    kilometrosDistancia.setSelected(false);
                    unidadeDistanciaKm = false;
                }
            }
        });

        kilometrosDistancia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kilometrosDistancia.isSelected()) {
                    metrosDistancia.setSelected(false);
                    unidadeDistanciaKm = true;
                }
            }
        });

        //Campo VELOCIDADE
        JLabel jLabel4 = new JLabel("Velocidade da Fonte:");
        jLabel4.setBounds(380, 240, 300, 40);
        jLabel4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        jLabel4.setVisible(true);
        add(jLabel4);

        JTextField velFonte = new JTextField();
        velFonte.setBounds(380, 280, 200, 40);
        velFonte.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        velFonte.setForeground(new Color(104, 104, 104));
        velFonte.setBackground(new Color(165, 165, 165));
        velFonte.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(velFonte);

        metrosVelocidade = new JCheckBox("m/s");
        metrosVelocidade.setBounds(580, 270, 60, 40);
        metrosVelocidade.setVisible(true);
        metrosVelocidade.setOpaque(false);
        add(metrosVelocidade);

        kilometrosVelocidade = new JCheckBox("Km/h");
        kilometrosVelocidade.setBounds(580, 290, 60, 40);
        kilometrosVelocidade.setVisible(true);
        kilometrosVelocidade.setOpaque(false);
        add(kilometrosVelocidade);

        metrosVelocidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (metrosVelocidade.isSelected()) {
                    kilometrosVelocidade.setSelected(false);
                    unidadeVelocidadeKmh = false;
                }
            }
        });

        kilometrosVelocidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kilometrosVelocidade.isSelected()) {
                    metrosVelocidade.setSelected(false);
                    unidadeVelocidadeKmh = true;
                }
            }
        });

        //Campo FREQUÊNCIA
        JLabel jLabel5 = new JLabel("Frequência Emitida (Hz):");
        jLabel5.setBounds(700, 240, 250, 40);
        jLabel5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        jLabel5.setVisible(true);
        add(jLabel5);

        JTextField freq = new JTextField();
        freq.setBounds(700, 280, 200, 40);
        freq.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        freq.setForeground(new Color(104, 104, 104));
        freq.setBackground(new Color(165, 165, 165));
        freq.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(freq);

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

        JButton geraAudio = new JButton("Gerar Áudio");
        geraAudio.setBounds(535, 480, 220, 40);
        geraAudio.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        geraAudio.setForeground(new Color(0, 0, 0));
        geraAudio.setBackground(new Color(235, 235, 235));
        geraAudio.setVisible(true);
        geraAudio.setFocusable(false);
        add(geraAudio);
        geraAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double frqEmi = Double.parseDouble(freq.getText().trim());
                    double velFont = Double.parseDouble(velFonte.getText().trim());
                    double distIni = Double.parseDouble(distInicial.getText().trim());

                    if (unidadeDistanciaKm) {
                        distIni *= 1000; // Convertendo Km para metros
                    }

                    if (unidadeVelocidadeKmh) {
                        velFont *= 1000 / 3600.0; // Convertendo Km/h para m/s
                    }

                    File wavFile = geraArquivo(frqEmi, velFont, distIni);
                    new ScreenRepAud(ScreenSimAud.this).setVisible(true);
                    openWavFile(wavFile);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos.");
                } catch (LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(jLabel8);
        setVisible(true);
    }

    private void geraSom(double fReal, double vFont, double distIni) throws LineUnavailableException, IOException {
        this.frequenciaEmitida = fReal;
        this.distanciaInicial = distIni;
        this.velociadadeFonte = vFont;

        Audio som = new Audio();
        som.gerarAudio(frequenciaEmitida, distanciaInicial, velociadadeFonte);
    }

    private File geraArquivo(double fReal, double vFont, double distIni) throws LineUnavailableException, IOException {
        this.frequenciaEmitida = fReal;
        this.distanciaInicial = distIni;
        this.velociadadeFonte = vFont;

        AudioGeradorArquivo som = new AudioGeradorArquivo();
        File wavFile = som.gerarArquivo(frequenciaEmitida, distanciaInicial, velociadadeFonte);
        return wavFile;
    }

    private void openWavFile(File file) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    desktop.open(file);
                }
            } else {
                System.out.println("Desktop is not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
