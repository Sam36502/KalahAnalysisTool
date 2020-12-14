package ch.pearcenet.kalahanalysis;

import java.util.Arrays;

public class Board {

    /*
             OPPONENT
    +--+--+--+--+--+--+--+--+
    |  |12|11|10| 9| 8| 7|  |
    |13+--+--+--+--+--+--+ 6|
    |  | 0| 1| 2| 3| 4| 5|  |
    +--+--+--+--+--+--+--+--+
              PLAYER
     */

    private int STARTING_SEEDS;

    private int[] board = new int[14];

    public Board(int STARTING_SEEDS) {
        this.STARTING_SEEDS = STARTING_SEEDS;
        this.setStartPos();
    }

    /**
     * Sets board to start position
     */
    public void setStartPos() {
        for (int i=0; i<board.length; i++) {
            board[i] = STARTING_SEEDS;
        }
        board[6] = 0;
        board[13] = 0;
    }

    public Board clone() {
        Board b = new Board(STARTING_SEEDS);
        b.board = this.board.clone();
        return b;
    }

    /**
     * Moves the seeds in standard Kalah moves
     * until the round ends in the score pit or
     * in an empty pit.
     * @param isPlayer Whether this user is the player or opponent
     * @param startIndex Which of the six pits to start in (0-indexed; 0-5)
     * @return Whether the move ended in the score pit (true = in score pit)
     */
    public boolean moveFrom(final boolean isPlayer, final int startIndex) {
        int i = startIndex;
        if (!isPlayer) {
            i += 7;
        }

        if (board[i] < 1) {
            System.out.println("ERROR: Tried to move from pit with no seeds.");
            return false;
        }

        int inHand = board[i];
        board[i] = 0;
        boolean roundOver = false;
        boolean isInScorePit = false;
        while (!roundOver) {
            while (inHand > 0) {
                i++;
                if (i == 14) { i = 0; }
                if (isPlayer && i == 13) { i = 0; }
                if (!isPlayer && i == 6) { i = 7; }

                inHand--;
                board[i]++;
            }
            if (i == 13 || i == 6) {
                isInScorePit = true;
                roundOver = true;
            } else if (board[i] == 1) {
                isInScorePit = false;
                roundOver = true;
            } else {
                inHand = board[i];
                board[i] = 0;
            }
        }

        return isInScorePit;
    }

    public int get(int i) {
        return board[i];
    }

    public int getSTARTING_SEEDS() {
        return STARTING_SEEDS;
    }

}
