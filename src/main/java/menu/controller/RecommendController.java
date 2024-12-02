package menu.controller;

import java.util.ArrayList;
import java.util.List;

import menu.domain.CantEatingMenus;
import menu.domain.Category;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.util.GenerateCategory;
import menu.util.GenerateMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
    private Coaches coaches;
    private CantEatingMenus cantEatingMenus;

    public void start() {
        OutputView.start();
        execute();
        OutputView.finish();
    }

    private void execute() {
        List<String> inputCoachNames = getCoachNames();
        getCantEatingMenus(inputCoachNames);
        getResult(inputCoachNames);
    }

    private List<String> getCoachNames() {
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
        return inputCoachNames;
    }

    private void getCantEatingMenus(List<String> inputCoachNames) {
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
    }

    private static List<Category> getCategories() {
        List<Category> categories = GenerateCategory.generate();
        OutputView.printDayAndCategory(categories);
        return categories;
    }

    private void getResult(List<String> inputCoachNames) {
        List<Category> categories = getCategories();
        for (int index = 0; index < inputCoachNames.size(); index++) {
            List<Menu> menus = GenerateMenus.generate(categories, cantEatingMenus);
            OutputView.printResult(coaches.getCoachName(index), menus);
        }
    }
}
