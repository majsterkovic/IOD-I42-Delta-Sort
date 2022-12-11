package pl.put.poznan.sorting.app;

import org.json.JSONArray;

public class HandleJSON {

    public static String[] JSONArrayToStringArray(JSONArray array) {
        String[] result = new String[array.length()];
        for (int i = 0; i < array.length(); i++) {
            result[i] = array.getString(i);
        }
        return result;
    }
}
