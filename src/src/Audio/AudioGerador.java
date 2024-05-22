package Audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioGerador {

    public static void main(String[] args) throws Exception {
        // Parâmetros do efeito Doppler
        double freqFonte = 1000; // Frequência da sirene da ambulância em Hz
        double distanciaIncial_Obs = 200; // Distância inicial em metros
        double veloFonte = 30; // Velocidade da ambulância em m/s (positiva se se aproximando do observador)
        double veloSom = 343; // Velocidade do som no ar em m/s

        // Calculando o tempo total de percurso
        double tempoDeslocamento = distanciaIncial_Obs / veloFonte; // Tempo para a ambulância alcançar o observador
        double distanciaTotal = 2 * distanciaIncial_Obs; // Distância total que a fonte vai percorrer (ida e volta)
        double tempoTotal = distanciaTotal / veloFonte; // Tempo total para ida e volta

        // Configurando o formato de áudio
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

        // Abrindo a linha de saída de áudio
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(audioFormat);
        line.start();

        // Ajustando o tamanho do buffer conforme a duração total
        byte[] buffer = new byte[(int) (44100 * 2 * tempoTotal)];

        // Frequência da modulação de amplitude
        double freqModular = 0.7; // Frequência da modulação em Hz (ajuste conforme necessário)

        // Gerando o som com variação de amplitude e frequência Doppler
        for (int i = 0; i < buffer.length / 2; i++) {
            double tempo = i / 44100.0; // Tempo atual em segundos

            // Calculando a posição da fonte no tempo atual
            double distanciaAtual = Math.abs(distanciaIncial_Obs - veloFonte * tempo % distanciaTotal);

            // Calculando a frequência observada usando a fórmula do efeito Doppler
            double freqObservada = freqFonte * (veloSom / (veloSom - veloFonte));

            // Calculando a amplitude com base na distância
            double amplitudeFactor = 1 - Math.abs(distanciaAtual / distanciaIncial_Obs);
            double amplitude = Math.sin(2.0 * Math.PI * freqModular * tempo) * amplitudeFactor; // Variação de amplitude

            // Gerando o sinal de áudio
            double angle = 2.0 * Math.PI * freqObservada * tempo;
            short sample = (short) (Math.sin(angle) * amplitude * Short.MAX_VALUE);
            buffer[i * 2] = (byte) (sample & 0xFF);
            buffer[i * 2 + 1] = (byte) (sample >> 8);
        }

        // Escrevendo os dados no buffer
        line.write(buffer, 0, buffer.length);

        // Encerrando a linha de áudio
        line.drain();
        line.close();
    }
}
