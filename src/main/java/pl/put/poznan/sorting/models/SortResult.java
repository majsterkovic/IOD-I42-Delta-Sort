package pl.put.poznan.sorting.models;

import com.google.gson.Gson;

/**
 * Sorting result - json implementation.
 *
 */
public class SortResult {

    /**
     * Assigning arguments to class fields.
     *
     * @param   algorithm
     * @param   time
     * @param   data
     */
    public SortResult(String algorithm, String time, Object[] data) {
        this.algorithm = algorithm;
        this.time = time;
        this.data = data;
    }
    
    /**
     * Reading from json. 
     *
     * @param json
     * @return
     */
    public static SortResult fromJson(String json) {
        return new Gson().fromJson(json, SortResult.class);
    }

    /**
     * Transforming results to json format.
     *
     * @return  new json object
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

    public final String algorithm;
    public final String time;
    public final Object[] data;

}
