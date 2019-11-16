package AlgoChess.engine.jugador;

import AlgoChess.engine.Dinero;
import AlgoChess.engine.entidades.Entidad;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.vendedorDeEntidades.VendedorDeEntidades;
import AlgoChess.excepciones.JugadorPerdioException;

import java.util.ArrayList;
import java.util.List;

import static AlgoChess.engine.Constantes.DINERO_JUGADOR;

public class Jugador {

    private List<Entidad> entidades = new ArrayList<>();
    private Dinero dinero;
    private String nombre;
    private Faccion faccion;

    public Jugador(Faccion faccion_, String nombre_) {
        faccion = faccion_;
        dinero = new Dinero(DINERO_JUGADOR);
        nombre = nombre_;
    }

    public Jugador(Faccion faccion_) {
        faccion = faccion_;
        dinero = new Dinero(DINERO_JUGADOR);
        nombre = ""; // TODO: Randomizer de nombre o table look-up
    }


    public Faccion getFaccion() {
        return faccion;
    }

    public boolean perdio() {
        return entidades.size() == 0;
    }

    private void agregarEntidad(Entidad entidad) {
        if (entidad != null) {
            // TODO: Ver de sacar el constructor que no tiene faccion
            // entidad.setFaccion(faccion);
            entidades.add(entidad);
        }
    }

    public void removerEntidad(Entidad entidad) {
        entidades.remove(entidad);
        if(perdio())
            throw new JugadorPerdioException();
    }

    public void comprarEntidad(VendedorDeEntidades vendedor, Entidad entidad) {
        Dinero gasto = dinero.restarDinero(entidad.getCosto());
        Entidad miEntidad = vendedor.venderEntidad(entidad, gasto);
        agregarEntidad(miEntidad);
    }

}
