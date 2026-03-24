package primary_qualifier.entity;

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts...");
    }
}
