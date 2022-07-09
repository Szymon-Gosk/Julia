package gosk.szymon.fetching;

import gosk.szymon.core.exception.JsonFetchException;
import gosk.szymon.util.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Slf4j
@Component
public class JsonFetcher implements Fetcher {

    private static final String PROPERTIES_PATH = "properties/data-sources.properties";

    @Override
    public JSONObject fetchJsonObject(@NotNull DataSource dataSource) throws JsonFetchException {
        try {
            return new JSONObject(getSourceUrl(dataSource.getKey()));
        } catch(JSONException | IOException e) {
            throw new JsonFetchException(e.getMessage());
        }
    }

    private String getSourceUrl(String key) throws IOException {
        return IOUtils.toString(new URL(PropertiesLoader.from(PROPERTIES_PATH).getProperty(key)));
    }

}
