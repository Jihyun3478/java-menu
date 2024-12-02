package menu;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import menu.util.GenerateCategory;

public class GenerateCategoryTest {
     @Test
    void 한주에_같은_카테고리는_최대_2회_이상만_고를수_있다() {
         List<Category> categories = GenerateCategory.generate();
         boolean isDuplicateCountMoreThanTwo = categories.stream()
             .map(Category::getCategoryName)
             .distinct()
             .count() > 2;

         assertThat(isDuplicateCountMoreThanTwo).isFalse();
    }
}
