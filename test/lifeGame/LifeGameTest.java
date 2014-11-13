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
	public void testUnaCelulaQueMuere() {
		game.crearTablero(4,4);
		game.setCelula(2,2);
		game.analizarTablero();
		tableroResultante = game.getResultado();
		assertEquals(0, tableroResultante[2][2]);
	}

}
