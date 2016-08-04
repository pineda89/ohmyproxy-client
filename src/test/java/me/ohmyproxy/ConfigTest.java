package me.ohmyproxy;

import me.ohmyproxy.config.Config;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dpineda-pc on 4/08/16.
 */
public class ConfigTest {

    private static final String VALID_FILEPATH = "application.properties";
    private static final String NOT_FILE_FOUND_FILEPATH = "abc.txt";

    @Test
    public void notFileFoundTest() {
        try {
            Config cfg = Config.loadConfiguration(NOT_FILE_FOUND_FILEPATH);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void correctFileConfigTest() {
        try {
            Config cfg = Config.loadConfiguration(VALID_FILEPATH);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
