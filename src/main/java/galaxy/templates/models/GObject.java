package galaxy.templates.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import galaxy.templates.utils.json.JsonUtils;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GObject implements Serializable {

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    /**
     * Конвертирует объект в мап
     *
     * @return Map
     */
    public Map toMap() {
        return JsonUtils.convert(this, Map.class);
    }

    /**
     * Конвертирует в типизированный Map
     *
     * @param type пример: {@code new TypeToken<HashMap<String, Long>>(){}.getType();}
     * @return {@code Map<type>}
     */
    public <T> T toMap(Type type) {
        return JsonUtils.fromJsonMap(JsonUtils.toJson(this), type);
    }


    /**
     * Конвертирует данный объект в другой с помощью json
     *
     * @param type тип в который нужно сконвертировать
     * @param <T>  класс в который нужно сконветировать
     * @return {@code <T>}
     */
    public <T> T convert(Class<T> type) {
        return JsonUtils.convert(this, type);
    }

}
