package menu.util;

import java.util.ArrayList;
import java.util.List;

import menu.Category;

public class GenerateCategory {
    public static List<Category> generate() {
        List<Category> categories = new ArrayList<>();
        do {
            if (!isDuplicateCountMoreThanTwo(categories)) {
                categories.add(Category.randomCategory());
            }
        } while (categories.size() > 5);
        return categories;
    }

    private static boolean isDuplicateCountMoreThanTwo(List<Category> categories) {
        return categories.stream()
            .map(Category::getCategoryName)
            .distinct()
            .count() > 2;
    }
}
