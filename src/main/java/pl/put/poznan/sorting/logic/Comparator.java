package pl.put.poznan.sorting.logic;

import com.google.gson.internal.LinkedTreeMap;

public class Comparator {

    private String key;

    Comparator(String key) {
        this.key = key;
    }

    public int compareTo(Object a, Object b) {
        if (a instanceof Double) {
            return ((Double) a).compareTo((Double) b);
        }

        else if (a instanceof String) {
            return ((String) a).compareTo((String) b);
        }
        else if (a instanceof LinkedTreeMap) {
            if (key == null) {
                key = (String) ((LinkedTreeMap<?,?>) a).keySet().toArray()[0];
            }
            a =  ((LinkedTreeMap<?,?>) a).get(key);
            b =  ((LinkedTreeMap<?,?>) b).get(key);
            return this.compareTo(a, b);
        }
        else {
            return 0;
        }
    }
}
