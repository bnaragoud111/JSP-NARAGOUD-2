package com.bng.config;
import java.io.InputStream;
import java.util.Properties;

public class DbUtil {

    private static Properties props = new Properties();

    static {
        try (InputStream is = DbUtil.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            props.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUsername() {
        return props.getProperty("db.username");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }

    public static String getDriver() {
        return props.getProperty("db.driver");
    }
}