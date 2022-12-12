package pl.put.poznan.sorting.models;

import com.google.gson.Gson;

public class SortResult {

    public SortResult(String algorithm, String time, Object[] data) {
        this.algorithm = algorithm;
        this.time = time;
        this.data = data;
    }
    
    public static SortResult fromJson(String json) {
        return new Gson().fromJson(json, SortResult.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public final String algorithm;
    public final String time;
    public final Object[] data;

}
