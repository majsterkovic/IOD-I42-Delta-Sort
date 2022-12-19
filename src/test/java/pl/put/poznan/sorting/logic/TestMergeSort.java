package pl.put.poznan.sorting.logic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TestMergeSort {

    private SortContext context;

    @BeforeEach
    void setUp() {
        context = new SortContext(new SortingWrapper().getSorter("merge"));
    }

    @Test
    @DisplayName("Sorting integer values")
    void IntegerTest() {
        Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
        Integer[] expected = {1, 2, 2, 3, 4, 5, 5};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("Sorting integer values with negative values")
    void IntegerTestNegative() {
        Integer[] unsorted = {3, 2, 5, -1, 4, 2, -5};
        Integer[] expected = {-5, -1, 2, 2, 3, 4, 5};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("Sorting long values")
    void LongTest() {
        Long[] unsorted = {Long.MAX_VALUE, 2l, 5l, 1l, Long.MIN_VALUE};
        Long[] expected = {Long.MIN_VALUE, 1l, 2l, 5l, Long.MAX_VALUE};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("Sorting double values")
    void DoubleTest() {
        Double[] unsorted = {3.2, 1.3, 2.2, 3.1, 1.5, 3.1, 1.3};
        Double[] expected = {1.3, 1.3, 1.5, 2.2, 3.1, 3.1, 3.2};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("Sorting double values with negatives values")
    void DoubleTestNegative() {
        Double[] unsorted = {-3.2, 1.3, -2.2, 3.1, 1.5};
        Double[] expected = {-3.2, -2.2, 1.3, 1.5, 3.1};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("String array sort test")
    void StringArrayTest() {
        String[] unsorted = {"hand", "haga", "Haga", "antena", "anTENA", "warszawa", "war", "0x16", "0x8", "0X8"};
        String[] expected = {"0X8", "0x16", "0x8", "Haga", "anTENA", "antena", "haga", "hand", "war", "warszawa"};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }

    @Test
    @DisplayName("String array sort test with specioal Signs")
    void StringArrayTestSpecial() {
        String[] unsorted = {"hand", "haga", "Haga", "an****", "anTENA", "war$zawa", "war.", "0x16", "0x8", "0X8", "war,", "\nada", " haga", "+haga"};
        String[] expected = {"\nada", " haga", "+haga", "0X8", "0x16", "0x8", "Haga", "an****", "anTENA", "haga", "hand", "war$zawa", "war,", "war."};

        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));
    }
}