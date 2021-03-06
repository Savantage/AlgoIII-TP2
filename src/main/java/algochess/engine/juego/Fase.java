package algochess.engine.juego;

import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.engine.vendedordeentidades.VendedorDeEntidades;
import algochess.engine.entidades.Entidad;
import algochess.engine.facciones.Faccion;
import algochess.engine.posicion.Posicion;

public interface Fase {

	void seleccionarEntidad(Jugador jugador, Faccion faccion, Entidad entidad);
	void comprarEntidad(Jugador jugador, VendedorDeEntidades vendedor);
	void colocarEntidad(Tablero tablero, Jugador jugador, Posicion posicion);
	void devolverDinero(Jugador jugador);
	boolean verificarFinDeFase(Jugador jugadorAliado, Jugador jugadorEnemigo);
	Entidad obtenerEntidadSeleccionada();
	void liberarEntidadSeleccionada();
	void atacar(Tablero tablero, Posicion posOrigen, Posicion posDestino, Faccion faccion);
	void curar(Tablero tablero, Posicion posOrigen, Posicion posDestino, Faccion faccion);
	void mover(Tablero tablero, Posicion posOrigen, Posicion posDestino, Faccion faccion);
	void setMoved(boolean moved);

}