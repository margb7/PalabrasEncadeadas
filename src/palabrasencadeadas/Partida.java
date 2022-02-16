package palabrasencadeadas;


/**
 *
 * @author a21mariogb
 */
public class Partida {

    private final byte MODO_XOGO;

    private Xogador[] listaXogadores;               
    private byte numTurno = 0;              
    private byte numRonda = 0;
    private int val;
    private String ultimaPalabra = "";
    private boolean rematada = false;

    /**s
     * Constructor para o modo Rendición
     * 
     * @param listaXogadores
     * @param modoXogo
     * @param tempo
     * @param numMaxErros
     */
    public Partida(Xogador[] listaXogadores, byte modoXogo) {
        this(listaXogadores, modoXogo, -1);
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
    public Partida(Xogador[] listaXogadores, byte modoXogo, int val) {

        this.listaXogadores = listaXogadores;
        this.MODO_XOGO = modoXogo;
        this.val = val;

    }

    public void xogar() {

        String str;
        boolean turnoRematado;
        int puntuacionObtida;
        Xogador xogadorTurno;

        System.out.println(this);

        do {    // ronda

            System.out.println("-------------------------------------");
            System.out.printf(" -# RONDA NÚMERO %d #-\n", (numRonda + 1));

            numTurno = 0;

            for(int i = 0; i < listaXogadores.length && !rematada; i++ ) {      // turno

                puntuacionObtida = 0;
                turnoRematado = false; 
                xogadorTurno = null;

                do {

                    if(numTurno > listaXogadores.length) {

                        numTurno = 0;

                    }

                    if(listaXogadores[numTurno].podeXogar() ) {

                        xogadorTurno = listaXogadores[numTurno];

                    } else {

                        numTurno++;

                    }

                } while(xogadorTurno == null);
                
                System.out.println("--Turno de " + xogadorTurno); 

                do {

                    str = pedirPalabra();

                    if (str.equals("0")) {

                        xogadorTurno.setEstadoXogo(false);
                        turnoRematado = true;

                        if (calcularXogadoresActivos() == 1) {

                            rematada = true;

                        }

                    }

                    if (!turnoRematado){

                        if(Scrabble.ePalabraValida(str, ultimaPalabra)) {

                            turnoRematado = true;
                            ultimaPalabra = str;

                        } else {

                            EntradaSaida.imprimirErro("\tERRO: A palabra debe ter 3 caracteres polo menos e coincidir co final de "  + ultimaPalabra);

                        }

                    }


                } while (!turnoRematado);

                if(xogadorTurno.podeXogar()) {
                 
                    puntuacionObtida = Scrabble.puntuacionPalabra(str);
                    xogadorTurno.sumarPuntos(puntuacionObtida);

                    System.out.println(ultimaPalabra + " vale " + puntuacionObtida + " puntos\n");

                    if(MODO_XOGO == 2) {

                        if(xogadorTurno.getPuntos() >= val) {

                            rematada = true;

                        }

                    }

                    numTurno++;

                }
                
            }
            
            if(MODO_XOGO == 3 ) {

                if(numRonda == val ) {

                    rematada = true;

                }

            }

            if(!rematada ) {

                numRonda++;

            } 

        } while (!rematada);

        amosarResultados();
    }
    
    private String pedirPalabra() {

        if (!ultimaPalabra.equals("")) {

            System.out.print("\tIntroduce unha palabra que comece por \"");
            System.out.println(ultimaPalabra.substring(ultimaPalabra.length() - 3, ultimaPalabra.length()) + "\" : ");

        } else {

            System.out.println("\tIntroduce a primeira palabra: ");

        }

        return EntradaSaida.lerString();
    }

    private void amosarResultados() {

        System.out.println("\n*****RESULTADOS******");

        if (calcularXogadoresActivos() == 1) {    // so un xogador restante

            Xogador[] tablaResultados = new Xogador[listaXogadores.length];
            int n = 0;

            for (Xogador x : listaXogadores) {

                if (x.podeXogar()) {

                    tablaResultados[0] = x;

                } else {

                    tablaResultados[n++ + 1] = x;

                }

            }

            System.out.println("Gañou " + tablaResultados[0]);
            System.out.println("\n-Resultados do resto: ");

            for (int i = 1; i < tablaResultados.length; i++) {

                System.out.println("\t" + tablaResultados[i]);

            }

        } else {

            ordenarPorPuntos(listaXogadores);

            if( MODO_XOGO == 2 ) { 

                System.out.println("Gañou " + listaXogadores[listaXogadores.length - 1] + " ao chegar antes a " + val + " puntos" );
                System.out.println("\n***Resultados do resto de xogadores***");

                for(int i = listaXogadores.length - 2; i >= 0; i-- ) {

                    System.out.println("-" + listaXogadores[i]);

                }


            } else {

                int offset = 0;

                if (listaXogadores[listaXogadores.length - 1].getPuntos() != listaXogadores[listaXogadores.length - 2].getPuntos() ) {

                    System.out.println("Gañou " + listaXogadores[listaXogadores.length - 1] + " ao obter mais puntuación en " + val + " rondas");

                } else {    // Empate

                    int puntuacion = listaXogadores[listaXogadores.length - 1].getPuntos();

                    for(int i = 0 ; i < listaXogadores.length - 2; i++ ) {

                        if(listaXogadores[i].getPuntos() == puntuacion ) {

                            offset++;

                        }

                    }

                    System.out.print("Empate entre ");

                    for(int i = listaXogadores.length; i >= listaXogadores.length- 1 - offset; i-- ) {

                        System.out.print(listaXogadores[i].getNome() + " ");

                    }

                    System.out.println("");

                }

                if(offset != listaXogadores.length) {
                
                    System.out.println("Resultados do resto de xogadores:");

                    for(int i = listaXogadores.length - 2 - offset; i >= 0; i-- ) {

                        System.out.println("-" + listaXogadores[i]);

                    }

                }


            }

        }

    }

    private static void ordenarPorPuntos(Xogador[] lista ) {

        int numIntercambios = 0;
        boolean ordenado = false;
        Xogador aux;

        while (!ordenado) {

            for (int i = 0; i < lista.length - 1; i++) {

                if (lista[i].getPuntos() > lista[i + 1].getPuntos()) {

                    aux = lista[i];

                    lista[i] = lista[i + 1];
                    lista[i + 1] = aux;

                    numIntercambios++;
                }

            }

            if (numIntercambios == 0) { 

                ordenado = true;

            }

            numIntercambios = 0; 
        }
    }

    private int calcularXogadoresActivos() {
        int num = 0;

        for(Xogador x : listaXogadores ) {

            if(x.podeXogar()) {

                num++;

            }

        } 

        return num;
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

        strb.append("-------------------------\n");

        return strb.toString();
    }  

}
