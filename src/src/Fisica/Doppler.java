package Fisica;

public class Doppler {
    private double fPercebida;
    private  double fReal;
    private double vSom;
    private double vObservador;
    private double vFonte;

    public double formulaFreqPerc(double fReal, double vSom, double vObservador, double vFonte, Boolean aproximando){
        this.fReal = fReal;
        this.vSom = vSom;
        this.vObservador = vObservador;
        this.vFonte = vFonte;

        if(aproximando){
            fPercebida = fReal*(vSom+vObservador)/(vSom-vFonte);
        }else{
            fPercebida = fReal*(vSom-vObservador)/(vSom+vFonte);
        }
        System.out.println(fPercebida);
        return fPercebida;
    }
}
