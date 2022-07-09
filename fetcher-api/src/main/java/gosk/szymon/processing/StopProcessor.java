package gosk.szymon.processing;

import gosk.szymon.model.DataModel;
import gosk.szymon.model.Stop;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StopProcessor extends JSONProcessor {

    @Override
    public List<DataModel> process(JSONObject jsonObject) {
        List<DataModel> result = new ArrayList<>();
        jsonObject
                .getJSONObject(LocalDate.now().format(DateTimeFormatter.ofPattern("uuuu-MM-d")))
                .getJSONArray("stops")
                .iterator()
                .forEachRemaining(element -> result.add(processSingle((JSONObject) element)));
        return result;
    }

    @Override
    protected Stop processSingle(JSONObject stop) {
        return Stop.builder()
                .stopId(unwrapInt(stop, "stopId", -1))
                .stopCode(unwrapString(stop, "stopCode", EMPTY_STRING))
                .stopName(unwrapString(stop, "stopName", EMPTY_STRING))
                .stopShortname(unwrapString(stop, "stopShortName", EMPTY_STRING))
                .stopDesc(unwrapString(stop, "stopDesc", EMPTY_STRING))
                .subName(unwrapString(stop, "subName", EMPTY_STRING))
                .date(unwrapString(stop, "date", EMPTY_STRING))
                .zoneId(unwrapInt(stop, "zoneId", -1))
                .zoneName(unwrapString(stop, "zoneName", EMPTY_STRING))
                .virtual(unwrapInt(stop, "virtual", ZERO_INT))
                .nonpassenger(unwrapInt(stop, "nonpassenger", ZERO_INT))
                .depot(unwrapInt(stop, "depot", ZERO_INT))
                .ticketZoneBorder(unwrapInt(stop, "ticketZoneBorder", ZERO_INT))
                .onDemand(unwrapInt(stop, "onDemand", ZERO_INT))
                .activationDate(unwrapString(stop, "activationDate", EMPTY_STRING))
                .latitude(unwrapDouble(stop, "stopLat", ZERO_DOUBLE))
                .longitude(unwrapDouble(stop, "stopLon", ZERO_DOUBLE))
                .build();
    }

}
