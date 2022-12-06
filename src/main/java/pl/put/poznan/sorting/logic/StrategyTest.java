package pl.put.poznan.sorting.logic;

import java.util.Arrays;

public class StrategyTest {
    public static void main(String args[]) {

        int numbers[] = {1, 2, 3, 4};

        String words[] = {"aaa", "bbb", "ccc"};

        SortContext context = new SortContext(new Test());
        System.out.println(Arrays.toString(context.sort(numbers)));
        System.out.println(Arrays.toString(context.sort(words)));

    }
}
