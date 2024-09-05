import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.platform.commons.util.ReflectionUtils.isArray;

@DisplayName("Тестирование")
public class MainTest {

    Main main = new Main();

    @BeforeEach
    void beforeEach() { System.out.println("Начало теста.");}

    @AfterEach
    void afterEach() {
        System.out.println("Конец теста.\n");
    }

    @DisplayName("Проверка рекурсии на true и false")
    @ParameterizedTest
    @MethodSource
    public void canTestParam(int sum, boolean expected) {
        System.out.println("ParameterizedTest рекурсии на true и false.");

        boolean result = Main.can(sum);

        Assertions.assertEquals(expected, result);
        System.out.println(expected + " = " + result + " - Ok!");
    }
    public static Stream<Arguments> canTestParam() {
        return Stream.of(Arguments.of(17, true),
                Arguments.of(2, false));
    }

    @DisplayName("Проверка массивов")
    @ParameterizedTest
    @MethodSource
    public void findToSumInArrayParam(int[] array, int sum, int[] expected) {
        System.out.println("ParameterizedTest проверки на массивах.");

        int[] result = main.findToSum(array, sum);

        Assertions.assertArrayEquals(expected, result);
    }
    public static Stream<Arguments> findToSumInArrayParam() {
        return Stream.of(Arguments.of(new int[] {5, 1, 3, 2, 7}, 10, new int[] {3, 7}),
                Arguments.of(new int[] {}, 0, new int[] {}),
                Arguments.of(new int[] {5, 1, 3, 2, 7}, 20, new int[] {}));
    }

    @DisplayName("Проверка на массивах с Hamcrest")
    @Test
    public void findToSumInArrayHamcrest() {
        System.out.println("Hamcrest");
        int[] array = {5, 1, 3, 2, 7};
        int sum = 10;

        int[] result = main.findToSum(array, sum);

        assertThat(Arrays.toString(result), isArray(new Integer[] {3, 7}));
    }

    @DisplayName("Проверка длины массивах с Hamcrest")
    @Test
    public void givenArray_whenCheck_thenSize() {
        System.out.println("Проверка длины массива с Hamcrest.");
        Integer[] array = new Integer[] {5, 1, 3, 2, 7};

        assertThat(array, arrayWithSize(5));
        }
}
