package menu.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import menu.domain.CantEatingMenus;
import menu.domain.Category;
import menu.domain.Menu;

public class GenerateMenusTest {
    @Test
    void 각_코치에게_한주에_중복되지_않는_메뉴를_추천한다() {
        List<Category> categories = GenerateCategory.generate();
        List<String> cantEatingMenus = Arrays.asList("오니기리", "똠양꿍");
        List<Menu> recommendMenus = GenerateMenus.generate(categories, new CantEatingMenus(cantEatingMenus));

        boolean isDuplicate = recommendMenus.stream()
                .map(Menu::getMenuName)
                .distinct().isParallel();

        assertThat(isDuplicate).isFalse();
    }

    @Test
    void 각_코치가_못먹는_메뉴는_제외한다() {
        List<String> input = Arrays.asList("오니기리", "똠양꿍");
        CantEatingMenus cantEatingMenus = new CantEatingMenus(input);

        List<Category> categories = GenerateCategory.generate();
        List<Menu> recommendMenus = GenerateMenus.generate(categories, cantEatingMenus);

        boolean isIncludeNotEatingMenus = cantEatingMenus.getCantEatingMenus().stream()
            .anyMatch(recommendMenus::contains);

        assertThat(isIncludeNotEatingMenus).isFalse();
    }
}
