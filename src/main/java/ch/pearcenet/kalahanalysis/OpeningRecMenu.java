package ch.pearcenet.kalahanalysis;

import ch.pearcenet.easymenus.pages.MenuPage;
import ch.pearcenet.easymenus.pages.TextPage;
import ch.pearcenet.easymenus.util.AnsiUtils;

public class OpeningRecMenu extends MenuPage {

    private Board board;

    private static int RecLevel = 0;

    public OpeningRecMenu(Board board) {
        super(
                "Opening Analysis for " + board.getSTARTING_SEEDS() + " Starting Seeds:\n(* = Ended in Score Pit)",
                "Score + " + board.get(6) + " *"
        );
        this.board = board;
        AnsiUtils.clearScreen();
        System.out.println("Current Recursion Level: " + RecLevel++);

        // Perform Analysis
        for (int i=0; i<6; i++) {
            Board b = board.clone();
            boolean newPerm = b.moveFrom(true, i);
            if (newPerm) {

                super.addOption(new OpeningRecMenu(b));

            } else {
                // Render ASCII-art of board layout
                String render = "+--+--+--+--+--+--+--+--+\n|";
                for (int x=7; x<13; x++) {
                    if (b.get(x) < 9) { render += " "; }
                    render += b.get(x) + "|";
                }
                render += "\n|0 +--+--+--+--+--+--+";
                if (b.get(6) < 9) { render += " "; }
                render += b.get(6) + "|\n|";
                for (int x=0; x<6; x++) {
                    if (b.get(x) < 9) { render += " "; }
                    render += b.get(x) + "|";
                }
                render += "\n+--+--+--+--+--+--+--+--+\n";

                super.addOption(new TextPage(
                        "Result of Moving from " + (i+1),
                        "Score +" + b.get(6),
                        render
                ));
            }

        }
    }

}
