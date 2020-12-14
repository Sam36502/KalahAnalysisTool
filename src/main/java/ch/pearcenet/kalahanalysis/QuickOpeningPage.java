package ch.pearcenet.kalahanalysis;

import ch.pearcenet.easymenus.input.StringInput;
import ch.pearcenet.easymenus.pages.InputPage;
import ch.pearcenet.easymenus.pages.TextPage;
import ch.pearcenet.easymenus.util.AnsiUtils;

public class QuickOpeningPage extends InputPage {

    private StringInput seedCountInput;

    public QuickOpeningPage() {
        super("Quick Openings", "Quick Opening Analyser");
        seedCountInput = new StringInput(
                "Number of Starting Seeds in each Pit:",
                2,
                "[0-9]+",
                "Input must be a number.");
        super.getInputs().add(seedCountInput);
    }

    @Override
    public void callPage() {
        super.callPage();
        int seedCount = Integer.parseInt(seedCountInput.getAnswer());

        BestPath bp = new BestPath(new Board(seedCount));

        int bs = bp.bestScore();
        String ps = bp.getPathString();

        TextPage next = new TextPage(
                "Quick Opening Results:",
                "Best possible starting score: " + bs + "\n" +
                        "Pits to choose, in order:\n" + ps
        );
        next.callPage();
    }

}
