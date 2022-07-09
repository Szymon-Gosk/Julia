package gosk.szymon.services;

import gosk.szymon.core.exception.JsonFetchException;
import gosk.szymon.fetching.DataSource;
import gosk.szymon.fetching.Fetcher;
import gosk.szymon.model.DataModel;
import gosk.szymon.processing.Processor;
import gosk.szymon.processing.ProcessorFactory;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service used to fetch list of {@link DataModel DataModel} objects from any specified {@link DataSource DataSource}.
 */
@Service
public class LegacyFetchingService implements FetchingService<DataModel, DataSource> {

    private final Fetcher fetcher;
    private final ProcessorFactory processorFactory;

    @Autowired
    public LegacyFetchingService(Fetcher fetcher, ProcessorFactory processorFactory) {
        this.fetcher = fetcher;
        this.processorFactory = processorFactory;
    }

    /**
     * Fetches list of objects from any specified {@link DataSource DataSource}.
     * @param dataSource any {@link DataSource DataSource}
     * @return List of {@link DataModel DataModel} objects fetched from the source.
     * @throws JsonFetchException if fetched JSON could not have been parsed.
     */
    @Override
    public List<DataModel> fetch(@NotNull DataSource dataSource) throws JsonFetchException {
        JSONObject jsonObject = fetcher.fetchJsonObject(dataSource);
        Processor processor = processorFactory.getProcessor(dataSource);

        return processor.process(jsonObject);
    }

}