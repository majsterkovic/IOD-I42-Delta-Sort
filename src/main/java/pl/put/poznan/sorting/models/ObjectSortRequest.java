package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ObjectSortRequest extends SortRequest {

    public ObjectSortRequest(Object[] data, String[] algorithms, String key, boolean reverse, int iterations) {
        super(data, algorithms, reverse, iterations);
        this.key = key;
    }

    public final String key;

    public static ObjectSortRequest fromJson(String json) throws JsonSyntaxException {
        return new Gson().fromJson(json, ObjectSortRequest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}