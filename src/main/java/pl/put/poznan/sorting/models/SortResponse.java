package pl.put.poznan.sorting.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class SortResponse {

    public SortResponse(Object[] data, Map<String, Integer> time) {
        this.data = data;
        this.time = time;
    }

    public final Object[] data;
    public final Map<String, Integer> time;

    public static SortResponse fromJson(String json) throws JsonSyntaxException {
        return new Gson().fromJson(json, SortResponse.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}