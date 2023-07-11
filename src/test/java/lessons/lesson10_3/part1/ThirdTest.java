package lessons.lesson10_3.part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTest {

    @ParameterizedTest(name = "Перевод {0} в int")
    @ValueSource(strings = {"0012", "-14", "-000157895", "2147483647"})
    void toIntTest(String str) {
        int expected = Integer.parseInt(str);
        int actual = Task2_54_6.toInt(str);
        assertEquals(expected, actual);
    }

    @Test
    void checkTest() {
        String cantParseInt = "Строка не может быть преобразована в целое число типа int";
        assertAll(
                () -> Assertions.assertEquals("-28", Task2_54_6.check("-14")),
                () -> Assertions.assertEquals("24", Task2_54_6.check("0012")),
                () -> Assertions.assertEquals("-4294967296", Task2_54_6.check("-2147483648")),
                () -> Assertions.assertEquals("4294967294", Task2_54_6.check("2147483647")),
                () -> Assertions.assertEquals(cantParseInt, Task2_54_6.check("-2147483649")),
                () -> Assertions.assertEquals(cantParseInt, Task2_54_6.check("2147483648")),
                () -> Assertions.assertEquals(cantParseInt, Task2_54_6.check("-")),
                () -> Assertions.assertEquals(cantParseInt, Task2_54_6.check("abc"))
        );
    }

}