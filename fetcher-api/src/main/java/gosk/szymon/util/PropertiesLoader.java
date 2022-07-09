package gosk.szymon.util;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesLoader {

    /**
     * Loads {@link Properties Properties} object from a given filepath.
     * @param filepath path to the file.
     * @return {@link Properties Properties} object.
     * @throws IOException when file loading error occurred.
     */
    public Properties from(String filepath) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = new ClassPathResource(filepath).getInputStream()) {
            properties.load(inputStream);
        }
        return properties;
    }

}
