package primary_qualifier.entity;

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts...");
    }
}
