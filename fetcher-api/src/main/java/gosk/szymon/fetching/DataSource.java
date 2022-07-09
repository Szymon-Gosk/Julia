package gosk.szymon.fetching;

import lombok.Getter;

/**
 *  Represents data source from which {@link gosk.szymon.model.DataModel DataModel} is generated.
 *  The key represents properties key from which API URL is taken.
 */
public enum DataSource {

    AGENCY("agency"),
    DATES_RANGE("dates.range"),
    EXPEDITION_DATA("expedition.data"),
    ROUTE("route"),
    STOP("stop"),
    STOP_DISPLAY("stop.display"),
    STOP_ROUTE_RELATION("stop.route.relation"),
    TRIP("trip");

    @Getter
    private final String key;

    DataSource(String key) {
        this.key = key;
    }

}
