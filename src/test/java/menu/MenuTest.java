package menu;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuTest {
    @Test
    void 각_코치가_월요일에_먹을_메뉴를_추천한다() {
        Category category = Category.randomCategory();

        List<String> menus = Category.getMenusByCategory(category);
        String randomMenu = Randoms.shuffle(menus).get(0);
        Menu menu = new Menu(randomMenu);

        assertThat(menus).contains(menu.getMenuName());
    }
}
