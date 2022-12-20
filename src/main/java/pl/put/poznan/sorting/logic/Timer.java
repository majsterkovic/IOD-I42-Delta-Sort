package pl.put.poznan.sorting.logic;
/**
 * Timing implementation.
 *
 */
public class Timer {
    private long startTime;
    private long endTime;
    /**
     * Start of measuring time.
     * Assigning the result to a class field startTime.
     */
    public void startMeasure() {
        startTime = System.nanoTime();
    }
    /**
     * End of measuring time.
     * Assigning the result to a class field endTime.
     */
    public void stopMeasure() {
        endTime = System.nanoTime();
    }
    /**
     * Calculating the time from start point to end.
     *
     * @return  measured time
     */
    public String getElapsedTime() {
        return String.valueOf((endTime - startTime) / 1000000.0);
    }
    /**
     * Calculating the time from start ponit to end in chosen format.
     *
     * @param   format  seconds, miliseconds, minutes, minutes with seconds
     * @return          measured time in a chosen format
     */
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
