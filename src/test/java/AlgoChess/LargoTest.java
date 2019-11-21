package AlgoChess;

import AlgoChess.engine.entidades.Jinete;
import AlgoChess.engine.entidades.armas.rangos.Largo;
import AlgoChess.engine.entidades.armas.rangos.Rango;
import AlgoChess.engine.facciones.Faccion;
import AlgoChess.engine.jugador.Jugador;
import AlgoChess.engine.posicion.Posicion;
import AlgoChess.engine.tablero.Casillero;
import AlgoChess.engine.tablero.Ocupado;
import org.junit.Test;
import static org.junit.Assert.*;

public class LargoTest {

    @Test
    public void test00CreoUnRangoCercanoYNoEsNull(){

        Rango rangoLargo = new Largo();

        assertNotNull(rangoLargo);

    }

    @Test
    public void test01CasilleroQueNoEstaEnRangoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(1,1);
        Posicion origen = new Posicion(2,2);

        Rango rangoLargo = new Largo();
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertFalse(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }

    @Test
    public void test02CasilleroQueEstaEnRangoNoTiraError(){

        Jinete jinete = new Jinete(new Jugador(Faccion.ALIADOS, "Lucas"), Faccion.ALIADOS);
        Posicion posicion =  new Posicion(20,20);
        Posicion origen = new Posicion(2,2);

        Rango rangoLargo = new Largo();
        Casillero casillero = new Ocupado(jinete,posicion,Faccion.ALIADOS);
        assertTrue(rangoLargo.casilleroEstaEnRango(casillero, origen));

    }


}
