package pl.put.poznan.sorting.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    private static int N;
    private static SortContext sortContext;

    @BeforeAll
    static void setUp() {
        sortContext = new SortContext(new InsertionSort());
        N = 10000;
    }


    @Test
    void sortNumbers_Random() {

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = (int) (Math.random() * 200) - 100;
        }
        int[] expected = data.clone();
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    @Test
    void sortNumbers_Sorted() {

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = (int) (Math.random() * 200) - 100;
        }
        int[] expected = data.clone();

        Arrays.sort(data);
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    @Test
    void sortNumbers_ReverseSorted() {

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = (int) (Math.random() * 200) - 100;
        }
        int[] expected = data.clone();

        Arrays.sort(data);
        Collections.reverse(Arrays.asList(data));
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    @Test
    void sortNumbers_Same() {

        int[] data = new int[N];
        Arrays.fill(data, 5);
        int[] expected = data.clone();
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }


    @Test
    void sortStrings_Same() {

        String[] data = new String[10];
        Arrays.fill(data, "aaa");
        String[] expected = data.clone();
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    private String randomString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    @Test
    void sortString_Random() {

        String[] data = new String[N];
        for (int i = 0; i < N; i++) {
            data[i] = randomString(10);
        }
        String[] expected = data.clone();
        Arrays.sort(expected);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    @Test
    void sortString_Sorted() {

        String[] data = new String[N];
        for (int i = 0; i < N; i++) {
            data[i] = randomString(10);
        }
        String[] expected = data.clone();
        Arrays.sort(expected);

        Arrays.sort(data);

        assertArrayEquals(expected, sortContext.sort(data));
    }

    @Test
    void sortString_ReverseSorted() {


        String[] data = new String[N];
        for (int i = 0; i < N; i++) {
            data[i] = randomString(10);
        }
        String[] expected = data.clone();
        Arrays.sort(expected);

        Arrays.sort(data);
        Collections.reverse(Arrays.asList(data));

        assertArrayEquals(expected, sortContext.sort(data));

    }
}