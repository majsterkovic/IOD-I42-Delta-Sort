package pl.put.poznan.sorting.logic;

/**
 * Measuring time implementation.
 *
 */

public class Timer {
    private long startTime;
    private long endTime;

    public void startMeasure() {
        startTime = System.nanoTime();
    }

    public void stopMeasure() {
        endTime = System.nanoTime();
    }

    public String getElapsedTime() {
        return String.valueOf((endTime - startTime) / 1000000.0);
    }

    public String getElapsedTime(String format) {
        switch (format) {
            case "ms" -> {
                return String.valueOf((endTime - startTime) / 1000000.0);
            }
            case "s" -> {
                return String.valueOf((endTime - startTime) / 1000000000.0);
            }
            case "m" -> {
                return String.valueOf((endTime - startTime) / 60000000000.0);
            }
            case "m:s" -> {
                long time = endTime - startTime;
                long minutes = time / 60000000000L;
                long seconds = (time % 60000000000L) / 1000000000L;
                return minutes + ":" + seconds;
            }
            default -> {
                return String.valueOf(endTime - startTime);
            }
        }
    }
}
