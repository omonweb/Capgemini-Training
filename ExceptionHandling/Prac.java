package acception;

public class Prac {

    public static void checkSalary(double salary) throws SalException {

        if (salary < 5000) {
            throw new SalException("Salary is too low!");
        }

        System.out.println("Salary accepted.");
    }

    public static void main(String[] args) {

        try {
            checkSalary(8000);   
        } catch (SalException e) {
            System.out.println(e.getMessage());
        }
    }
}