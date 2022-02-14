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
public class PalabrasEncadeadas {

    private static byte puntuacionVictoria = 20;
    private static byte numMaxErros = 0;
    private static byte modoXogo;
    private static byte tempo = 10;
    private static byte numRondas;
    private static Partida partida;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        boolean sair = false;
        int op;

        System.out.println("###       ###");
        System.out.println("#  Scrabble #");
        System.out.println("###       ###");

        System.out.println("");

        do {

            System.out.println("1. Regras");
            System.out.println("2. Xogar");
            System.out.println("3. Saír");

            op = Entrada.lerInt();

            switch (op) {

                case 1:
                    menuRegras();
                    break;
                case 2:
                    menuXogar();
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

    public static void menuRegras() {

        byte op;

        do {
            System.out.println("## Menú de regras ##\n");
            System.out.println("1. Mostrar regras");
            System.out.println("2. Configurar regras");

            op = Entrada.lerByte();

            if (op != 1 && op != 2) {

                System.out.println("Opción incorrecta");

            }

        } while (op != 1 && op != 2);

        if (op == 1) {

            amosarRegras();

        } else {

            menuConfiguracion();

        }
        // mostrar config

        // num err
        // tempo
        // num erros
    }

    private static void amosarRegras() {

    }

    private static void menuConfiguracion() {

    }

    /**
     * Menu para crear e iniciar a partida. Neste menú pódese elixir o modo de xogo.
     * No caso de elixir un modo de xogo cuxos valores non fosen configurados
     * previamente no menú de
     * regras daránselle valores predeterminados. Escóllese entre:
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
        System.out.println("- Introduce o numero de xogadores [2 - 4]");

        listaXogadores = crearXogadores();

        do {

            correcto = true;

            System.out.println("- Escolle a condición de victoria");
            System.out.println("1. Ata a rendición");
            System.out.println("2. Chegar a " + puntuacionVictoria + " puntos antes");
            System.out.println("3. Conseguir máis puntos en " + numRondas + " rondas");

            modoXogo = Entrada.lerByte();

            if (modoXogo < 1 || modoXogo > 3) {

                System.out.println("Opción incorrecta");
                correcto = false;

            }

        } while (!correcto);

        // Para cada modo de xogo os seus argumentos

        if (modoXogo == 1) {

            partida = new Partida(listaXogadores, modoXogo, tempo, numMaxErros);

        } else if (modoXogo == 2) {

            partida = new Partida(listaXogadores, modoXogo, puntuacionVictoria, tempo, numMaxErros);

        } else {

            partida = new Partida(listaXogadores, numRondas, modoXogo, tempo, numMaxErros);

        }

        partida.xogar();
    }

    public static Xogador[] crearXogadores() {
        Xogador[] lista;
        String str;
        int numXogadores;

        do {

            numXogadores = Entrada.lerByte();

            if (numXogadores < 2 || numXogadores > 4) {

                System.out.println("Só se poden crear partidas de 2 a 4 xogadores");

            }

        } while (numXogadores < 2 || numXogadores > 4);

        lista = new Xogador[numXogadores];

        for (byte i = 0; i < numXogadores; i++) {

            System.out.printf("Introduce o nome do xogador número %d\n", (i + 1));

            str = Entrada.lerString();
            lista[i] = new Xogador(str);

        }

        return lista;
    }
}
