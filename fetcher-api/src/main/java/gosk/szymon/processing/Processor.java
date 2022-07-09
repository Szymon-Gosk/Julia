package gosk.szymon.processing;

import gosk.szymon.model.DataModel;
import org.json.JSONObject;

import java.util.List;

/**
 * Performs processing on fetched {@link JSONObject JSONObject} objects.
 */
public interface Processor {

    /**
     * Processes fetched {@link JSONObject JSONObject} to list of {@link DataModel DataModel} objects.
     * @param jsonObject any {@link JSONObject JSONObject}
     * @return list of {@link DataModel DataModel} objects
     */
    List<DataModel> process(JSONObject jsonObject);

}
