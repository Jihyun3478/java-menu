package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CoachesTest {
    @Test
    void 함께_식사하는_코치가_2명_이상_5명_이하가_아닐경우_예외가_발생한다() {
        List<String> coachNames = List.of("제임스");

        assertThatThrownBy(() -> new Coaches(coachNames))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
