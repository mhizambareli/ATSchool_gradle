package lessons.lesson10_3.part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {

    @Test
    void findPositionOfSymbolTest() {
        String outputText1 = "Через аргументы передаётся \"Ц\",\nВывод: 0";
        String outputText2 = "Через аргументы передаётся \"а\",\nВывод: 7";
        String outputText3 = "Через аргументы передаётся \".\",\nВывод: 57";
        assertAll(
                () -> Assertions.assertEquals(outputText1, Task2_54_1.findPositionOfSymbol("Ц")),
                () -> Assertions.assertEquals(outputText2, Task2_54_1.findPositionOfSymbol("а")),
                () -> Assertions.assertEquals(outputText3, Task2_54_1.findPositionOfSymbol("."))
        );
    }
}