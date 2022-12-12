package pl.put.poznan.sorting.models;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class SortRequest {

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
    
    public static SortRequest fromJson(String json) throws JsonSyntaxException {
        return new Gson().fromJson(json, SortRequest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}