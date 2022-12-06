package pl.put.poznan.sorting.logic;

import java.util.Arrays;

/**
 * A class to test the implementation of SortStrategy.
 * May be used for testing other sorting algorithms later on.
 */
public class StrategyTest {
    public static void main(String args[]) {

        int numbers[] = {1, 2, 3, 4};

        String words[] = {"aaa", "bbb", "ccc"};

        SortContext context = new SortContext(new DummySort());
        System.out.println(Arrays.toString(context.sort(numbers)));
        System.out.println(Arrays.toString(context.sort(words)));

    }
}
