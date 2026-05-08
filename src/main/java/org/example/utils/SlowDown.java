package org.example.utils;

public class SlowDown {

    public static void waitForStep() {

        try {
            if (Config.DEBUG_MODE) {
                Thread.sleep(2000); // 2 sec delay for debug mode
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}