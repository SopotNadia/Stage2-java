package threads.optional;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) {
        Airport airport = new Airport("Malpensa");
        for (int i = 1; i < 6; i++) {
            airport.addIntoStack(i);
        }
        ReentrantLock locker = new ReentrantLock();
        Stack<Integer> commonResource = airport.getListLines();
        Semaphore semaphore = new Semaphore(5, true);
        for (int i = 1; i < 11; i++) {
            Thread thread = new Airplane(semaphore, locker, commonResource);
            thread.setName("Boeing " + i);
            thread.start();
        }
    }
}
