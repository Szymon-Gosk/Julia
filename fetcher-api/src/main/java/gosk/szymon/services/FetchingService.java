package gosk.szymon.services;

import gosk.szymon.core.exception.JsonFetchException;

import java.util.List;

/**
 * Service used to fetch list of objects from any specified data source.
 * @param <T> Object model to be fetched
 * @param <E> Data source
 */
public interface FetchingService<T, E extends Enum<E>> {

    /**
     * Fetches list of objects from any specified data source.
     * @param dataSource any data source
     * @return List of objects fetched from the source
     * @throws JsonFetchException if fetched JSON could not have been parsed.
     */
    List<T> fetch(E dataSource) throws JsonFetchException;

}
