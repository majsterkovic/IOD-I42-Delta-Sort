package pl.put.poznan.sorting.logic;


import java.util.Arrays;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class TestBubbleSort
{

    private SortContext context;

    @Test
    void IntTest()
    {
        Integer[] unsorted = {3,2,5,1,4};
        Integer[] expected = {1,2,3,4,5};

        context = new SortContext(new SortingWrapper().getSorter("bubble"));
        Assertions.assertTrue(Arrays.equals(expected, context.sort(unsorted, null)));

         
        
    }
}