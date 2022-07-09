package gosk.szymon.util;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesLoaderTest {

    private static final String PROPER_FILE = "properties/test-properties.properties";
    private static final String WRONG_FILE = "properties/wrong.properties";

    @Test
    void loadsPropertiesFileCorrectly() {
        assertDoesNotThrow(() -> PropertiesLoader.from(PROPER_FILE));
        assertThrows(FileNotFoundException.class, () -> PropertiesLoader.from(WRONG_FILE));
    }

    @Test
    void loadPropertiesCorrectly() throws IOException {
        Properties properties = PropertiesLoader.from(PROPER_FILE);
        assertEquals("TestProperty", properties.getProperty("property1"));
        assertEquals("Some other property", properties.getProperty("other.property"));
    }

}