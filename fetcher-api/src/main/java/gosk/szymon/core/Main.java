package gosk.szymon.core;

import gosk.szymon.core.exception.JsonFetchException;
import gosk.szymon.fetching.DataSource;
import gosk.szymon.model.DataModel;
import gosk.szymon.model.Stop;
import gosk.szymon.services.LegacyFetchingService;

import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonFetchException {
        LegacyFetchingService lfs = new LegacyFetchingService(null, null);
        List<DataModel> stops = lfs.fetch(DataSource.STOP);
        System.out.println();
    }

}
