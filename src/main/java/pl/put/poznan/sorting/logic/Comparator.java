package pl.put.poznan.sorting.logic;

import org.json.JSONObject;

public class Comparator {

    private String key;

    Comparator(String key) {
        this.key = key;
    }

    public int compareTo(Object a, Object b) {

        if (a instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        }
        if (a instanceof Long) {
            return ((Long) a).compareTo((Long) b);
        }
        else if (a instanceof Float) {
            return ((Float) a).compareTo((Float) b);
        }
        else if (a instanceof Double) {
            return ((Double) a).compareTo((Double) b);
        }
        else if (a instanceof String) {
            return ((String) a).compareTo((String) b);
        }
        else if (a instanceof JSONObject) {
            if (key == null) {
                key = ((JSONObject) a).names().getString(0);
            }
            a =  ((JSONObject) a).get(key);
            b =  ((JSONObject) b).get(key);
            return this.compareTo(a, b);
        }
        else {
            return 0;
        }
    }
}
