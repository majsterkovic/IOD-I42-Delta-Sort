package pl.put.poznan.sorting.logic;

import com.google.gson.internal.LinkedTreeMap;
/**
 * Object comparator implementation.
 */

public class Comparator {

    private String key;

    Comparator(String key) {
        this.key = key;
    }
    /**
     * Returns the result of comparing two objects.
     * Supported data types: Integer, Long, Float,
     * Double, String, LinkedTreeMap.
     *
     *
     * @param   a   Object to compare to b
     * @param   b   Object to compare to a
     * @return      less than 0 if a is less than b
     *              0 if a is equal to b
     *              more than 0 if a is more than b
     */
    public int compareTo(Object a, Object b) {

        if (a instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        }
        else if (a instanceof Long) {
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
