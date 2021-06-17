package galaxy.templates.utils.json;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import galaxy.templates.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    private JsonUtils() {
    }

    private static final Gson GSON_NO_ID = new GsonBuilder()
            .setDateFormat(DateUtils.SYSTEM_DATE_TIME)
            .setExclusionStrategies(new ExclusionStrategy("stamp"))
            .create();


    private static final Gson GSON = new GsonBuilder()
            .setDateFormat(DateUtils.SYSTEM_DATE_TIME)
            .create();

    @Data
    @AllArgsConstructor
    public static class ExclusionStrategy implements com.google.gson.ExclusionStrategy {

        private String key;

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return (f.getName().equals(key));
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }

    public static final Type MAP_STRING_OBJECT_TYPE = new TypeToken<Map<String, Object>>() {
    }.getType();

    public static final Type LIST_OBJECT_TYPE = new TypeToken<List<Object>>() {
    }.getType();

    /**
     * Конфертация объекта в json
     *
     * @param object объект который надо сконфертировать в json
     * @return String json
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    /**
     * Конфертация объекта в json
     * исключает все поля с названием stamp
     *
     * @param object объект который надо сконфертировать в json
     * @return String json
     */
    public static String toJsonWithout(Object object) {
        return GSON_NO_ID.toJson(object);
    }

    /**
     * Получение объекта из json-а
     *
     * @param json String
     * @param type класс в который нужно сконвертировать
     * @param <T>  класс в который вернется
     * @return {@code  <T>}
     */
    public static <T> T fromJson(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

    /**
     * Конвертация json в типизированный Map
     *
     * @param json    String json
     * @param mapType тип мапа, пример: {@code new TypeToken<Map<String, Long>>(){}.getType();}
     * @param <T>     тип
     * @return {@code Map<Type>}
     */
    public static <T> T fromJsonMap(String json, Type mapType) {
        return GSON.fromJson(json, mapType);
    }


    /**
     * Конвертация json в {@code Map<String, Object>}
     *
     * @param json String
     * @return Map из json
     */
    public static Map<String, Object> fromJsonMap(String json) {
        return fromJsonMap(json, MAP_STRING_OBJECT_TYPE);
    }


    /**
     * Конвертация json в типизированный List
     *
     * @param json     String json
     * @param listType тип мапа, пример: {@code new TypeToken<List<String>>(){}.getType();}
     * @param <T>      тип
     * @return {@code Map<Type>}
     */
    public static <T> T fromJsonList(String json, Type listType) {
        return GSON.fromJson(json, listType);
    }

    /**
     * Конвертация json в {@code List<Object>}
     *
     * @param json String
     * @return Map из json
     */
    public static List<Object> fromJsonList(String json) {
        return fromJsonList(json, LIST_OBJECT_TYPE);
    }

    /**
     * Конвертирует один объект в другой с помощью json
     *
     * @param object объект конвертации
     * @param type   тип в который нужно сконвертировать
     * @param <T>    класс в который нужно сконветировать
     * @return {@code <T>}
     */
    public static <T> T convert(Object object, Class<T> type) {
        return GSON.fromJson(toJson(object), type);
    }


    /**
     * Конвертирует один объект в другой с помощью json
     * исключает все поля с названием stamp
     *
     * @param object объект конвертации
     * @param type   тип в который нужно сконвертировать
     * @param <T>    класс в который нужно сконветировать
     * @return {@code <T>}
     */
    public static <T> T convertWithoutId(Object object, Class<T> type) {
        return GSON_NO_ID.fromJson(toJson(object), type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json).getAsJsonObject();
            return true;
        } catch (IllegalStateException ex) {
            return false;
        }
    }

}
