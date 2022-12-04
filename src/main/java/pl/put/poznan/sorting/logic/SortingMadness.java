package pl.put.poznan.sorting.logic;

public class SortingMadness {
    private final String[] numbers;

    public SortingMadness(String[] numbers) {
        this.numbers = numbers;
    }

    public String[] sort() {
        int n = numbers.length;
        int[] numbersInt = new int[n];
        for (int i = 0; i < n; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            int min = numbersInt[0];
            int minIndex = 0;
            for (int j = 0; j < n - i; j++) {
                if (numbersInt[j] < min) {
                    min = numbersInt[j];
                    minIndex = j;
                }
            }
            sorted[i] = min;
            numbersInt[minIndex] = numbersInt[n - i - 1];
        }
        String[] sortedString = new String[n];
        for (int i = 0; i < n; i++) {
            sortedString[i] = Integer.toString(sorted[i]);
        }
        return sortedString;
    }
}

