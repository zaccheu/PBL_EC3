package Audio;

public class Seno {

    public static double senoPorTaylor(double x) {
        // Redução do ângulo para o intervalo [-pi, pi]
        x = x % (2 * Math.PI);
        if (x < -Math.PI) {
            x += 2 * Math.PI;
        } else if (x > Math.PI) {
            x -= 2 * Math.PI;
        }

        double termo1 = x; // Primeiro termo da série que é x^1/1!
        double somaIncial = 0.0; // Inicializa a soma da série
        double xAoQuadrado = x * x; // x ao quadrado para uso nos termos
        long fatorialParaDen1 = 1; // Fatorial para os denominadores, começando de 1!
        int sinal = 1; // Sinal alternado para a série

        for (int i = 1; i <= 15; i += 2) { // Aumentar de dois em dois para obter apenas potências ímpares
            somaIncial += sinal * termo1 / fatorialParaDen1;
            termo1 *= xAoQuadrado; // Próxima potência de x, x^(i+2)
            fatorialParaDen1 *= (i + 1) * (i + 2); // Próximo fatorial, (i+2)!
            sinal *= -1; // Alternar o sinal
        }

        return somaIncial;
    }
}
