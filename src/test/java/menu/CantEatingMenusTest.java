package menu;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CantEatingMenusTest {
    @Test
    void 각_코치의_못먹는_메뉴가_0개_이상_2개_이하가_아니면_예외가_발생한다() {
        List<String> menus = List.of("규동", "우동", "미소시루");

        assertThatThrownBy(() -> new CantEatingMenus(menus))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_코치가_못먹는_메뉴가_없는_메뉴이면_예외가_발생한다() {
        List<String> menus = List.of("김치찜", "닭볶음탕");

        assertThatThrownBy(() -> new CantEatingMenus(menus))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
