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
public class Xogador {

    private String nome;
    private int puntos;
    private byte numErros;
    private boolean estadoXogo;

    public Xogador(String nome) {
        this.nome = nome;
        this.puntos = 0;
        estadoXogo = true;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntos() {
        return puntos;
    }

    public byte getNumErros() {
        return numErros;
    }

    public boolean podeXogar() {
        return estadoXogo;
    }

    public void setEstadoXogo(boolean estadoXogo) {
        this.estadoXogo = estadoXogo;
    }

    public void setNumErros(byte num) {
        this.numErros = (numErros >= 0) ? numErros : 0;
    }

    public void setPuntos(int puntos) {
        this.puntos = (puntos >= 0) ? puntos : 0;
    }

    @Override
    public String toString() {
        return nome + " con " + puntos;
    }
}
