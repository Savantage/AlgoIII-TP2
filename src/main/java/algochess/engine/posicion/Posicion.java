package algochess.engine.posicion;

import java.util.HashSet;
import java.lang.*;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila_, int columna_) {
        fila = fila_;
        columna = columna_;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean esIgual(Posicion posicion) {
        return posicion.columna == columna && posicion.fila == fila;
    }

    public boolean chequearRango(Posicion destino) {
        return
            (Math.abs(this.fila - destino.fila) == 1 && Math.abs(this.columna - destino.columna) < 1) || 
            (Math.abs(this.fila - destino.fila) < 1 && Math.abs(this.columna - destino.columna) == 1);
    }

    public HashSet<Posicion> generarPosicionesEnAlcance(int min, int max){
        Posiciones posicionesGeneradas = new Posiciones();


        // TODO mejorar todos los 8 loops con menos loops.

        /*add NORTH squares*/
        for(int i = min; i<= max; i++){
            posicionesGeneradas.agregar(new Posicion(fila-i,columna));
        }

        /*add SOUTH squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila+i,columna));
        }

        /*add EAST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila,columna+i));
        }

        /* add WEST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila,columna-i));
        }

        /*add  NORTH+EAST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila-i,columna+i));
        }

        /*add  NORTH+WEST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila-i,columna-i));
        }

        /*add  SOUTH+EAST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila+i,columna+i));
        }

        /*add  SOUTH+WEST squares*/
        for(int i = min; i<= max;i++){
            posicionesGeneradas.agregar(new Posicion(fila+i,columna-i));
        }


        return posicionesGeneradas.posiciones();
    }
}
