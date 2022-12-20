package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
/**
 * Request sort - json implementation for simple arrays.
 *
 */
public class SortRequest {
    /**
     * Assigning arguments to class fields.
     *
     * @param   data
     * @param   algorithms
     * @param   key
     * @param   reverse
     * @param   iterations
     */
    public SortRequest(Object[] data, String[] algorithms, boolean reverse, int iterations) {
        this.data = data;
        this.algorithms = algorithms;
        this.reverse = reverse;
        this.iterations = iterations;
    }
    
    public final Object[] data;
    public final String[] algorithms;
    public final boolean reverse;
    public final int iterations;
    /**
     * Reading a request from json.
     *
     * @param   json    type: String
     * @return          sort request
     * @throws JsonSyntaxException
     */
    public static SortRequest fromJson(String json) throws JsonSyntaxException {
        return new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create().fromJson(json, SortRequest.class);
    }
    /**
     * Transorming to json.
     *
     * @return      object transformed to json format.
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

}