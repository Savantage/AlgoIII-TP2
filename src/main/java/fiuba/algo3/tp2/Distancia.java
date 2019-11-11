package fiuba.algo3.tp2;

public abstract class Distancia {

	public abstract int getDistanciaAsInt();
	public abstract void realizarAtaque(Tipo tipo, Entidad atacante, Entidad atacado);
	public abstract void realizarCuracion(Tipo tipo, Entidad atacante, Entidad atacado);
	public abstract void realizarAtaque(Tipo tipo, Entidad atacante, Casillero casilleroAtacado);
	public abstract void realizarCuracion(Tipo tipo, Entidad atacante, Casillero casilleroAtacado);
}