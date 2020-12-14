package ch.pearcenet.kalahanalysis;

import ch.pearcenet.easymenus.InputUtils;
import ch.pearcenet.easymenus.pages.MenuPage;
import ch.pearcenet.easymenus.pages.TextPage;
import ch.pearcenet.easymenus.util.AnsiUtils;

public class Main {

    public static void main(String[] args) {
        InputUtils.openScanner();
        AnsiUtils.installConsole();

        MenuPage mainMenu = new MenuPage(
                "KAT V1.0",
                new OpeningAnalPage(),
                new QuickOpeningPage(),
                new TextPage(
                        "KAT Tool Info",
                        "About",
                        "This is the Kalah Analysis Tool, version 1.0.\n" +
                                "\n" +
                                "Version: 1.0.0 - SNAPSHOT\n" +
                                "Made by: Samuel Pearce\n" +
                                "'''Date: 14/12/2020\n"
                ),
                new TextPage(
                        "Kalah Rules:",
                        "Kalah Rules",
                        "SETUP:\n" +
                                "The two score pits are emptied and a set number of stones placed " +
                                "in each of the 12 central pits (typically 4)." +
                                "\n\n" +
                                "PLAY:\n" +
                                "Each player takes turns choosing a pit on their side to pick up from and " +
                                "'sows' their stones, by moving counter-clockwise around the board and " +
                                "placing one of the stones from their hand in each of the pits they " +
                                "pass. The player places stones in their own score-pit as well, when " +
                                "they pass it, but if they pass the opponents score pit, they skip it. " +
                                "If the last pit they land in has no stones in it, their round " +
                                "is over. If it had some stones, they can pick those up and continue " +
                                "their round. If they land in their score pit, they may continue their " +
                                "turn starting from any of the pits on their side of the board." +
                                "\n\n" +
                                "WINNING:\n" +
                                "Once all the stones on one side of the board have been completely cleared, " +
                                "the game is over. Each player should now count how many stones they have in " +
                                "their score pit. Whoever has the most stones wins."
                )
        );
        mainMenu.callPage();

        AnsiUtils.uninstallConsole();
        InputUtils.closeScanner();
    }

}
