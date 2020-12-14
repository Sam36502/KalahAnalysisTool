package ch.pearcenet.kalahanalysis;

import java.util.ArrayList;
import java.util.Collections;

public class BestPath {

    private Board board;

    private int bestScore;

    private ArrayList<Integer> bestPath;

    public BestPath(Board board) {
        this.board = board;
        this.bestPath = new ArrayList<Integer>();
    }

    public int bestScore() {
        return bestScore(this.board, new ArrayList<>());
    }

    public int bestScore(Board mainBoard, ArrayList<Integer> path) {
        int hiScore = 0;
        for (int i=0; i<6; i++) {
            Board b = mainBoard.clone();
            ArrayList<Integer> p = (ArrayList<Integer>) path.clone();
            p.add(i + 1);
            if (b.get(i) < 1) { continue; }

            boolean newPerm = b.moveFrom(true, i);
            int score = 0;
            if (newPerm) {
                score = bestScore(b, p);
            } else {
                score = b.get(6);
            }

            if (score > hiScore) {
                hiScore = score;
            }
        }

        if (hiScore > bestScore) {
            bestScore = hiScore;
            bestPath = path;
        }

        return hiScore;
    }

    public String getPathString() {
        String render = "";
        for (int pit: bestPath) {
            render += pit + " -> ";
        }
        render = render.substring(0, render.length()-4);
        return render;
    }

}
