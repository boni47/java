package employees;

public class StringUtils {
    public static String getMiddleChars(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Длина строки должна быть четным числом");
        }
        int middle = str.length() / 2;
        return str.substring(middle - 1, middle + 1);
    }
}