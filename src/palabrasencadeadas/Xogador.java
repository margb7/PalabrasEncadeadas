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
    private byte puntos;
    private byte turno;
    private byte numErros;

    public Xogador(String nome, byte turno) {
        this.nome = nome;
        this.turno = turno;
        this.puntos = 0;
    }

    public String getNome() {
        return nome;
    }

    public byte getPuntos() {
        return puntos;
    }

    public byte getTurno() {
        return turno;
    }

    public byte getNumErros() {
        return numErros;
    }

    public void setNumErros(byte num ) {
        
    }
    
}

