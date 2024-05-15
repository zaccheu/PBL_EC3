package Audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioGerador {

    public static void main(String[] args) throws Exception {
        //seno
        Seno taylor = new Seno();

        // Frequência desejada em Hertz
        float frequency = 440; // Exemplo: 440 Hz para a nota A
        // Duração do som em milissegundos
        int duration = 5000; // 1 segundo

        // Configurando o formato de áudio
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

        // Abrindo a linha de saída de áudio
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(audioFormat);
        line.start();

        // Ajustando o tamanho do buffer conforme a duração
        byte[] buffer = new byte[(int) (44100 * 2 * (duration / 1000.0))];

        // Gerando o som
        for (int i = 0; i < buffer.length / 2; i++) {
            double angle = 2.0 * Math.PI * frequency * i / 44100;
            short sample = (short) (taylor.sinTaylorSeries(angle) * Short.MAX_VALUE);
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
