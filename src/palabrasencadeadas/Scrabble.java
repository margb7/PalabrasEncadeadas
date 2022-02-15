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
public class Scrabble {

    /**
     * Método para calcular o valor dunha palabra
     * @param str a palabra
     * @return o seu valor.
     */
    public static int puntuacionPalabra(String str) {

        int num = 0;

        for (int i = 0; i < str.length(); i++) {

            num += str.charAt(i);

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

        if (nova.length() > 3) {

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

}
