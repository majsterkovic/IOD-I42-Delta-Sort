package pl.put.poznan.sorting.logic;

public class PrimitiveComparator {

    public int compareTo(Object a, Object b) {
        if (a instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        }
        else if (a instanceof Float) {
            return ((Float) a).compareTo((Float) b);
        }
        else if (a instanceof String) {
            return ((String) a).compareTo((String) b);
        }
        else {
            return 0;
        }
    }
}
