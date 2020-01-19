package threads.main;

public class Runner {
    public static void main(String[] args) {
        //Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
        // Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.

        Parking parking = new Parking(1);
        parking.addCarIntoQueue(new Car("Volvo"));
        parking.addCarIntoQueue(new Car("Kia"));
        parking.addCarIntoQueue(new Car("BMV"));
        parking.addCarIntoQueue(new Car("Ford"));
        parking.addCarIntoQueue(new Car("Mazda"));
        parking.addCarIntoQueue(new Car("Ferrari"));
        parking.addCarIntoQueue(new Car("Opel"));

        while (!parking.getCarsQueue().isEmpty()) {
            new Thread(() -> {
                Car car = parking.getCarsQueue().poll();
                car.tryToPark(parking);
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
