package palabrasencadeadas;

/**
 *
 * @author a21mariogb
 */
public class Scrabble {

    /**
     * Método para calcular o valor dunha palabra
     * @param str a palabra
     * @return o seu valor.
     */
    public static int puntuacionPalabra(String str) {

        int num = 0;

        for (int i = 0; i < str.length(); i++) {

            num += puntuacionLetra(str.charAt(i));

        }

        return num;
    }
    
    /**
     * Método para calcular o valor dun caracter
     * @param c o caraacter 
     * @return o valor. Devolve 0 se non é un caracter válido
     */
    public static int puntuacionLetra(char c) {
        int punt = 0;

        c = Character.toLowerCase(c);

        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'l':
            case 'n':
            case 'r':
            case 's':
            case 't':
                punt = 1;
                break;
            case 'd':
            case 'g':
                punt = 2;
                break;
            case 'b':
            case 'c':
            case 'm':
            case 'p':
                punt = 3;
                break;
            case 'f':
            case 'h':
            case 'v':
            case 'w':
            case 'y':
                punt = 4;
                break;
            case 'k':
                punt = 5;
                break;
            case 'j':
            case 'x':
                punt = 8;
                break;
            case 'q':
            case 'z':
            case 'ñ':
                punt = 10;
                break;
        }

        return punt;
    }

    /**
     * Método para saber se a palabra introducida polo usuario é válida 
     * @param nova a nova palabra
     * @param palabraAnterior a palabra anterior
     * @return true no caso de que nova sexa correcta en lonxitude e comezo. Tamén devolve true se a palabra anterior
     * é unha cadea vacía e a nova palabra ten a lonxitude adecuada
     */
    public static boolean ePalabraValida(String nova, String palabraAnterior) {

        boolean out = false;

        if (nova.length() >= 3) {

            if (palabraAnterior.equals("")) {

                out = true;

            } else {

                String comezoNova = nova.substring(0, 3);
                String terminacionAnterior = palabraAnterior.substring(palabraAnterior.length() - 3,
                        palabraAnterior.length());

                if (comezoNova.equals(terminacionAnterior)) {

                    out = true;

                }

            }

        }

        return out;
    }

    public static String taboaPuntuacions() {

        StringBuilder puntuacions = new StringBuilder("");

        puntuacions.append("  ____________________________________\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" | A, E, I, O, U, L, N, R, S, T |  1  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |             D, G             |  2  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |          B, C, M, P          |  3  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |       F, H, V, V, W, Y       |  4  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |               K              |  5  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |             J, X             |  8  |\n");
        puntuacions.append(" |______________________________|_____|\n");
        puntuacions.append(" |                              |     |\n");
        puntuacions.append(" |            Q, Z, Ñ           |  10 |\n");
        puntuacions.append(" |______________________________|_____|\n");
        
        return puntuacions.toString();
    }

}
