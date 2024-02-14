package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    @DisplayName("자동차의 이름이 5글자를 초과하는 경우 예외가 발생한다.")
    void overNameLength() {
        final var overName = "아아아아아아";
        assertThatThrownBy(() -> Validator.validateNameLength(overName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름들 중 중복된 이름이 있는 경우 예외가 발생한다.")
    void duplicatedNamesTest() {
        final String[] duplicatedNames = {"abc", "def", "abc", "jei"};
        assertThatThrownBy(() -> Validator.validateDuplicateNames(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름 중 영어가 아닌 다른 문자가 있는 경우 예외가 발생한다.")
    void isAlphabetic() {
        final String wrongName = "rar1";
        assertThatThrownBy(() -> Validator.validateNameCharacters(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 영어로만 이루어져야 합니다.");
    }
}