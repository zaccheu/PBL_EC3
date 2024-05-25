package Jframe;

<<<<<<< Updated upstream
import Audio.AudioGeradorTeste;
import Fisica.Doppler;
=======
import Audio.Audio;
import Audio.AudioGerador;
import Audio.AudioGeradorArquivo;
>>>>>>> Stashed changes

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Visual extends JFrame {

    //atributos
    private JPanel menu;
    private JButton botaoDoppler;
    private JButton botaoHistorico;
    private JLabel textoMenu;

    //atributos do metodo (calcular) som

    double frequenciaEmitida;
    double distanciaInicial;
    double velociadadeFonte;




    public Visual(){

        //configuração da primeira pagina
        setTitle("PBL");
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //configurando o GridBagLayout
        menu = new JPanel();

        //texto do menu
        textoMenu = new JLabel("Menu, escolha a opçõa desejada.");
        textoMenu.setVisible(true);

        //Botões
        botaoDoppler = new JButton("Simulador de Doppler");
        botaoHistorico = new JButton("Histórico");

        //Add os atributos ao menu

        menu.add(textoMenu);
        menu.add(botaoDoppler);
        menu.add(botaoHistorico);

        //botão do Doppler
        botaoDoppler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog simulacaoDoppler = new JDialog(Visual.this, "Simulador de Doppler");
                simulacaoDoppler.setSize(1000,500);
                simulacaoDoppler.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                simulacaoDoppler.setVisible(true);
                simulacaoDoppler.setLocationRelativeTo(null);
                simulacaoDoppler.setLayout(new GridLayout(4, 2, 10, 10));

                //entradas
                simulacaoDoppler.add(new JLabel("Distância inicial:"));
                JTextField velocidadeFonte = new JTextField();

                simulacaoDoppler.add(velocidadeFonte);

                simulacaoDoppler.add(new JLabel("Frequência emitida:"));
                JTextField frequenciaEmitida = new JTextField();
                simulacaoDoppler.add(frequenciaEmitida);

                simulacaoDoppler.add(new JLabel("Velocidade da fonte:"));
                JTextField distanciaInicial = new JTextField();
                simulacaoDoppler.add(distanciaInicial);
<<<<<<< Updated upstream
=======

                //
>>>>>>> Stashed changes


                // botao para calcular
                JButton calcular = new JButton("Calcular");
                calcular.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //parametros
                        double frqEmi = Double.parseDouble(frequenciaEmitida.getText());
                        double velFont = Double.parseDouble(velocidadeFonte.getText());
                        double disIni = Double.parseDouble(distanciaInicial.getText());

                        try {
                            geraSOm(frqEmi, velFont, disIni);
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
<<<<<<< Updated upstream
=======
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
>>>>>>> Stashed changes
                        }


                        // Aqui você pode adicionar a lógica de cálculo
                        //JOptionPane.showMessageDialog(simulacaoDoppler, "Cálculo realizado! A frequencia percebida é "+fPercebida);
                    }


                });
                simulacaoDoppler.add(calcular);

                JButton arquivo = new JButton("Gerar Arquivo");
                arquivo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //parametros
                        double frqEmi = Double.parseDouble(frequenciaEmitida.getText());
                        double velFont = Double.parseDouble(velocidadeFonte.getText());
                        double disIni = Double.parseDouble(distanciaInicial.getText());

                        try {
                            geraArquivo(frqEmi, velFont, disIni);
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                });
                simulacaoDoppler.add(arquivo);
                // Mostra a janela
                simulacaoDoppler.setVisible(true);



            }
        });

        //botão do histórico
        botaoHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame historico = new JFrame("Simulador de Doppler");
                historico.setSize(1000,500);
                historico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                historico.setVisible(true);
                historico.setLocationRelativeTo(null);

            }
        });

        this.setContentPane(menu);
        this.setTitle("Fisica.Doppler");
        this.setSize(1000, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(Visual.EXIT_ON_CLOSE);

    }

<<<<<<< Updated upstream
    private void geraSOm(double fReal, double vFont, double distIni) throws LineUnavailableException {
=======
    private void geraSOm(double fReal, double vFont, double distIni) throws LineUnavailableException, IOException {
>>>>>>> Stashed changes

        this.frequenciaEmitida = fReal;
        this.distanciaInicial = distIni;
        this.velociadadeFonte = vFont;

<<<<<<< Updated upstream
        AudioGeradorTeste som = new AudioGeradorTeste();
        som.gerarAudio(frequenciaEmitida, velociadadeFonte, distanciaInicial);
=======
        Audio arquivo = new Audio();
        arquivo.gerarAudio(frequenciaEmitida, velociadadeFonte, distanciaInicial);
>>>>>>> Stashed changes
    }

    private void geraArquivo(double fReal, double vFont, double distIni) throws LineUnavailableException, IOException {
        this.frequenciaEmitida = fReal;
        this.distanciaInicial = distIni;
        this.velociadadeFonte = vFont;

        AudioGeradorArquivo som = new AudioGeradorArquivo();
        som.gerarArquivo(frequenciaEmitida, velociadadeFonte, distanciaInicial);
    }



    public static void main(String[] args) {
        new Visual();
    }
}
