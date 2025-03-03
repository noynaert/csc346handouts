/**
 * This class counts the number of clicks.
 */
public class ClickerModel {
    static private int clicks = 0;

    static public int getClicks() {
        return clicks;
    }
    static public void incrementClicks() {
        clicks++;
    }
    static public void resetClicks() {
        clicks = 0;
    }
    static public void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
