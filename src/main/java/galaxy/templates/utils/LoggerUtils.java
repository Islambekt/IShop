package galaxy.templates.utils;

import galaxy.templates.utils.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerUtils {

    private LoggerUtils() {
    }

    private static final String TYPE_JSON = "json";
    private static final String TYPE_XML = "xml";

    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    @FunctionalInterface
    public interface Fn {
        void exec();
    }

    private static void run(Fn fn, String type) {
        MDC.MDCCloseable closeable = MDC.putCloseable("log_type", type);
        fn.exec();
        closeable.close();
    }

    public static void infoJson(Logger logger, String msg) {
        run(() -> logger.info(msg), TYPE_JSON);
    }

    public static void infoJsonObject(Logger logger, Object object) {
        run(() -> logger.error(JsonUtils.toJson(object)), TYPE_JSON);
    }

    public static void errorJson(Logger logger, String msg) {
        run(() -> logger.error(msg), TYPE_JSON);
    }

    public static void errorJsonObject(Logger logger, Object object) {
        run(() -> logger.error(JsonUtils.toJson(object)), TYPE_JSON);
    }

    public static void infoXml(Logger logger, String msg) {
        run(() -> logger.info(msg), TYPE_XML);
    }

    public static void errorXml(Logger logger, String msg) {
        run(() -> logger.error(msg), TYPE_XML);
    }
}
