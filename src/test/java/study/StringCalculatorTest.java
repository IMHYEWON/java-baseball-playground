package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("전체 계산기 테스트")
    void 전체_계산기_테스트() {
        //2 + 3 * 4 / 2
        assertEquals(10, stringCalculator.calculate("2 + 3 * 4 / 2"));
    }

    @Test
    @DisplayName("더하기 테스트")
    void 더하기_테스트() {
        assertEquals(5, stringCalculator.add(2, 3));
    }

    @Test
    @DisplayName("빼기 테스트")
    void 빼기_테스트() {
        assertEquals(7, stringCalculator.subtract(13, 6));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void 곱하기_테스트() {
        assertEquals(18, stringCalculator.multiply(6, 3));
    }

    @Test
    @DisplayName("나누기 테스트")
    void 나누기_테스트() {
        assertEquals(5, stringCalculator.divide(10, 2));
    }

    @Test
    @DisplayName("나누기 에러 테스트")
    void 나누기_에러_테스트() {
        assertThatThrownBy(() -> stringCalculator.divide(10, 0)).isInstanceOf(
            ArithmeticException.class);
    }

    @Test
    @DisplayName("잘못된 연산자 에러 테스트")
    void 잘못된_연산자_에러_테스트() {
        assertThatThrownBy(() -> stringCalculator.calculate("2 # 45")).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("잘못된 연산자 입니다");
    }

}
