package pl.put.poznan.sorting.logic;


import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.google.gson.internal.LinkedTreeMap;

class TestQuickSort
{

    private SortContext context;

    @BeforeEach
    void setUp()
    {
        context = new SortContext(new SortingWrapper().getSorter("quick"));
    }

    @Test
    @DisplayName("Sorting integer values")
    void IntegerTest()
    {
        Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
        Integer[] expected = {1, 2, 2, 3, 4, 5, 5};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("Sorting integer values with negative values")
    void IntegerTestNegative()
    {
        Integer[] unsorted = {3, 2, 5, -1, 4, 2, -5};
        Integer[] expected = {-5, -1, 2, 2, 3, 4, 5};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("Sorting long values")
    void LongTest()
    {
        Long[] unsorted = {Long.MAX_VALUE, 2l, 5l, 1l, Long.MIN_VALUE};
        Long[] expected = {Long.MIN_VALUE, 1l, 2l, 5l, Long.MAX_VALUE};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("Sorting double values")
    void DoubleTest()
    {
        Double[] unsorted = {3.2, 1.3, 2.2, 3.1, 1.5, 3.1, 1.3};
        Double[] expected = {1.3, 1.3, 1.5, 2.2, 3.1, 3.1, 3.2};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("Sorting double values with negatives values")
    void DoubleTestNegative()
    {
        Double[] unsorted = {-3.2,1.3,-2.2,3.1,1.5};
        Double[] expected = {-3.2,-2.2,1.3,1.5,3.1};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("String array sort test")
    void StringArrayTest()
    {
        String[] unsorted = {"hand", "haga",  "Haga", "antena", "anTENA", "warszawa", "war", "0x16", "0x8", "0X8"};
        String[] expected = {"0X8", "0x16", "0x8", "Haga", "anTENA", "antena", "haga", "hand", "war", "warszawa"};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("String array sort test with special Signs")
    void StringArrayTestSpecial()
    {
        String[] unsorted = {"hand", "haga",  "Haga", "an****", "anTENA", "war$zawa", "war.", "0x16", "0x8", "0X8", "war,", "\nada", " haga", "+haga"};
        String[] expected = {"\nada", " haga", "+haga", "0X8", "0x16", "0x8", "Haga", "an****", "anTENA", "haga", "hand", "war$zawa", "war,", "war."};

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,false));
    }

    @Test
    @DisplayName("Iteration counter test")
    void IterationBreakTest()
    {
        Integer[] unsorted = {3, 56, 2, 5, 1, 4, 2, 5, 1, 5, 2, 10, 11, 2, 4, 9, 23};
        Integer[] expected = {1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 5, 5, 9, 10, 11, 23, 56 };

        Assertions.assertFalse(Arrays.equals(expected, context.sort(unsorted,null,4,false)));

        Assertions.assertArrayEquals(expected, context.sort(unsorted, null, 5000, false));
    }

    @Test
    @DisplayName("Reverse sort test")
    void ReverseSortTest()
    {
        //TODO: verify arg passing to method of context sort
        Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
        Integer[] expected = {5, 5, 4, 3, 2, 2, 1};

        Assertions.assertFalse(Arrays.equals(expected, context.sort(unsorted,null,0,false)));

        Assertions.assertArrayEquals(expected, context.sort(unsorted,null,0,true));
    }

    @Test
    @DisplayName("Tree object test")
    void TreeObjectTest()
    {
        LinkedTreeMap<String, Object>[] unsorted = new LinkedTreeMap[4];
        unsorted[0] = new LinkedTreeMap<>();
        unsorted[0].put("name", "Anna");
        unsorted[0].put("age", 21);
        unsorted[1] = new LinkedTreeMap<>();
        unsorted[1].put("name", "Zeta");
        unsorted[1].put("age", 30);
        unsorted[2] = new LinkedTreeMap<>();
        unsorted[2].put("name", "Ana");
        unsorted[2].put("age", 20);
        unsorted[3] = new LinkedTreeMap<>();
        unsorted[3].put("name", "Bartek");
        unsorted[3].put("age", 18);
         

        LinkedTreeMap<String, Object>[] sortName = new LinkedTreeMap[4];
        sortName[0] = new LinkedTreeMap<>();
        sortName[0].put("name", "Ana");
        sortName[0].put("age", 20);
        sortName[1] = new LinkedTreeMap<>();
        sortName[1].put("name", "Anna");
        sortName[1].put("age", 21);
        sortName[2] = new LinkedTreeMap<>();
        sortName[2].put("name", "Bartek");
        sortName[2].put("age", 18);
        sortName[3] = new LinkedTreeMap<>();
        sortName[3].put("name", "Zeta");
        sortName[3].put("age", 30);

        LinkedTreeMap<String, Object>[] sortAge = new LinkedTreeMap[4];
        sortAge[0] = new LinkedTreeMap<>();
        sortAge[0].put("name", "Bartek");
        sortAge[0].put("age", 18);
        sortAge[1] = new LinkedTreeMap<>();
        sortAge[1].put("name", "Ana");
        sortAge[1].put("age", 20);
        sortAge[2] = new LinkedTreeMap<>();
        sortAge[2].put("name", "Anna");
        sortAge[2].put("age", 21);
        sortAge[3] = new LinkedTreeMap<>();
        sortAge[3].put("name", "Zeta");
        sortAge[3].put("age", 30);

        Assertions.assertArrayEquals(sortName, context.sort(unsorted,"name",0,false));
        Assertions.assertArrayEquals(sortAge, context.sort(unsorted,"age",0,false));
    }
}