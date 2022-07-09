package gosk.szymon.core;

import gosk.szymon.core.exception.JsonFetchException;
import gosk.szymon.fetching.DataSource;
import gosk.szymon.model.DataModel;
import gosk.szymon.services.FetchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FetcherApiController {

    private final FetchingService<DataModel, DataSource> fetchingService;

    @Autowired
    public FetcherApiController(FetchingService<DataModel, DataSource> fetchingService) {
        this.fetchingService = fetchingService;
    }

    @GetMapping("/agencies")
    List<DataModel> getAgencies() {
        return fetchModels(DataSource.AGENCY);
    }

    @GetMapping("/stops")
    List<DataModel> getStops() {
        return fetchModels(DataSource.STOP);
    }

    private List<DataModel> fetchModels(DataSource dataSource) {
        try {
            return fetchingService.fetch(dataSource);
        } catch (JsonFetchException e) {
            log.error("Could not parse fetched JSON data.");
            return List.of();
        }
    }

}
