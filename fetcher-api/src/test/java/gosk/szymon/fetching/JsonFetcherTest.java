package gosk.szymon.fetching;

import gosk.szymon.core.exception.JsonFetchException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class JsonFetcherTest {

    @Test
    void FetchesJSONObjectFromDataSource() {
        Fetcher jsonFetcher = new JsonFetcher();

        Arrays.stream(DataSource.values()).forEach(dataSource -> {
            try {
                JSONObject jsonObject = jsonFetcher.fetchJsonObject(dataSource);
                assertNotNull(jsonObject);
            } catch (JsonFetchException e) {
                fail();
            }
        });
    }



}