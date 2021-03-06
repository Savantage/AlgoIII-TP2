package algochess;

import static org.junit.Assert.assertNotNull;

import algochess.engine.tablero.Tablero;
import algochess.engine.entidades.armas.Espada;
import algochess.engine.facciones.Faccion;
import algochess.engine.jugador.Jugador;
import algochess.engine.entidades.Jinete;
import algochess.engine.tablero.Casillero;
import algochess.engine.posicion.Posicion;
import static algochess.engine.ConstantesUtils.ESPADA_PODER;
import static algochess.engine.ConstantesUtils.JINETE_VIDA;
import algochess.excepciones.JugadorPerdioException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import algochess.excepciones.EntidadFueraDeAlcanceException;

public class EspadaTest {

	@Test
	public void test00ConstructorEspadaNoDevuelveNull() {
		Espada espada = new Espada();
		assertNotNull(espada);
	}

    @Test 
    public void test01AtacamosConEspadaConRangoCercanoYDañamosAUnaUnidad() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(10, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        for(int i = 0; i < (JINETE_VIDA / ESPADA_PODER) - 1; i++) {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        }

        Assertions.assertThrows(JugadorPerdioException.class, () -> {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });
    }

    @Test 
    public void test02AtacamosConEspadaConRangoMedianoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(13, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        Assertions.assertThrows(EntidadFueraDeAlcanceException.class, () -> {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });  

    }

    @Test 
    public void test03AtacamosConEspadaConRangoLejanoYNoSeProduceElAtaque() {
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(Faccion.ENEMIGOS);

        Jinete jinete = new Jinete(jugador, Faccion.ENEMIGOS);

        Posicion posOrigen = new Posicion(9, 1);
        Posicion posDestino = new Posicion(15, 1);

        tablero.colocarEntidad(jinete, posDestino, new Jugador(Faccion.ALIADOS, "Lucas"));
        Casillero casilleroDestino = tablero.obtenerCasillero(posDestino);


        Espada espada = new Espada();

        Assertions.assertThrows(EntidadFueraDeAlcanceException.class, () -> {
            espada.atacar(posOrigen, casilleroDestino, Faccion.ALIADOS, tablero);
        });  

    }

}