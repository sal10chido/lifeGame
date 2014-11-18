package lifeGame;

public class LifeGame {

	private int[][] tablero;

	private int[][] tableroResultante;
	

	public void crearTablero(final int longX, final int longY) {
		tablero = new int[longX][longY];
		tableroResultante = new int[longX][longY];
	}

	public void setCelula(final int posX, final int posY) {
		tablero[posX][posY] = 1;
	}

	public void analizarTablero() {
		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++)
				determinarViveoMuere(x, y, obtenerCelulasVecinas(x, y));
		}
	}

	private int obtenerCelulasVecinas(final int posX, final int posY) {
		int celulasVecinas = getCelulasIzquierda(posX, posY);
		celulasVecinas += getCelulasDerecha(posX, posY);
		celulasVecinas += getCelulasArribaAbajo(posX, posY);
		return celulasVecinas;
	}
	
	private int getCelulasIzquierda(final int posX, final int posY) {
		int celulasVecinas = getCelula(posX - 1, posY);// Izquierda
		celulasVecinas += getCelula(posX - 1, posY - 1);// IzquierdaSuperior
		celulasVecinas += getCelula(posX - 1, posY + 1);// IzquierdaInferior
		return celulasVecinas;
	}

	private int getCelulasDerecha(final int posX, final int posY) {
		int celulasVecinas = getCelula(posX + 1, posY - 1);// DerechaSuperior
		celulasVecinas += getCelula(posX + 1, posY);// Derecha
		celulasVecinas += getCelula(posX + 1, posY + 1);// DerechaInferior
		return celulasVecinas;
	}

	private int getCelulasArribaAbajo(final int posX, final int posY) {
		int celulasVecinas = getCelula(posX, posY - 1);// Superior
		celulasVecinas += getCelula(posX, posY + 1);// Inferior
		return celulasVecinas;
	}
	
	private int getCelula(final int posX, final int posY) {
		if (positionOutOfRange(posX, posY))
			return 0;
		return tablero[posX][posY];
	}

	private boolean positionOutOfRange(final int posX, final int posY) {
		return posX < 0 || posY < 0 || posX >= tablero.length
				|| posY >= tablero[posX].length;
	}
	
	private void determinarViveoMuere(int posX, int posY, int celulasVecinas) {
		if (isCelulaViva(posX, posY))
			obtenerResultadoConVecinosDeCelulaViva(posX, posY, celulasVecinas);
		else
			obtenerResultadoConVecinosDeCelulaMuerta(posX, posY, celulasVecinas);
	}
	
	private void obtenerResultadoConVecinosDeCelulaViva(int posX, int posY,
			int celulasVecinas) {
		if (celulasVecinas == 2 || celulasVecinas == 3)
			tableroResultante[posX][posY] = 1;
		else
			tableroResultante[posX][posY] = 0;
	}
	
	private void obtenerResultadoConVecinosDeCelulaMuerta(int posX, int posY,
			int celulasVecinas) {
		if (celulasVecinas == 3) {
			tableroResultante[posX][posY] = 1;
		}
	}
	
	private boolean isCelulaViva(int posX, int posY) {
		return tablero[posX][posY] == 1;
	}

	public int[][] getResultado() {
		return tableroResultante;
	}

}
