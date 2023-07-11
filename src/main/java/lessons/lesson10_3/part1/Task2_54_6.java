package lessons.lesson10_3.part1;

import java.math.BigInteger;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * Реализуйте метод static int toInt(String str), который принимает в качестве аргумента строковое представление целого числа и возвращает его целочисленное значение.
 * Т.е. результатом вызова toInt("-14") будет целое число -14. Или toInt("0012") вернет 12.
 * Использовать Integer.parseInt, Integer.valueOf и подобные "готовые" методы нельзя.
 * <p>
 * Напишите программу, которая получает строку через аргумент командной строки, проверяет можно ли преобразовать строку в целое число.
 * Если переданная строка не может быть преобразована в целое число или получаемое число не cможет поместиться в диапазон int, то выводится сообщение об ошибке и программа завершается.
 * Если может, то преобразуйте строку в целое число, используя метод toInt, и выведите результат умножения этого числа на 2.
 * Проверку на наличие аргумента командной строки делать не надо.
 */
public class Task2_54_6 {
    public static int toInt(String str) {
        int result = 0;
        int sign = 1; //По умолчанию считаем, что число неотрицательное. Если нужно отрицательное, то sign = -1
        int i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }

        while (i < str.length()) {
            char ch = str.charAt(i);
            int digit = ch - '0';
            result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }

    public static String check(String str){
        boolean parsableToInt = true; //переменная, которая даёт ответ на вопрос: можем ли мы перевести строку в int?

        for (int i = 0; i < str.length(); i++) {
            if (str.length() == 1 && str.charAt(0) == '-') { //обработка строки "-", где минус это первый и единственный символ
                parsableToInt = false;
                break;
            }
            if (str.length() > 1 && i == 0 && str.charAt(0) == '-') //первый символ может быть минусом, если он не является единственным символом в строке
                i++;

            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                parsableToInt = false;
                break;
            }
        }
       /*
       Если после предыдущих проверок переменная parsableToInt до сих пор осталась true, т.е. других ограничений на перевод строки в int не осталось,
       проверяем, что число помещается в диапозон int
       */
        if (parsableToInt) {
            BigInteger num = new BigInteger(str);
            BigInteger minInt = BigInteger.valueOf(MIN_VALUE);
            BigInteger maxInt = BigInteger.valueOf(MAX_VALUE);
            if (num.compareTo(minInt) == -1 || num.compareTo(maxInt) == 1)
                parsableToInt = false;
        }
        return parsableToInt ? String.valueOf(toInt(str) * 2L): "Строка не может быть преобразована в целое число типа int";

    }

    public static void main(String[] args) {
        System.out.println("Переданная строка: " + args[0]);
        System.out.println(check(args[0]));
    }
}

