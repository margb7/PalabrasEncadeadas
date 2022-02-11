/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasencadeadas;

/**
 *
 * @author a21mariogb
 */
public class Partida {

    private final byte TEMPO;
    private final byte MODO_XOGO;
    private final byte NUM_MAX_ERROS;

    private Xogador[] listaXogadores;
    private byte numTurno = 0;
    private byte numRonda = 1;
    private byte val; // TODO: variable con dos significados -->> será mejor crear dos y no usar una
    private String ultimaPalabra = "";

    /**
     * Constructor para o modo Rendición
     * 
     * @param listaXogadores
     * @param modoXogo
     * @param tempo
     * @param numMaxErros
     */
    public Partida(Xogador[] listaXogadores, byte modoXogo, byte tempo, byte numMaxErros) {

        this.listaXogadores = listaXogadores;
        this.MODO_XOGO = modoXogo;
        this.TEMPO = tempo;
        this.NUM_MAX_ERROS = numMaxErros;

    }

    /**
     * Constructor para o modo puntuación e modo rondas
     * 
     * @param listaXogadores
     * @param modoXogo
     * @param val
     * @param tempo
     * @param numMaxErros
     */
    public Partida(Xogador[] listaXogadores, byte modoXogo, byte val, byte tempo, byte numMaxErros) {

        this.listaXogadores = listaXogadores;
        this.MODO_XOGO = modoXogo;
        this.TEMPO = tempo;
        this.NUM_MAX_ERROS = numMaxErros;

        if (modoXogo == 2) {

            

        } else {



        }

    }

    public void xogar() {

       
        amosarTurno();
        System.out.println(this);

    }

    public void amosarTurno() {
        
        System.out.println("@--------");
        System.out.printf(" RONDA NÚMERO %d:\n", numRonda);
        System.out.printf("     Turno de %s\n",  buscarPorTurno(numTurno).getNome());
        


    }

    @Override
    public String toString() {

        StringBuilder strb = new StringBuilder("");

        strb.append("-------------------------\n");
        strb.append("Partida de ").append(listaXogadores.length).append(" xogadores ( ");

        for (Xogador x : listaXogadores) {

            strb.append(x.getNome()).append(" ");

        }

        strb.append(")\n");

        switch (MODO_XOGO) {
            case 1:
                strb.append("- Modo de xogo: ata a rendición\n");
                break;
            case 2:
                strb.append("- Modo de xogo: chegar ata ").append(val).append(" antes\n");
                break;
            default:
                strb.append("- Modo de xogo: conseguir máis puntos en ").append(val).append(" rondas\n");
                break;
        }

        if (TEMPO != 0) {

            strb.append("- Se pasan ").append(TEMPO).append(" segundos sen introducir a palabra automáticamente pérdese\n");

        }

        if (NUM_MAX_ERROS != 0) {

            strb.append("- Se se cometen ").append(NUM_MAX_ERROS).append(" erros pérdese\n");

        }

        strb.append("-------------------------\n");

        return strb.toString();
    }

    private Xogador buscarPorTurno(byte num) {

        Xogador out = null;

        for (byte i = 0; i < listaXogadores.length; i++) {

            if (listaXogadores[i].getTurno() == num) {

                out = listaXogadores[i];

            }

        }

        return out;
    }

}
