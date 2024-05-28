package Audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class AudioGeradorArquivo {

    public File gerarArquivo(double frqEmi, double disIni, double velFont) throws LineUnavailableException, IOException {
        // Parâmetros do efeito Doppler
        double freqFonte = frqEmi; // Frequência da sirene da ambulância em Hz
        double distanciaIncial_Obs = disIni; // Distância inicial em metros
        double veloFonte = velFont; // Velocidade da ambulância em m/s (positiva se se aproximando do observador)
        double veloSom = 343; // Velocidade do som no ar em m/s

        // Criando var para o valor da fórmula da onda senoidal
        double senoidal = 0;

        // Calculando o tempo total de percurso
        double tempoDeslocamento = distanciaIncial_Obs / veloFonte; // Tempo para a ambulância alcançar o observador
        double distanciaTotal = 2 * distanciaIncial_Obs; // Distância total que a fonte vai percorrer (ida e volta)
        double tempoTotal = distanciaTotal / veloFonte; // Tempo total para ida e volta

        // Calculando a frequência observada usando a fórmula do efeito Doppler
        double freqObservada = freqFonte * (veloSom / (veloSom - veloFonte));

        // Configurando o formato de áudio
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

        // Abrindo a linha de saída de áudio
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(audioFormat);
        line.start();

        // Ajustando o tamanho do buffer conforme a duração total
        byte[] buffer = new byte[(int) (44100 * 2 * tempoTotal)];

        // Variáveis para armazenar a amplitude máxima e mínima
        double amplitudeMax = Double.NEGATIVE_INFINITY;
        double amplitudeMin = Double.POSITIVE_INFINITY;

        // Gerando o som com variação de amplitude e frequência Doppler
        for (int i = 0; i < buffer.length / 2; i++) {
            double tempo = i / 44100.0; // Tempo atual em segundos

            // Calculando a posição da fonte no tempo atual
            double distanciaAtual = Math.abs(distanciaIncial_Obs - (veloFonte * (tempo % (2 * tempoDeslocamento))));

            // Calculando a amplitude com base na distância
            double amplitude = 1 - Math.abs(distanciaAtual / distanciaIncial_Obs);

            // Atualizando os valores de amplitude máxima e mínima
            if (amplitude > amplitudeMax) {
                amplitudeMax = amplitude;
            }
            if (amplitude < amplitudeMin) {
                amplitudeMin = amplitude;
            }

            // Gerando o sinal de áudio
            double formulaSenoidal = 2.0 * Math.PI * freqObservada * tempo;
            senoidal = formulaSenoidal;
            short taxaDeAmostragem = (short) (Seno.senoPorTaylor(formulaSenoidal) * amplitude * Short.MAX_VALUE);
            buffer[i * 2] = (byte) (taxaDeAmostragem & 0xFF);
            buffer[i * 2 + 1] = (byte) (taxaDeAmostragem >> 8);
        }

        // Gerando o nome do arquivo em ordem crescente
        File wavFile = pegaProximoNome();
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        AudioInputStream ais = new AudioInputStream(bais, audioFormat, buffer.length / 2);
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, wavFile);

        //print dos dados
        System.out.println("***ENTRADA DE DADOS***");
        System.out.println("Frequencia real da fonte: " + freqFonte + " Hz.");
        System.out.println("Distância inicial entre fonte e observador: " + distanciaIncial_Obs + " m.");
        System.out.println("Velocidade da fonte: " + veloFonte + " m/s.");
        System.out.println("***SAÍDA DE DADOS***");
        System.out.println("Tempo de deslocamento do ponto inicial ao observador: " + tempoDeslocamento + "s , tempo total de deslocamento: " + tempoTotal + "s.");
        System.out.println("Amplitude min: " + amplitudeMin + ", máx: " + amplitudeMax);
        System.out.println("Frequencia observada: " + freqObservada + " Hz");
        System.out.println("Onda senoidal: " + senoidal);
        System.out.println("***COMPARAÇÃO DOS VALORES DE SENO***");
        //seno Math.
        double senoMath = Math.sin(senoidal);
        double senoTaylor = Seno.senoPorTaylor(senoidal);
        System.out.println(String.format("Seno, lib math: %.12f , taylor: %.12f ", senoMath, senoTaylor));

        // Encerrando a linha de áudio
        line.drain();
        line.close();

        return wavFile;
    }

    private File pegaProximoNome() {
        int contaMaior = 1;
        File arquivo;
        do {
            arquivo = new File("output(" + contaMaior + ").wav");
            contaMaior++;
        } while (arquivo.exists());
        return arquivo;
    }
}
