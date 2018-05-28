package edu.ncwu.osums.util;

public class StringUtil {
    public static boolean isEmpty(String data) {
        if (data == null || data.equals("")) {
            return true;
        }

        return false;
    }

    public static boolean isNumeric(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch(NumberFormatException numberFormatException) {
            return false;
        }
    }
}
