package utils;

public class FormataString {
    public static String manterApenasNumeros(String value) {
        return value.trim().replaceAll("[^0-9]", "");
    }
}
