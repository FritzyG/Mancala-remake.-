import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;

    public Board() {
        pits = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            if (i == 6 || i == 13) {
                pits.add(new Pit(0)); // stores
            } else {
                pits.add(new Pit(4)); // initial stones
            }
        }
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public boolean makeMove(int pitIndex, boolean isPlayer1) {
        if (pitIndex < 0 || pitIndex > 13) return false;

        int stones = pits.get(pitIndex).getStones();
        if (stones == 0) return false;

        pits.get(pitIndex).setStones(0);
        int index = pitIndex;

        while (stones > 0) {
            index = (index + 1) % 14;

            // Skip opponent's store
            if (isPlayer1 && index == 13) continue;
            if (!isPlayer1 && index == 6) continue;

            pits.get(index).addStone();
            stones--;
        }

        // Capture for Player 1
        if (isPlayer1 && index >= 0 && index <= 5 && pits.get(index).getStones() == 1) {
            int opposite = 12 - index;
            int captured = pits.get(opposite).getStones();

            if (captured > 0) {
                pits.get(opposite).setStones(0);
                pits.get(index).setStones(0);
                pits.get(6).setStones(pits.get(6).getStones() + captured + 1);
            }
        }

        // Capture for Player 2
        if (!isPlayer1 && index >= 7 && index <= 12 && pits.get(index).getStones() == 1) {
            int opposite = 12 - index;
            int captured = pits.get(opposite).getStones();

            if (captured > 0) {
                pits.get(opposite).setStones(0);
                pits.get(index).setStones(0);
                pits.get(13).setStones(pits.get(13).getStones() + captured + 1);
            }
        }

        // Extra turn check
        if (isPlayer1 && index == 6) return true;
        if (!isPlayer1 && index == 13) return true;

        return false;
    }

    public boolean isGameover() {
        boolean side1Empty = true;
        boolean side2Empty = true;

        for (int i = 0; i < 6; i++) {
            if (pits.get(i).getStones() != 0) side1Empty = false;
        }

        for (int i = 7; i < 13; i++) {
            if (pits.get(i).getStones() != 0) side2Empty = false;
        }

        return side1Empty || side2Empty;
    }

    public void collectRemaining() {
        for (int i = 0; i < 6; i++) {
            pits.get(6).setStones(pits.get(6).getStones() + pits.get(i).getStones());
            pits.get(i).setStones(0);
        }

        for (int i = 7; i < 13; i++) {
            pits.get(13).setStones(pits.get(13).getStones() + pits.get(i).getStones());
            pits.get(i).setStones(0);
        }
    }
}