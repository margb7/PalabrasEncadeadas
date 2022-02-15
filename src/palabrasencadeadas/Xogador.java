package palabrasencadeadas;

/**
 *
 * @author a21mariogb
 */
public class Xogador {

    private String nome;
    private int puntos;
    private boolean estadoXogo;

    public Xogador(String nome) {
        this.nome = nome;
        this.puntos = 0;
        estadoXogo = true;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean podeXogar() {
        return estadoXogo;
    }

    public void setEstadoXogo(boolean estadoXogo) {
        this.estadoXogo = estadoXogo;
    }

    public void sumarPuntos(int n) {
        this.puntos += n; 
    }

    @Override
    public String toString() {
        return nome + " con " + puntos + " puntos";
    }
}
