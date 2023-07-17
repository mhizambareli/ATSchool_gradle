package lessons.lesson10_3.part1;

import org.junit.jupiter.api.Test;

import static lessons.lesson10_3.part1.Task2_54_2.getPathAndName;
import static org.junit.jupiter.api.Assertions.*;

class SecondTest {

    @Test
    void getPathAndNameTest() {
        String outputText1 = "Путь: /bin/\nИмя файла: java";
        String outputText2 = "Путь: C:\\Program Files\\Java\\bin\\" + "\nИмя файла: java";
        String outputText3 = "Введен некорректный путь до файла.";

        assertAll(
                () -> assertEquals(outputText1, getPathAndName("/bin/java")),
                () -> assertEquals(outputText2, getPathAndName("C:\\Program Files\\Java\\bin\\java")),
                () -> assertEquals(outputText3, getPathAndName("/"))
        );
    }
}