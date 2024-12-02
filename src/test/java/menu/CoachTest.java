package menu;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CoachTest {
    @Test
    void 코치의_이름이_2글자_이상_4글자_이상이_아닐경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Coach("훈"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
