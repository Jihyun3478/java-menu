package menu.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    void 월요일에_추천할_카테고리를_무작위로_정한다() {
        List<String> categories = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
        Category category = Category.randomCategory();

        assertThat(categories).contains(category.getCategoryName());
    }
}
