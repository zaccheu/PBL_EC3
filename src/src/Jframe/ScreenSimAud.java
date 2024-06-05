package Jframe;

import Audio.*;
import BancoDados.BancoDeDados;
import Jframe.ScreenMenu;
import Jframe.ScreenRepAud;

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
    private ScreenMenu screenMenu; // Adicione essa linha

    public ScreenSimAud(JFrame screenMenu) {
        this.screenMenu = (ScreenMenu) screenMenu; // Adicione essa linha

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

        JLabel labelTitulo = new JLabel("SIMULADOR");
        labelTitulo.setBounds(30, 10, 250, 60);
        labelTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        labelTitulo.setVisible(true);
        add(labelTitulo);

        //Label de fundo principal
        JLabel labelFundoCentral = new JLabel();
        labelFundoCentral.setBounds(0, 180, 1000, 230);
        labelFundoCentral.setBackground(new Color(210, 195, 180));
        labelFundoCentral.setVisible(true);
        labelFundoCentral.setOpaque(true);

        //Label de fundo do Título
        JLabel labelFundoSuperior = new JLabel();
        labelFundoSuperior.setBounds(0, 35, 1000, 5);
        labelFundoSuperior.setBackground(Color.white);
        labelFundoSuperior.setVisible(true);
        labelFundoSuperior.setOpaque(true);
        add(labelFundoSuperior);

        //Label de fundo do Título
        JLabel labelFundoSuperior2 = new JLabel();
        labelFundoSuperior2.setBounds(0, 45, 1000, 5);
        labelFundoSuperior2.setBackground(Color.white);
        labelFundoSuperior2.setVisible(true);
        labelFundoSuperior2.setOpaque(true);
        add(labelFundoSuperior2);

        //Label de texto explicativo
        JLabel textoExplicativo = new JLabel("Preencha os campos abaixo para realizar a simulação: ");
        textoExplicativo.setBounds(150, 110, 800, 50);
        textoExplicativo.setFont(new Font("Century Gothic", Font.PLAIN, 27));
        textoExplicativo.setVisible(true);
        add(textoExplicativo);

        //Campo DISTÂNCIA
        JLabel labelDistancia = new JLabel("Distância inicial:");
        labelDistancia.setBounds(50, 240, 250, 40);
        labelDistancia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        labelDistancia.setVisible(true);
        add(labelDistancia);

        JTextField textBoxDistancia = new JTextField();
        textBoxDistancia.setBounds(50, 280, 200, 40);
        textBoxDistancia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textBoxDistancia.setForeground(new Color(104, 104, 104));
        textBoxDistancia.setBackground(new Color(165, 165, 165));
        textBoxDistancia.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(textBoxDistancia);

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
        JLabel labelVelocidade = new JLabel("Velocidade da Fonte:");
        labelVelocidade.setBounds(380, 240, 300, 40);
        labelVelocidade.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        labelVelocidade.setVisible(true);
        add(labelVelocidade);

        JTextField textBoxVelocidade = new JTextField();
        textBoxVelocidade.setBounds(380, 280, 200, 40);
        textBoxVelocidade.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textBoxVelocidade.setForeground(new Color(104, 104, 104));
        textBoxVelocidade.setBackground(new Color(165, 165, 165));
        textBoxVelocidade.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(textBoxVelocidade);

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
        JLabel labelFrequencia = new JLabel("Frequência Emitida (Hz):");
        labelFrequencia.setBounds(700, 240, 250, 40);
        labelFrequencia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        labelFrequencia.setVisible(true);
        add(labelFrequencia);

        JTextField textBoxFrequencia = new JTextField();
        textBoxFrequencia.setBounds(700, 280, 200, 40);
        textBoxFrequencia.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textBoxFrequencia.setForeground(new Color(104, 104, 104));
        textBoxFrequencia.setBackground(new Color(165, 165, 165));
        textBoxFrequencia.setBorder(new EmptyBorder(0, 10, 0, 10));
        add(textBoxFrequencia);

        //Botôes Menu e Gerar áudio
        JButton botaoMenu = new JButton("Menu");
        botaoMenu.setBounds(235, 480, 220, 40);
        botaoMenu.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        botaoMenu.setForeground(new Color(0, 0, 0));
        botaoMenu.setBackground(new Color(235, 235, 235));
        botaoMenu.setVisible(true);
        botaoMenu.setFocusable(false);
        botaoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenMenu.setVisible(true); // Altere aqui para usar screenMenu
                dispose();
            }
        });
        add(botaoMenu);

        JButton botaoGerarAudio = new JButton("Gerar Áudio");
        botaoGerarAudio.setBounds(535, 480, 220, 40);
        botaoGerarAudio.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        botaoGerarAudio.setForeground(new Color(0, 0, 0));
        botaoGerarAudio.setBackground(new Color(235, 235, 235));
        botaoGerarAudio.setVisible(true);
        botaoGerarAudio.setFocusable(false);
        add(botaoGerarAudio);
        botaoGerarAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double frqEmi = Double.parseDouble(textBoxFrequencia.getText().trim());
                    double velFont = Double.parseDouble(textBoxVelocidade.getText().trim());
                    double distIni = Double.parseDouble(textBoxDistancia.getText().trim());

                    if (unidadeDistanciaKm) {
                        distIni *= 1000; // Convertendo Km para metros
                    }

                    if (unidadeVelocidadeKmh) {
                        velFont = conversaoKms(velFont); // Convertendo Km/h para m/s
                    }

                    File wavFile = geraArquivo(frqEmi, velFont, distIni);
                    new ScreenRepAud((ScreenMenu) screenMenu).setVisible(true);
                    openWavFile(wavFile);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos.");
                } catch (LineUnavailableException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(labelFundoCentral);
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

    private double conversaoKms(double velociadadeFonte){
        BancoDeDados conversao = new BancoDeDados();
        return conversao.functionConversao((float) velociadadeFonte);
    }
}
