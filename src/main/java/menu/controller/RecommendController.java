package menu.controller;

import java.util.ArrayList;
import java.util.List;

import menu.CantEatingMenus;
import menu.Category;
import menu.Coaches;
import menu.Menu;
import menu.util.GenerateCategory;
import menu.util.GenerateMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
    private Coaches coaches;
    private CantEatingMenus cantEatingMenus;

    public void start() {
        OutputView.start();

        List<String> inputCoachNames = new ArrayList<>();

        while (true) {
            try {
                OutputView.inputCoachNames();
                inputCoachNames = InputView.inputCoachNames();
                coaches = new Coaches(inputCoachNames);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }

        for (int index = 0; index < inputCoachNames.size(); index++) {
            while (true) {
                try {
                    OutputView.inputCantEatingMenus(coaches.getCoachName(index));
                    List<String> inputCantEatingMenus = InputView.inputCantEatingMenus();
                    cantEatingMenus = new CantEatingMenus(inputCantEatingMenus);
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(e);
                }
            }
        }

        List<Category> categories = GenerateCategory.generate();
        OutputView.printDayAndCategory(categories);

        for (int index = 0; index < inputCoachNames.size(); index++) {
            List<Menu> menus = GenerateMenus.generate(categories, cantEatingMenus);
            OutputView.printResult(coaches.getCoachName(index), menus);
        }

        OutputView.finish();
    }
}
