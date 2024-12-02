package menu.view;

import static menu.view.OutputMessage.*;

import java.util.List;

import menu.domain.Category;
import menu.domain.Menu;

public class OutputView {
    public static void start() {
        System.out.println(START.getMessage());
    }

    public static void inputCoachNames() {
        System.out.println(INPUT_COACH_NAMES.getMessage());
    }

    public static void inputCantEatingMenus(String coachName) {
        System.out.printf(INPUT_CANT_EATING_MENU.getMessage(coachName));
    }

    public static void printDayAndCategory(List<Category> categories) {
        System.out.println(RESULT_MESSAGE_START.getMessage());
        System.out.println(DAY.getMessage());
        System.out.print(CATEGORY_RESULT.getMessage());
        for(Category category : categories) {
            System.out.printf(" | %s", category.getCategoryName());
        }
        System.out.print(" ]");
    }

    public static void printResult(String coachName, List<Menu> menus) {
        System.out.printf("\n[ %s", coachName);
        for(Menu menu : menus) {
            System.out.printf(" | %s", menu.getMenuName());
        }
        System.out.print(" ]");
    }

    public static void finish() {
        System.out.print(FINISH.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
