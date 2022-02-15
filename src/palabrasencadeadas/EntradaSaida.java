package palabrasencadeadas;

import java.util.Scanner;

/**
 *
 * @author a21mariogb
 */
public class EntradaSaida {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Scanner input = new Scanner(System.in);

    private static void error(String tipoEsperado) {

        imprimirErro("Esperábase un " + tipoEsperado);
        
    }

    public static long lerLong() {

        long salida;

        do {

            if (input.hasNext() && !input.hasNextLong()) {
                error("long");
                input.nextLine();
            }

        } while (!input.hasNextLong());

        salida = input.nextLong();
        input.nextLine();

        return salida;
    }

    public static int lerInt() {

        int salida;

        do {

            if (input.hasNext() && !input.hasNextInt()) {
                error("int");
                input.nextLine();
            }

        } while (!input.hasNextInt());

        salida = input.nextInt();
        input.nextLine();

        return salida;
    }

    public static short lerShort() {

        short salida;

        do {

            if (input.hasNext() && !input.hasNextShort()) {
                error("short");
                input.nextLine();
            }

        } while (!input.hasNextShort());

        salida = input.nextShort();
        input.nextLine();

        return salida;
    }

    public static byte lerByte() {

        byte salida;

        do {

            if (input.hasNext() && !input.hasNextByte()) {
                error("byte");
                input.nextLine();
            }

        } while (!input.hasNextByte());

        salida = input.nextByte();
        input.nextLine();

        return salida;
    }

    public static float lerFloat() {

        float salida;

        do {

            if (input.hasNext() && !input.hasNextFloat()) {
                error("float");
                input.nextLine();
            }

        } while (!input.hasNextFloat());

        salida = input.nextFloat();
        input.nextLine();

        return salida;
    }

    public static double lerDouble() {

        double salida;

        do {

            if (input.hasNext() && !input.hasNextDouble()) {
                error("double");
                input.nextLine();
            }

        } while (!input.hasNextDouble());

        salida = input.nextDouble();
        input.nextLine();

        return salida;
    }

    public static boolean lerBoolean() {

        boolean salida;

        do {

            if (input.hasNext() && !input.hasNextBoolean()) {
                error("boolean");
                input.nextLine();
            }

        } while (!input.hasNextBoolean());

        salida = input.nextBoolean();
        input.nextLine();

        return salida;
    }

    public static String lerString() {
        return input.nextLine();
    }

    public static char lerChar() {
        return input.nextLine().charAt(0);
    }

    public static void imprimirErro(String str) {

        System.out.println(ANSI_RED + str + ANSI_RESET);

    }
}