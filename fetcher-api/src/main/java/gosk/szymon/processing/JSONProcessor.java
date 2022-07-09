package gosk.szymon.processing;

import gosk.szymon.model.DataModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public abstract class JSONProcessor implements Processor {

    protected static final String EMPTY_STRING = "";
    protected static final int ZERO_INT = 0;
    protected static final double ZERO_DOUBLE = 0.0;

    /**
     * Processes {@link JSONObject JSONObject} containing data about one {@link DataModel DataModel} into
     * the {@link DataModel DataModel} object.
     * @param jsonObject any {@link JSONObject JSONObject}
     * @return {@link DataModel DataModel} object
     */
    protected abstract DataModel processSingle(JSONObject jsonObject);

    /**
     * Unwraps int value from {@link JSONObject JSONObject}. If the value could not be retrieved, the default value is used.
     * @param value any {@link JSONObject JSONObject}
     * @param key key by which to extract the value
     * @param defaultValue used if value could not be retrieved
     * @return int retrieved from {@link JSONObject JSONObject}
     */
    protected int unwrapInt(JSONObject value, String key, int defaultValue) {
        try {
            if (value.get(key) instanceof Integer unwrappedValue) {
                return unwrappedValue;
            } else {
                throw new JSONException("");
            }
        } catch (JSONException e) {
            return defaultValue;
        }
    }

    /**
     * Unwraps double value from {@link JSONObject JSONObject}. If the value could not be retrieved, the default value is used.
     * @param value any {@link JSONObject JSONObject}
     * @param key key by which to extract the value
     * @param defaultValue used if value could not be retrieved
     * @return double retrieved from {@link JSONObject JSONObject}
     */
    protected double unwrapDouble(JSONObject value, String key, double defaultValue) {
        try {
            if (value.get(key) instanceof BigDecimal unwrappedValue) {
                return (unwrappedValue).doubleValue();
            } else {
                throw new JSONException("");
            }
        } catch (JSONException e) {
            return defaultValue;
        }
    }

    /**
     * Unwraps String value from {@link JSONObject JSONObject}. If the value could not be retrieved, the default value is used.
     * @param value any {@link JSONObject JSONObject}
     * @param key key by which to extract the value
     * @param defaultValue used if value could not be retrieved
     * @return String retrieved from {@link JSONObject JSONObject}
     */
    protected String unwrapString(JSONObject value, String key, String defaultValue) {
        try {
            if(value.get(key) instanceof String unwrappedValue) {
                return unwrappedValue;
            } else {
                throw new JSONException("");
            }
        } catch (JSONException e) {
            return defaultValue;
        }
    }

}
