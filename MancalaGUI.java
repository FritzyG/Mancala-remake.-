import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MancalaGUI extends JFrame {

    private Game game;
    private JButton[] pitButtons;
    private JLabel p1Store;
    private JLabel p2Store;

    // Track last move for arrow display
    private int lastMoveStart = -1;

    public MancalaGUI() {
        game = new Game();
        pitButtons = new JButton[14];

        setTitle("Mancala Game");
        setSize(900, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(2, 6));

        ActionListener listener = e -> {
            int index = Integer.parseInt(e.getActionCommand());

            if (!isValidMove(index)) return;

            lastMoveStart = index;

            boolean extraTurn =
                    game.getBoard().makeMove(index, game.isPlayer1Turn());
            game.switchTurn(extraTurn);

            refreshBoard();

            if (game.getBoard().isGameover()) {
                game.getBoard().collectRemaining();
                refreshBoard();
                showWinner();
            }
        };

        // Player 2 pits (top row: right → left)
        for (int i = 12; i >= 7; i--) {
            pitButtons[i] = new JButton();
            pitButtons[i].setActionCommand(String.valueOf(i));
            pitButtons[i].addActionListener(listener);
            centerPanel.add(pitButtons[i]);
        }

        // Player 1 pits (bottom row: left → right)
        for (int i = 0; i < 6; i++) {
            pitButtons[i] = new JButton();
            pitButtons[i].setActionCommand(String.valueOf(i));
            pitButtons[i].addActionListener(listener);
            centerPanel.add(pitButtons[i]);
        }

        // Player 1 store
        p1Store = new JLabel("", SwingConstants.CENTER);
        p1Store.setFont(new Font("Arial", Font.BOLD, 24));
        p1Store.setBorder(BorderFactory.createTitledBorder("Player 1"));

        // Player 2 store
        p2Store = new JLabel("", SwingConstants.CENTER);
        p2Store.setFont(new Font("Arial", Font.BOLD, 24));
        p2Store.setBorder(BorderFactory.createTitledBorder("Player 2"));

        add(p2Store, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(p1Store, BorderLayout.EAST);

        refreshBoard();
        setVisible(true);
    }

    private boolean isValidMove(int index) {
        if (game.isPlayer1Turn()) {
            return index >= 0 && index <= 5;
        } else {
            return index >= 7 && index <= 12;
        }
    }

    private void refreshBoard() {
        for (int i = 0; i < 14; i++) {
            if (pitButtons[i] == null) continue;

            int stones = game.getBoard().getPits().get(i).getStones();

            if (i == lastMoveStart) {
                if (i <= 5) {
                    pitButtons[i].setText(stones + " →");
                } else if (i >= 7 && i <= 12) {
                    pitButtons[i].setText("← " + stones);
                }
            } else {
                pitButtons[i].setText(String.valueOf(stones));
            }
        }

        p1Store.setText(String.valueOf(
                game.getBoard().getPits().get(6).getStones()));

        p2Store.setText(String.valueOf(
                game.getBoard().getPits().get(13).getStones()));
    }

    private void showWinner() {
        int p1 = game.getBoard().getPits().get(6).getStones();
        int p2 = game.getBoard().getPits().get(13).getStones();

        String result;
        if (p1 > p2) result = "Player 1 wins!";
        else if (p2 > p1) result = "Player 2 wins!";
        else result = "It's a tie!";

        JOptionPane.showMessageDialog(this, result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MancalaGUI::new);
    }
}