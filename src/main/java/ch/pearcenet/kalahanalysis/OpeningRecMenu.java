package ch.pearcenet.kalahanalysis;

import ch.pearcenet.easymenus.pages.MenuPage;
import ch.pearcenet.easymenus.pages.TextPage;
import ch.pearcenet.easymenus.util.AnsiUtils;

public class OpeningRecMenu extends MenuPage {

    private Board board;

    private static int RecLevel = 0;

    public OpeningRecMenu(Board board) {
        super(
                "Analysis " + board.getSTARTING_SEEDS(),
                "Score: " + board.get(6) + " *"
        );
        this.board = board;

        // Perform Analysis
        for (int i=0; i<6; i++) {
            Board b = board.clone();
            if (b.get(i) == 0) {
                super.addOption(new TextPage(
                        " --- ",
                        "Couldn't move from " + (i+1) + ", because there were no stones there."
                ));
                continue;
            }
            boolean newPerm = b.moveFrom(true, i);
            if (newPerm) {

                super.addOption(new OpeningRecMenu(b));

            } else {
                // Render ASCII-art of board layout
                String render = "+--+--+--+--+--+--+--+--+\n|''|";
                for (int x=12; x>6; x--) {
                    if (b.get(x) < 10) { render += " "; }
                    render += b.get(x) + "|";
                }
                render += "''|\n|0 +--+--+--+--+--+--+";
                if (b.get(6) < 10) { render += " "; }
                render += b.get(6) + "|\n|''|";
                for (int x=0; x<6; x++) {
                    if (b.get(x) < 10) { render += " "; }
                    render += b.get(x) + "|";
                }
                render += "''|\n+--+--+--+--+--+--+--+--+\n";

                super.addOption(new TextPage(
                        "Result of Moving from " + (i+1),
                        "Score: " + b.get(6),
                        render
                ));
            }

        }
    }

}
