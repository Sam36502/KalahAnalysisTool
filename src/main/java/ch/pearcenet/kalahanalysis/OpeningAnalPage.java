package ch.pearcenet.kalahanalysis;

import ch.pearcenet.easymenus.input.StringInput;
import ch.pearcenet.easymenus.pages.InputPage;

public class OpeningAnalPage extends InputPage {

    private StringInput seedCountInput;

    public OpeningAnalPage() {
        super("Opening Analyser");
        seedCountInput = new StringInput("Number of Seeds in each pit at the start:", 2, "[0-9]+", "(1 - 99)");
        super.getInputs().add(seedCountInput);
    }

    @Override
    public void callPage() {
        super.callPage();
        int seedCount = Integer.parseInt(seedCountInput.getAnswer());

        Board board = new Board(seedCount);
        OpeningRecMenu recMenu = new OpeningRecMenu(board);
        recMenu.callPage();
    }
}
