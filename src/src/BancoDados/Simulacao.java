package BancoDados;

public class Simulacao {
    private int usuarioID;
    private float frequenciaInicial;
    private float amplitudeSenoidal;
    private float velocidadeRelativa;
    private float distanciaInicial;
    private float tempoSimulacao;
    private float freqObservado;

    public Simulacao( int usuarioID, float frequenciaInicial, float amplitudeSenoidal, float velocidadeRelativa, float distanciaInicial, float tempoSimulacao, float freqObservado) {
        this.usuarioID = usuarioID;
        this.frequenciaInicial = frequenciaInicial;
        this.amplitudeSenoidal = amplitudeSenoidal;
        this.velocidadeRelativa = velocidadeRelativa;
        this.distanciaInicial = distanciaInicial;
        this.tempoSimulacao = tempoSimulacao;
        this.freqObservado = freqObservado;
    }

    // Getters
    public int getUsuarioID() {
        return usuarioID;
    }

    public float getFrequenciaInicial() {
        return frequenciaInicial;
    }

    public float getAmplitudeSenoidal() {
        return amplitudeSenoidal;
    }

    public float getVelocidadeRelativa() {
        return velocidadeRelativa;
    }

    public float getDistanciaInicial() {
        return distanciaInicial;
    }

    public float getTempoSimulacao() {
        return tempoSimulacao;
    }

    public float getFreqObservado() {
        return freqObservado;
    }
}
