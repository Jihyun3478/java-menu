package menu.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import menu.domain.Category;

public class GenerateCategoryTest {
    @Test
    void 랜덤_생성된_카테고리_중복이_최대_2회_이하여야_한다() {
        List<Category> categories = GenerateCategory.generate();

        Map<String, Long> categoryCount = categories.stream()
            .collect(Collectors.groupingBy(Category::getCategoryName, Collectors.counting()));

        boolean isDuplicate = categoryCount.values().stream()
            .anyMatch(count -> count > 2);

        assertThat(isDuplicate).isFalse();
        assertThat(categories.size()).isEqualTo(5);
    }
}
