package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Masudul Haque
 */
public class TimerTaskApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Hello World");
            }
        }, 1000, 1000);
    }

}
