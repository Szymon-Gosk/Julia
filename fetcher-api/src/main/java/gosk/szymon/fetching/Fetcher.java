package gosk.szymon.fetching;

import gosk.szymon.core.exception.JsonFetchException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/**
 * Performs fetching a {@link JSONObject JSONObject} from any given {@link DataSource DataSource}.
 */
public interface Fetcher {

    /**
     * initial {@link JSONObject JSONObject} from any given {@link DataSource DataSource}.
     * @param dataSource source of data
     * @return JSONObject
     * @throws JsonFetchException if JSONObject could not be fetched
     */
    JSONObject fetchJsonObject(@NotNull DataSource dataSource) throws JsonFetchException;

}
