package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Fisica.*;

public class Visual extends JFrame {

    //atributos
    private JPanel menu;
    private JButton doppler;
    private JButton historico;
    private JLabel textoMenu;

    //atributos do metodo calcular freq
    private double fPercebida;
    private  double fReal;
    private double vSom;
    private double vObservador;
    private double vFonte;
    private boolean direcao;


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
        doppler = new JButton("Simulador de Doppler");
        historico = new JButton("Histórico");

        //Add os atributos ao menu

        menu.add(textoMenu);
        menu.add(doppler);
        menu.add(historico);

        //botão do Doppler
        doppler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog simulacaoDoppler = new JDialog(Visual.this, "Simulador de Doppler");
                simulacaoDoppler.setSize(1000,500);
                simulacaoDoppler.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                simulacaoDoppler.setVisible(true);
                simulacaoDoppler.setLocationRelativeTo(null);
                simulacaoDoppler.setLayout(new GridLayout(6, 2, 10, 10));

                //entradas
                simulacaoDoppler.add(new JLabel("Velocidade do som:"));
                JTextField velocidadeSom = new JTextField();

                simulacaoDoppler.add(velocidadeSom);

                simulacaoDoppler.add(new JLabel("Frequência emitida:"));
                JTextField frequenciaEmitida = new JTextField();
                simulacaoDoppler.add(frequenciaEmitida);

                simulacaoDoppler.add(new JLabel("Velocidade do observador:"));
                JTextField velocidadeObservador = new JTextField();
                simulacaoDoppler.add(velocidadeObservador);

                simulacaoDoppler.add(new JLabel("Velocidade da fonte:"));
                JTextField velocidadeFonte = new JTextField();
                simulacaoDoppler.add(velocidadeFonte);

                // botao de afastando ou aproximando
                simulacaoDoppler.add(new JLabel());
                JPanel radioPanel = new JPanel(new FlowLayout());
                JRadioButton aproximando = new JRadioButton("Aproximando", true);
                JRadioButton afastando = new JRadioButton("Afastando");
                ButtonGroup group = new ButtonGroup();
                group.add(aproximando);
                group.add(afastando);
                radioPanel.add(aproximando);
                radioPanel.add(afastando);
                simulacaoDoppler.add(radioPanel);

                // botao para calcular
                JButton calcular = new JButton("Calcular");
                calcular.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Aqui a variável booleana 'isAproximando' armazena o estado do botão 'aproximando'
                        boolean isAproximando = aproximando.isSelected();

                        // Usar 'isAproximando' para lógica condicional
                        if (isAproximando) {
                            direcao = true;
                        } else {
                            direcao = false;
                        }

                        //parametros
                        double frqEmi = Double.parseDouble(frequenciaEmitida.getText());
                        double velSom = Double.parseDouble(velocidadeSom.getText());
                        double velObs = Double.parseDouble(velocidadeObservador.getText());
                        double velFont = Double.parseDouble(velocidadeFonte.getText());

                        //metodo calcular freq
                        fPercebida = formulaFreq(frqEmi, velSom, velObs, velFont, direcao );


                        // Aqui você pode adicionar a lógica de cálculo
                        JOptionPane.showMessageDialog(simulacaoDoppler, "Cálculo realizado! A frequencia percebida é "+fPercebida);
                    }
                });
                simulacaoDoppler.add(calcular);

                // Mostra a janela
                simulacaoDoppler.setVisible(true);



            }
        });

        //botão do histórico
        historico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame historico = new JFrame("Simulador de Doppler");
                historico.setSize(1000,500);
                historico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                historico.setVisible(true);

            }
        });

        this.setContentPane(menu);
        this.setTitle("Fisica.Doppler");
        this.setSize(1000, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(Visual.EXIT_ON_CLOSE);

    }

    private double formulaFreq(double fReal, double vSom, double vObservador, double vFonte, Boolean aproximando){

        this.fReal = fReal;
        this.vSom = vSom;
        this.vObservador = vObservador;
        this.vFonte = vFonte;
        direcao = aproximando;

        Doppler formula = new Doppler();

        return formula.formulaFreqPerc(fReal, vSom, vObservador,vFonte, direcao);
    }




    public static void main(String[] args) {
        new Visual();
    }
}
