/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabrasencadeadas;

import java.util.regex.Pattern;

/**
 *
 * @author a21mariogb
 */
public class Scrabble {

    public static int puntuacionPalabra(String str) {

        int num = 0;

        for (int i = 0; i < str.length(); i++) {

            num += str.charAt(i);

        }

        return num;
    }

    public static int puntuacionLetra(char c) {

        Pattern pat = Pattern.compile(Character.toString(Character.toLowerCase(c)));
        int punt = 0;

        if (pat.matcher("[aeioulnrst]").find()) {

            punt = 1;

        } else if (pat.matcher("[dg]").find()) {

            punt = 2;

        } else if (pat.matcher("[bcmp]").find()) {

            punt = 3;

        } else if (pat.matcher("[fhvwy]").find()) {

            punt = 4;

        } else if (pat.matcher("[k]").find()) {

            punt = 5;

        } else if (pat.matcher("[jx]").find()) {

            punt = 8;

        } else if (pat.matcher("[qzñ]").find()) {

            punt = 10;

        }

        return punt;
    }

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
