package gosk.szymon.processing;

import gosk.szymon.model.Agency;
import gosk.szymon.model.DataModel;
import gosk.szymon.model.TopologyVersion;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class AgencyProcessor extends JSONProcessor {

    @Override
    public List<DataModel> process(JSONObject jsonObject) {
        List<DataModel> result = new ArrayList<>();
        jsonObject
                .getJSONArray("agency")
                .iterator()
                .forEachRemaining(element -> result.add(processSingle((JSONObject) element)));
        return result;
    }

    @Override
    protected Agency processSingle(JSONObject jsonObject) {
        return Agency.builder()
                .agencyId(unwrapInt(jsonObject, "agencyId", -1))
                .agencyName(unwrapString(jsonObject, "agencyName", EMPTY_STRING))
                .agencyUrl(unwrapString(jsonObject, "agencyUrl", EMPTY_STRING))
                .agencyTimezone(unwrapString(jsonObject, "agencyTimezone", EMPTY_STRING))
                .agencyLang(unwrapString(jsonObject, "agencyLang", EMPTY_STRING))
                .agencyEmail(unwrapString(jsonObject, "agencyEmail", EMPTY_STRING))
                .topologyVersions(processTopologyVersions(jsonObject))
                .build();
    }

    private Set<TopologyVersion> processTopologyVersions(JSONObject jsonObject) {
        Set<TopologyVersion> result = new HashSet<>();
        jsonObject
                .getJSONArray("topologies")
                .iterator()
                .forEachRemaining(element -> result.add(processSingleTopologyVersion((JSONObject) element)));
        return result;
    }

    private TopologyVersion processSingleTopologyVersion(JSONObject jsonObject) {
        return TopologyVersion.builder()
                .versionNumber(unwrapInt(jsonObject, "versionNumber", -1))
                .startDate(unwrapString(jsonObject, "startDate", EMPTY_STRING))
                .endDate(unwrapString(jsonObject, "endDate", EMPTY_STRING))
                .build();
    }

}
