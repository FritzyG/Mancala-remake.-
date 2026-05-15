public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private boolean player1Turn;

    public Game() {
        board = new Board();
        player1 = new HumanPlayer("Player 1");
        player2 = new HumanPlayer("Player 2");
        player1Turn = true;
    }

    public Board getBoard() {
        return board; //
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public void switchTurn(boolean extraTurn) {
        if (!extraTurn) {
            player1Turn = !player1Turn; //
        }
    }
}
