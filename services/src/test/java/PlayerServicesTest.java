import board.BoardLogic;
import entity.Board;
import entity.Bot;
import entity.Player;
import enums.Color;
import game.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.PlayerService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerServicesTest {

    private Board board;
    private PlayerService playerServices;
    private Map<String, Player> players;
    private BoardLogic boardLogic;
    private GameLogic gameLogic;

    @BeforeEach
    public void setUp() {
        board = new Board();
        playerServices = new PlayerService();
        boardLogic = new BoardLogic(board);
        players = new HashMap<>();
        gameLogic = new GameLogic(boardLogic);
        playerServices.addPlayer(players, "1", Color.BLACK);
        playerServices.addPlayer(players, "2", Color.WHITE);
    }

    @Test
    public void testAddBotAddsNewBotWhenNotPresent() {
        String id = "123";
        Color color = Color.BLACK;
        assertFalse(players.containsKey(id));

        playerServices.addPlayer(players, id, color);

        assertTrue(players.containsKey(id));
        assertTrue(players.get(id) instanceof Player);
    }

    @Test
    public void testAddBotDoesNotAtddBoWhenAlreadyPresent() {
        String id = "123";
        Color color = Color.BLACK;
        players.put(id, new Bot(id, color));
        playerServices.addPlayer(players, id, color);
        assertEquals(3, players.size());
    }

    @Test
    public void testMakeMoveWithValidString() {
        String currentPlayerId = "1";
        String userInput = "d6";
        boolean moveMade = playerServices.makeMove(userInput, currentPlayerId, boardLogic);
        assertTrue(moveMade);
    }
}