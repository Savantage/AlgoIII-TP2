package fiuba.algo3.tp2;

public class DistanciaCercana extends Distancia {

	private int distancia;

	public DistanciaCercana(int distancia) {
		this.distancia = distancia;
	}

	public int getDistanciaAsInt() {
		return distancia;
	}

	public void realizarAtaque(Tipo tipo, Entidad atacante, Entidad atacado) {
		tipo.ataque(atacante, atacado, this);
	}

	public void realizarCuracion(Tipo tipo, Entidad atacante,  Entidad atacado) {
		tipo.curacion(atacante, atacado, this);
	}

	public void realizarAtaque(Tipo tipo, Entidad atacante, Casillero casilleroAtacado) {
		tipo.ataque(atacante, casilleroAtacado, this);
	}

	public void realizarCuracion(Tipo tipo, Entidad atacante, Casillero casilleroAtacado) {
		tipo.curacion(atacante, casilleroAtacado, this);
	}
}