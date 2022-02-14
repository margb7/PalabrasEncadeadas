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
    private int val; // TODO: variable que significa puntuacion victoria / numRondas -->> será mejor
                     // crear dos y no usar una
    private String ultimaPalabra = "";
    private boolean rematada = false;

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
    public Partida(Xogador[] listaXogadores, byte modoXogo, int val, byte tempo, byte numMaxErros) {

        this.listaXogadores = listaXogadores;
        this.MODO_XOGO = modoXogo;
        this.TEMPO = tempo;
        this.NUM_MAX_ERROS = numMaxErros;
        this.val = val;

    }

    public void xogar() {

        String str;
        boolean turnoRematado;
        Xogador xogadorTurno;

        rematada = false;

        System.out.println(this);

        do {

            xogadorTurno = listaXogadores[numTurno];
            turnoRematado = false;

            System.out.println("@--------");
            System.out.printf(" RONDA NÚMERO %d:\n", numRonda);
            System.out.printf("     Turno de %s\n", xogadorTurno.getNome());

            do {

                str = pedirPalabra();

                if (str.equals("0")) {

                    xogadorTurno.setEstadoXogo(false);

                    if (calcularXogadoresActivos() == 1) {

                        rematada = true;

                    }

                }

                if (Scrabble.ePalabraValida(str, ultimaPalabra)) {

                    turnoRematado = true;
                    ultimaPalabra = str;

                }

            } while (!turnoRematado);

            if (!rematada) {

                xogadorTurno.setPuntos(xogadorTurno.getPuntos() + Scrabble.puntuacionPalabra(ultimaPalabra));

            }

        } while (!rematada);

        amosarResultados();

    }

    public String pedirPalabra() {

        if (!ultimaPalabra.equals("")) {

            System.out.print("Introduce unha palabra que comece por \"");
            System.out.println(ultimaPalabra.substring(ultimaPalabra.length() - 3, ultimaPalabra.length()) + "\" : ");

        } else {

            System.out.println("Introduce a primeira palabra: ");

        }

        return Entrada.lerString();
    }

    private void amosarResultados() {

        Xogador[] tablaResultados = new Xogador[listaXogadores.length];

        System.out.println("*****RESULTADOS******");

        if (calcularXogadoresActivos() == 1) {

            Xogador[] aux = new Xogador[listaXogadores.length - 1];
            int n = 0;

            for (Xogador x : listaXogadores) {

                if (x.podeXogar()) {

                    tablaResultados[0] = x;

                } else {

                    aux[n] = x;
                    n++;

                }

            }

            for (int i = 1; i < tablaResultados.length; i++) {

                tablaResultados[i] = aux[i - 1];

            }

            System.out.println("Gañou " + tablaResultados[0] + " ao non rendirse");
            System.out.println("\n-Resultados do resto: ");

            for (int i = 1; i < tablaResultados.length; i++) {

                System.out.println("\t" + tablaResultados[i]);

            }

        } else {

        }

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

            strb.append("- Se pasan ").append(TEMPO)
                    .append(" segundos sen introducir a palabra automáticamente pérdese\n");

        }

        if (NUM_MAX_ERROS != 0) {

            strb.append("- Se se cometen ").append(NUM_MAX_ERROS).append(" erros pérdese\n");

        }

        strb.append("-------------------------\n");

        return strb.toString();
    }

    private int calcularXogadoresActivos() {

        int num = 0;

        for (Xogador x : listaXogadores) {

            if (x.podeXogar()) {

                num++;

            }

        }

        return num;
    }

}
