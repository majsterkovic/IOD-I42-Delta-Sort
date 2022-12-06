package pl.put.poznan.sorting.logic;

public class SortContext {
    private SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] sort(int[] data) {
        return strategy.sort(data);
    }

    public String[] sort(String[] data) {
        return strategy.sort(data);
    }
}
