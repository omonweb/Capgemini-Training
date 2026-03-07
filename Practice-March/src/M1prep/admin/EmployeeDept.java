package M1prep.admin;

import java.util.List;

interface Employee {

    void setName(String name);
    String getName();

    void setSalary(double salary);
    double getSalary();

    void setDepartment(String department);
    String getDepartment();

}

public class EmployeeDept implements Employee{

    String name;
    String department;
    double salary;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }
}
