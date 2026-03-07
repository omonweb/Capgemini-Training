package entity;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;

    private String brand;
    private double price;

    @OneToOne(mappedBy = "laptop")
    private Student1 student;

    public Laptop() {
    }

    public int getLaptopId() {
        return laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public Student1 getStudent() {
        return student;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStudent(Student1 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}