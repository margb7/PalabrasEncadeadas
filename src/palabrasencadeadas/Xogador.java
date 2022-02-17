package palabrasencadeadas;

/**
 * Clase cos métodos e atributos relacionados cos xogadores
 * dunha partida do xogo.
 * @author a21mariogb
 */
public class Xogador {

    private String nome;
    private int puntos;
    private boolean estadoXogo;

    /**
     * Constructor da clase.
     * @param nome o nome que se amosará por pantalla para identificar ó xogador
     */
    public Xogador(String nome) {
        this.nome = nome;
        this.puntos = 0;
        estadoXogo = true;
    }

    /**
     * Método getter do atributo <em>nome</em>.
     * @return o atributo nome dun xogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getter do atributo <em>puntos</em>.
     * @return o atributo puntos dun xogador
     */
    public int getPuntos() {
        return puntos;
    }

    
    public boolean podeXogar() {
        return estadoXogo;
    }

    /**
     * Método setter do atributo <em>estadoXogo</em>.
     */
    public void setEstadoXogo(boolean estadoXogo) {
        this.estadoXogo = estadoXogo;
    }

    public void sumarPuntos(int n) {
        this.puntos += n; 
    }

    /**
     * Método que sobreescribe o método toString para esta clase.
     * @return unha cadea co nome e os puntos do xogador
     */
    @Override
    public String toString() {
        return nome + " con " + puntos + " puntos";
    }
}
