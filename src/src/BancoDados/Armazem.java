package BancoDados;

public class Armazem {
    private static Armazem instance;
    private String usuario;

    private Armazem() {
        // Construtor privado
    }

    public static synchronized Armazem getInstance() {
        if (instance == null) {
            instance = new Armazem();
        }
        return instance;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
