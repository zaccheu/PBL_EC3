import java.util.Scanner;
public class Doppler {
    Scanner ler = new Scanner(System.in);
    private double fPercebida;
    private  double fReal;
    private double vSom;
    private double vObservador;
    private double vFonte;

    public double formulaFreqPerc(Boolean aproximando){
        System.out.println("Digite a frequencia da fonte: ");
        fReal= ler.nextDouble();
        System.out.println("Digite a velocidade do som: ");
        vSom= ler.nextDouble();
        System.out.println("Digite a velocidade do observador: ");
        vObservador= ler.nextDouble();
        System.out.println("Digite a velocidade da fonte: ");
        vFonte= ler.nextDouble();

        if(aproximando){
            fPercebida = fReal*(vSom+vObservador)/(vSom-vFonte);
        }else{
            fPercebida = fReal*(vSom-vObservador)/(vSom+vFonte);
        }
        System.out.println(fPercebida);
        return fPercebida;
    }
}
