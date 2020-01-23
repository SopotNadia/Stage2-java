package threads.optional;

import org.w3c.dom.ls.LSOutput;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Airplane extends Thread {
    private Semaphore semaphore;
    private Stack<Integer> commonResource;
    private Integer line;
    private int amountFlights = 0;

    public Airplane(Semaphore semaphore, Stack commonResource) {
        this.semaphore = semaphore;
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        try {
            while (amountFlights < 1) {
                semaphore.acquire();
                line = commonResource.pop();
                System.out.println(Thread.currentThread().getName() + " выходит на взлетную полосу " + line.toString());
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " набирает скорость");
                sleep(2000);
                amountFlights++;
                System.out.println(Thread.currentThread().getName() + " взлетел");
                System.out.println("Полоса " + line.toString() + "  свободна ");
                commonResource.push(line);
                semaphore.release();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
