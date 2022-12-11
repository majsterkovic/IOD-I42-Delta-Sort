package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ObjectSortRequest {

    public ObjectSortRequest(Object[] data, String[] algorithms, String key, boolean reverse, int iterations) {
        this.data = data;
        this.algorithms = algorithms;
        this.key = key;
        this.reverse = reverse;
        this.iterations = iterations;
    }
    
    public final Object[] data;
    public final String[] algorithms;
    public final String key;
    public final boolean reverse;
    public final int iterations;
    
    public static SortRequest fromJson(String json) throws JsonSyntaxException {
        return new Gson().fromJson(json, SortRequest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}