package fall2018.csc2017.slidingtiles.UltimateTTT;

//Adapted from: https://github.com/Prakash2403/UltimateTicTacToe/blob/master/app/src/main/java/com/example/prakash/ultimatetictactoe/backend/Backend.java

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for Ultimate Tic Tac Toe game state scanner.
 */
public class UltTTTGameStateScanner {

    /**
     * The initializer for ultimate tic tac toe game
     */
    private UltTTTBackendInit initializer;
    /**
     * The activity for ultimate tic tac toe game
     */
    private UltimateTTTGameActivity activity;

    /**
     * The game state scanner for ultimate tic tac toe game
     *
     * @param initializer the initializer for ultimate tic tac toe game
     * @param activity    the activity for ultimate tic tac toe game
     */
    public UltTTTGameStateScanner(UltTTTBackendInit initializer, UltimateTTTGameActivity activity) {
        this.initializer = initializer;
        this.activity = activity;
    }

    /**
     * Gets the global winner
     *
     * @return the global winner
     */
    String findGlobalWinner() {
        int numDrawn = findOccurrences("Drawn", initializer.result);
        int numWinP1 = findOccurrences("Player 1", initializer.result);
        int numWinP2 = findOccurrences("Player 2", initializer.result);
        int deciding_factor = (9 - numDrawn) / 2;

        if (numWinP1 > deciding_factor)
            return "Player 1";
        else if (numWinP2 > deciding_factor)
            return "Player 2";
        else if (initializer.result.size() == 9 && numWinP1 == numWinP2)
            return "Drawn";
        else
            return "None";
    }

    /**
     * Gets the number of occurrences of certain string
     *
     * @param str  the string to be find
     * @param list the list contains the string str
     * @return the number of occurrences of string str in list
     */
    private int findOccurrences(String str, ArrayList list) {
        String curr_item;
        int num_occurrences;
        Iterator itr;
        num_occurrences = 0;
        itr = list.iterator();
        while (itr.hasNext()) {
            curr_item = (String) itr.next();
            if (curr_item.equals(str))
                num_occurrences++;
        }
        return num_occurrences;
    }

    /**
     * Return the game activity.
     *
     * @return return the UltimateTTTGameActivity
     */
    public UltimateTTTGameActivity getActivity() {
        return activity;
    }
}
