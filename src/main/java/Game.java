import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();


    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }

        return 0;
    }

    private Player findPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }
}
