package threads.main;

import java.util.LinkedList;
import java.util.Queue;

public class Parking {
    private int availablePlaces;
    private Queue<Car> carsQueue = new LinkedList<>();

    public Parking(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public void addCarIntoQueue(Car car) {
        carsQueue.offer(car);
    }

    public Queue<Car> getCarsQueue() {
        return carsQueue;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void decreaseAvailablePlaces() {
        availablePlaces--;
    }

    public void increaseAvailablePlases() {
        availablePlaces++;
    }
}
