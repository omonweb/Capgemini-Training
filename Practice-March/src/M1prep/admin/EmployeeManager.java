package M1prep.admin;

import java.util.ArrayList;
import java.util.List;

interface IEmployeeManager {

    void addEmployee(Employee emp);

    void removeEmployee(String name);

    List<Employee> getEmployees(String department);

    List<Employee> getEmployees();

    double getAverageSalary();

}

public class EmployeeManager implements IEmployeeManager{

    List<Employee> emps = new ArrayList<>();

    @Override
    public void addEmployee(Employee emp) {
        emps.add(emp);
    }

    @Override
    public void removeEmployee(String name) {
        emps.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
    }

    @Override
    public List<Employee> getEmployees(String department) {
        List<Employee> res = new ArrayList<>();

        for(Employee e : emps) {
            if(e.getDepartment().equalsIgnoreCase(department))
                res.add(e);
        }
        return res;
    }

    @Override
    public List<Employee> getEmployees() {
        return emps;
    }

    @Override
    public double getAverageSalary() {
        double total = 0;

        if(emps.isEmpty()) return 0;

        for(Employee e : emps) {
            total += e.getSalary();
        }
        return (double) total/emps.size();
    }
}
