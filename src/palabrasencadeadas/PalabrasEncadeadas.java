
package palabrasencadeadas;

/**
 *
 * @author a21mariogb
 */
public class PalabrasEncadeadas {

    private static int puntuacionVictoria = 20;
    private static byte modoXogo;
    private static int numRondas = 5;
    private static Partida partida;

    /**
     * Método principal do proxecto Palabras Encadeadas + Scrabble
     * As melloras sore o proxecto base son: 
     *      - Implementación de tres modos de xogo
     *      - Opción a varios xogadores
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean sair = false;
        int op;

        System.out.println("#####       #####");
        System.out.println("###  SCRABBLE ###");
        System.out.println("#####       #####");

        System.out.println("");

        do {

            System.out.println("-------");
            System.out.println("MENU DE XOGO");
            System.out.println("-------");
            System.out.println("1. Xogar");
            System.out.println("2. Amosar táboa de puntuacións");
            System.out.println("3. Saír");
            System.out.println("-------");

            op = EntradaSaida.lerInt();

            switch (op) {

                case 1:
                    menuXogar();
                    break;
                case 2:
                    System.out.println(Scrabble.taboaPuntuacions());
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("**Opción incorrecta");
                    break;
            }

        } while (!sair);

    }

    /**
     * Menu para crear e iniciar a partida. Neste menú pódese elixir o modo de xogo.
     * Escóllese entre:
     * <ul>
     * <li>Modo ata a rendición</li>
     * <li>Modo chegar ata certa puntuación (por defecto x)</li>
     * <li>Modo conseguir o máximo número de puntos en certas rondas (por defecto x)
     * </li>
     * </ul>
     */
    public static void menuXogar() {
        boolean correcto;
        Xogador[] listaXogadores;

        System.out.println("# XOGAR #\n");

        listaXogadores = pedirXogadores();

        do {

            correcto = true;
            System.out.println("-------");
            System.out.println("- Escolle a condición de victoria:");
            System.out.println("-------");
            System.out.println("1. Ata a rendición");
            System.out.println("2. Chegar a x  puntos antes");
            System.out.println("3. Conseguir máis puntos x número de rondas");
            System.out.println("-------");

            modoXogo = EntradaSaida.lerByte();

            if (modoXogo < 1 || modoXogo > 3) {

                EntradaSaida.imprimirErro("**Opción incorrecta");
                correcto = false;

            }

        } while (!correcto);

        switch (modoXogo) {

            case 1:

                partida = new Partida(listaXogadores, modoXogo);
                break;

            case 2:

                System.out.println("Introduce a puntuación de victoria (mínimo 20)");
                do {

                    correcto = true;
                    puntuacionVictoria = EntradaSaida.lerInt();

                    if (puntuacionVictoria < 20) {

                        EntradaSaida.imprimirErro("Como mínimo deben ser 20 puntos");
                        correcto = false;

                    }

                } while (!correcto);

                partida = new Partida(listaXogadores, modoXogo, puntuacionVictoria);
                break;

            default:

                System.out.println("Introduce o número de rondas do xogo (mínimo 1 ronda)");
                do {
                    correcto = true;

                    numRondas = EntradaSaida.lerInt();

                    if (numRondas < 1) {

                        EntradaSaida.imprimirErro("Como mínimo 1 ronda");
                        correcto = false;

                    }

                } while (!correcto);

                partida = new Partida(listaXogadores, modoXogo, numRondas);
                break;
        }

        partida.xogar();
    }

    /**
     * Método que solicita o número de xogadores
     * e posteriormente pide os seus respectivos nomes.
     * @return a lista de xogadores, almacenada nun array
     */
    public static Xogador[] pedirXogadores() {
        Xogador[] lista;
        String str;
        int numXogadores;

        System.out.println("- Introduce o numero de xogadores [2 - 4]");

        do {

            numXogadores = EntradaSaida.lerByte();

            if (numXogadores < 2 || numXogadores > 4) {

                EntradaSaida.imprimirErro("Só se poden crear partidas de 2 a 4 xogadores");

            }

        } while (numXogadores < 2 || numXogadores > 4);

        lista = new Xogador[numXogadores];

        for (byte i = 0; i < numXogadores; i++) {

            System.out.printf("Introduce o nome do xogador número %d\n", (i + 1));

            str = EntradaSaida.lerString();
            lista[i] = new Xogador(str);

        }

        return lista;
    }
}
