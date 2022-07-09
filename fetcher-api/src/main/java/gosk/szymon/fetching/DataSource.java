package gosk.szymon.fetching;

import lombok.Getter;

/**
 *  Represents data source from which {@link gosk.szymon.model.DataModel DataModel} is generated.
 *  The key represents properties key from which API URL is taken.
 */
public enum DataSource {

    AGENCY("agency"),
    STOP("stop");

    @Getter
    private final String key;

    DataSource(String key) {
        this.key = key;
    }

}
