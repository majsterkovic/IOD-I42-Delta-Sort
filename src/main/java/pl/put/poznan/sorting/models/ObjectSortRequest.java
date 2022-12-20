package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
/**
 * Request sort - JSON implementation for objects.
 *
 */
public class ObjectSortRequest extends SortRequest {

    /**
     * Assigning arguments to class fields.
     *
     * @param   data        type: Object[]
     * @param   algorithms  type: String[]
     * @param   key         type: String
     * @param   reverse     type: boolean
     * @param   iterations  type: int
     */
    public ObjectSortRequest(Object[] data, String[] algorithms, String key, boolean reverse, int iterations) {
        super(data, algorithms, reverse, iterations);
        this.key = key;
    }

    public final String key;
    /**
     * Reading a request from JSON.
     *
     * @param   json    type: String
     * @return          sort request
     * @throws JsonSyntaxException
     */
    public static ObjectSortRequest fromJson(String json) throws JsonSyntaxException {
        return new Gson().fromJson(json, ObjectSortRequest.class);
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