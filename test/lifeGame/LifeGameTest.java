package lifeGame;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LifeGameTest {
	
	private LifeGame game;
	
	private int[][]tableroResultante;
	
	@Before
	public void setup() {
		game = new LifeGame();
	}

	@Test
	public void testUnaCelulaQueMuereSinVecinos() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	@Test
	public void testUnaCelulaQueMuereConUnVecino() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.setCelula(3,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	@Test
	public void testUnaCelulaQueViveConDosVecinos() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(1, tableroResultante[2][2]);
	}
	
	@Test
	public void testUnaCelulaQueViveConTresVecinos() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.setCelula(2,1);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(1, tableroResultante[2][2]);
	}
	
	@Test
	public void testUnaCelulaQueMuereConCuatroVecinos() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.setCelula(2,1);
		game.setCelula(2,3);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	
	
	@Test
	public void testEspacioVacioSinVecinos() {
		game.crearTablero(4,4);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	@Test
	public void testEspacioVacioConUnVecino() {
		game.crearTablero(4,4);
		game.setCelula(3,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	@Test
	public void testEspacioVacioConDosVecinos() {
		game.crearTablero(4,4);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}
	
	@Test
	public void testEspacioVacioConTresVecinos() {
		game.crearTablero(4,4);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.setCelula(2,1);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(1, tableroResultante[2][2]);
	}
	
	@Test
	public void testEspacioVacioConCuatroVecinos() {
		game.crearTablero(4,4);
		game.setCelula(3,2);
		game.setCelula(1,2);
		game.setCelula(2,1);
		game.setCelula(2,3);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}

}
