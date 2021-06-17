package galaxy.templates.utils;

public class ObjectUtils {

    private ObjectUtils() {
    }

    /* Checkers */
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNullOrEmpty(String object) {
        return isNull(object) || object.trim().isEmpty();
    }

    public static boolean isBlank(String object) {
        return isNullOrEmpty(object);
    }

    /* Parsers */
    public static Long parseLongOr(String strLong, Long def) {
        if (!isBlank(strLong)) {
            try {
                return Long.parseLong(strLong);
            } catch (Exception ex) {
                return def;
            }
        }
        return def;
    }

    public static Long parseLongOrNull(String strLong) {
        return parseLongOr(strLong, null);
    }


    public static Integer parseIntegerOr(String strLong, Integer def) {
        if (!isBlank(strLong)) {
            try {
                return Integer.parseInt(strLong);
            } catch (Exception ex) {
                return def;
            }
        }
        return def;
    }

    public static Integer parseIntegerOrNull(String strInt) {
        return parseIntegerOr(strInt, null);
    }


    public static Double parseDoubleOr(String strDouble, Double def) {
        if (!isBlank(strDouble)) {
            try {
                return Double.parseDouble(strDouble);
            } catch (Exception ex) {
                return def;
            }
        }
        return def;
    }

    public static Double parseDoubleOrNull(String strInt) {
        return parseDoubleOr(strInt, null);
    }


    public static Boolean parseBooleanOr(String strBoolean, Boolean defValue) {
        if (!isBlank(strBoolean)) {
            try {
                return Boolean.parseBoolean(strBoolean);
            } catch (Exception ex) {
                return defValue;
            }
        }
        return defValue;
    }

    public static Boolean parseBooleanOrNull(String strBoolean) {
        return parseBooleanOr(strBoolean, null);
    }


    /* String utils*/
    public static String toOneLine(String str) {
        if (isBlank(str))
            return str;

        StringBuilder sb = new StringBuilder(str);

        int i = sb.indexOf("\n");
        while (i > -1) {
            sb.replace(i, i + "\n".length(), " ");
            i = sb.indexOf("\n");
        }

        return sb.toString();
    }

    public static String trim(String value) {
        if (isNull(value)) return "";
        return value.trim();
    }

    public static String trimOrNull(String value) {
        if (isNull(value)) return null;
        return value.trim();
    }

    public static String toStringOrNull(Object obj) {
        if (isNull(obj)) return null;
        return obj.toString();
    }

    public static String toStringOrEmpty(Object obj) {
        if (isNull(obj)) return "";
        return obj.toString();
    }

    public static String getOrDefault(String value, String defaultValue) {
        if (ObjectUtils.isBlank(value)) return defaultValue;
        return value;
    }
}
