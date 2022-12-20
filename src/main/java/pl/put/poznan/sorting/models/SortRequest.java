package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
/**
 * Request sort - JSON implementation for simple arrays.
 *
 */
public class SortRequest {
    /**
     * Assigning arguments to class fields.
     *
     * @param   data        data to be sorted
     * @param   algorithms  array of the names of the algorithms to use to sort data
     * @param   iterations  number of iterations of the algorithm to perform (whole algorithm if the number is 0 or less)
     * @param   reverse     <code>true</code> if the result should be in descending order, <code>false</code> otherwise
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
     * Reading a request from JSON.
     *
     * @param   json    type: String
     * @return          sort request
     * @throws JsonSyntaxException
     */
    public static SortRequest fromJson(String json) throws JsonSyntaxException {
        return new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create().fromJson(json, SortRequest.class);
    }
    /**
     * Transorming to JSON.
     *
     * @return      object transformed to JSON format.
     */
    public String toJson() {
        return new Gson().toJson(this);
    }

}