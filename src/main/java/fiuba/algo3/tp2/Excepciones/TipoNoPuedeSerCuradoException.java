package fiuba.algo3.tp2.Excepciones;

@SuppressWarnings("serial")
public class TipoNoPuedeSerCuradoException extends RuntimeException {
	   public String toString(){
		     return ("Este tipo de entidad no puede ser curada") ;
		  }
}
