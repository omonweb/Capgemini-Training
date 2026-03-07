

import DAO.StudentDao;
import DAO.StudentDaoImpl;

public class Student_Laptop_Application {

    public static void main(String[] args) {

        StudentDao dao = new StudentDaoImpl();

       // dao.saveData();


//        dao.fetchLaptopFromStudent(2);
//        dao.fetchLaptopFromStudent(3);
//        dao.fetchLaptopFromStudent(4);
//

//        dao.fetchStudentFromLaptop(2);
//        dao.fetchStudentFromLaptop(3);
//        dao.fetchStudentFromLaptop(4);

          // dao.updateLaptopBrand(1, "Lenovo");

         // dao.updateStudentCourse(1, "B.Com");

         dao.changeLaptopForStudent(2);

        // dao.removeLaptopFromStudent(1);

        // dao.deleteStudentAndLaptop(1);
    }
}