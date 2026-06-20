package org.example.utils;

public class SlowDown {

    public static void waitForStep() {

        try {
            if (Config.DEBUG_MODE) {
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}