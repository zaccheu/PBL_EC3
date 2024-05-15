package Audio;

public class Seno {

    public static double sinTaylorSeries(double x) {
        // Redução do ângulo para o intervalo [-pi, pi]
        x = x % (2 * Math.PI);
        if (x < -Math.PI) {
            x += 2 * Math.PI;
        } else if (x > Math.PI) {
            x -= 2 * Math.PI;
        }

        double term = x; // Primeiro termo da série que é x^1/1!
        double sum = 0.0; // Inicializa a soma da série
        double xSquared = x * x; // x ao quadrado para uso nos termos
        long factorial = 1; // Fatorial para os denominadores, começando de 1!
        int sign = 1; // Sinal alternado para a série

        for (int i = 1; i <= 15; i += 2) { // Aumentar de dois em dois para obter apenas potências ímpares
            sum += sign * term / factorial;
            term *= xSquared; // Próxima potência de x, x^(i+2)
            factorial *= (i + 1) * (i + 2); // Próximo fatorial, (i+2)!
            sign *= -1; // Alternar o sinal
        }

        return sum;
    }
}
