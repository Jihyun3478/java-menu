package menu.util;

import java.util.ArrayList;
import java.util.List;

import menu.CantEatingMenus;
import menu.Category;
import menu.Menu;

public class GenerateMenus {
    public static List<Menu> generate(List<Category> categories, CantEatingMenus cantEatingMenus) {
        List<Menu> recommendMenus = new ArrayList<>();
        do {
            for (Category category : categories) {
                getRecommendMenus(cantEatingMenus, category, recommendMenus);
            }
        } while (recommendMenus.size() > 5);
        return recommendMenus;
    }

    private static void getRecommendMenus(CantEatingMenus cantEatingMenus, Category category, List<Menu> recommendMenus) {
        if(!isIncludeNotEatingMenus(recommendMenus, cantEatingMenus)) {
            List<String> menusByCategory = Category.getMenusByCategory(category);
            String menu = Category.getMenu(menusByCategory);
            recommendMenus.add(new Menu(menu));
        }
    }

    private static boolean isIncludeNotEatingMenus(List<Menu> recommendMenus, CantEatingMenus cantEatingMenus) {
        return cantEatingMenus.getCantEatingMenus().stream()
            .anyMatch(recommendMenus::contains);
    }
}
