package lessons.lesson10_3.part1;

/**
 * В классе объявлена статическая переменная строкого типа со значением (кавычки не включены):
 * «Циклом называется многократное выполнение одних и тех же действий.»
 * <p>
 * Используя только методы класса String (без циклов, условий), напишите программу, которая печатает количество букв (без пробелов и точки) в переменной до определенного символа (не включая его).
 * Значение символа передается через аргумент командной строки.
 * <p>
 * Пример:
 * Через аргументы передается "Ц", Вывод: 0.
 * Через аргументы передается "а", Вывод: 7.
 * Через аргументы передается ".", Вывод: 57.
 */

public class Task2_54_1 {
    public static String cycle = "Циклом называется многократное выполнение одних и тех же действий.";

    public static String findPositionOfSymbol(String symbol) {
        return "Через аргументы передаётся \"" + symbol + "\",\n" +
                "Вывод: " + cycle.replace(" ", "").indexOf(symbol);
    }

    public static void main(String[] args) {
        System.out.println(findPositionOfSymbol(args[0]));
    }
}