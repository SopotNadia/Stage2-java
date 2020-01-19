package threads.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
    private String marka;
    private static ReentrantLock locker = new ReentrantLock();
    private static Condition condition = locker.newCondition();

    public Car(String marka) {
        this.marka = marka;
    }

    public void tryToPark(Parking parking) {
        while (parking.getAvailablePlaces() == 0) {
            if (locker.tryLock()) {
                try {
                    if (!condition.await(5, TimeUnit.SECONDS)) {
                        System.out.println(marka + " can't wait more. Car's leaving the queue");
                        return;
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    locker.unlock();
                }
            }
        }
        try {
            locker.lock();
            if (parking.getAvailablePlaces() > 0) {
                parking.decreaseAvailablePlaces();
                System.out.println(marka + " is parking");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
        leaveParking(parking);
    }

    public void leaveParking(Parking parking) {
        try {
            Thread.sleep((long) (4000 + Math.random() * 2000));
            locker.lock();
            System.out.println(marka + " is leaving the parking");
            parking.increaseAvailablePlases();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            condition.signalAll();
            locker.unlock();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                '}';
    }
}
