package menu.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static List<String> inputCoachNames() {
        String[] input = getInput();
        return Arrays.asList(input);
    }

    public static List<String> inputCantEatingMenus() {
        String[] input = getInput();
        return Arrays.asList(input);
    }

    private static String[] getInput() {
        return Console.readLine().split(",");
    }
}
