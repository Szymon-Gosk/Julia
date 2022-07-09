package gosk.szymon.processing.implementation;

import gosk.szymon.core.exception.JsonFetchException;
import gosk.szymon.fetching.DataSource;
import gosk.szymon.fetching.JsonFetcher;
import gosk.szymon.model.Stop;
import gosk.szymon.processing.Processor;
import gosk.szymon.processing.StopProcessor;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopProcessorTest {

    @Test
    void canProcessStops() throws JsonFetchException {
        JsonFetcher fetcher = new JsonFetcher();
        Processor processor = new StopProcessor();

        JSONObject jsonObject = fetcher.fetchJsonObject(DataSource.STOP);

        List<Stop> stops = processor.process(jsonObject)
                .stream()
                .map(model -> (Stop) model)
                .toList();

        assertFalse(stops.isEmpty());
    }

}