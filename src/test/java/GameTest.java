import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void round_playerNotFoundexceptionThrown() {
        Game game = new Game();
        game.register(new Player(1, "Player 1", 10));
        assertThrows(NotRegisteredException.class, () -> game.round("Player 1", "Player 2"));
        assertThrows(NotRegisteredException.class, () -> game.round("Player 2", "Player 1"));
    }

    @Test
    void round_player1Wins_return1() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 5);
        game.register(player1);
        game.register(player2);
        assertEquals(1, game.round("Player 1", "Player 2"));
    }

    @Test
    void round_player2Wins_return2() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 5);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);
        assertEquals(2, game.round("Player 1", "Player 2"));
    }

    @Test
    void round_draw_return0() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);
        assertEquals(0, game.round("Player 1", "Player 2"));
    }

}



