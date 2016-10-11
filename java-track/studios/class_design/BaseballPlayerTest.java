package class_design;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseballPlayerTest {

	@Test
	public void gameTest() {
		BaseballPlayer player = new BaseballPlayer("Joe", 13, "Rawling");
		assertTrue("initial hits", player.hits == 0);
		player.game(3, 5);
		assertTrue("add hits", player.hits == 3);
		assertTrue("initial games", player.games == 1);
		player.game(3, 5);
		assertTrue("add game", player.games == 2);
		assertTrue("initial rbis", player.rbis == 10);
		player.game(3, 5);
		assertTrue("add hits", player.rbis == 15);

		
	}

}
