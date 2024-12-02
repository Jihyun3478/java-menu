package menu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menu.domain.Category;

public class GenerateCategory {
    public static List<Category> generate() {
        List<Category> categories = new ArrayList<>();
        Map<String, Integer> categoryCount = new HashMap<>();

        while (categories.size() < 5) {
            Category randomCategory = Category.randomCategory();
            String categoryName = randomCategory.getCategoryName();

            int count = categoryCount.getOrDefault(categoryName, 0);
            if (count < 2) {
                categories.add(randomCategory);
                categoryCount.put(categoryName, count + 1);
            }
        }
        return categories;
    }
}
