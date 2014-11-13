package lifeGame;

public class LifeGame {
	
	private int[][]tablero;
	
	private int[][]tableroResultante;
	
	public void crearTablero(final int longX, final int longY) {
		tablero = new int[longX][longY];
		tableroResultante = new int[longX][longY];
	}

	public void setCelula(final int posX, final int posY) {
		tablero[posX][posY] = 1;
	}

	public void analizarTablero() {
		int celulasVecinas = 0;
		for(int x = 0; x < tablero.length; x++) {
			for(int y = 0; y < tablero[x].length; y++) {
				celulasVecinas += obtenerCelulasVecinas(x,y);
				determinarViveoMuere(x,y,celulasVecinas);
			}
		}
	}

	private int obtenerCelulasVecinas(int posX, int posY) {
		// TODO Reglas de posicion
		return 0;
	}
	
	private void determinarViveoMuere(int posX, int posY, int celulasVecinas) {
		if (tablero[posX][posY] == 1) {
			if (celulasVecinas == 2 || celulasVecinas == 3) {
				tableroResultante[posX][posY] = 1;
			} else {
				tableroResultante[posX][posY] = 0;
			}
		} else {
			if (celulasVecinas == 3) {
				tableroResultante[posX][posY] = 1;
			}
		}
	}

	public int[][] getResultado() {
		return tableroResultante;
	}

}
