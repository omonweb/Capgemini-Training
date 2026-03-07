package DAO;

import entity.Laptop;
import entity.Student1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa-students");

    @Override
    public void saveData() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

//        Laptop laptop = new Laptop();
//        laptop.setBrand("Dell");
//        laptop.setPrice(65000);
//
//        Laptop laptop1 = new Laptop();
//        laptop1.setBrand("Sony");
//        laptop1.setPrice(70000);
//
//        Laptop laptop2 = new Laptop();
//        laptop2.setBrand("Lenovo");
//        laptop2.setPrice(80000);
//
//        Laptop laptop3 = new Laptop();
//        laptop3.setBrand("Apple");
//        laptop3.setPrice(60000);
//
//        Student1 student = new Student1();
//        student.setStudentName("Om");
//        student.setCourse("B.Tech");
//        student.setLaptop(laptop);
//        laptop.setStudent(student);
//
//        Student1 student1 = new Student1();
//        student1.setStudentName("Kashish");
//        student1.setCourse("LLB");
//        student1.setLaptop(laptop1);
//        laptop1.setStudent(student1);
//
//        Student1 student2 = new Student1();
//        student2.setStudentName("Sahil");
//        student2.setCourse("B.Tech");
//        student2.setLaptop(laptop2);
//        laptop2.setStudent(student2);
//
//        Student1 student3 = new Student1();
//        student3.setStudentName("Vivek");
//        student3.setCourse("B.Tech");
//        student3.setLaptop(laptop3);
//        laptop3.setStudent(student3);

        Laptop laptop4 = new Laptop();
        laptop4.setBrand("Asus ROG");
        laptop4.setPrice(95000);

        Laptop laptop5 = new Laptop();
        laptop5.setBrand("Acer Gaming");
        laptop5.setPrice(65000);



//        em.persist(student);
//        em.persist(student1);
//        em.persist(student2);
//        em.persist(student3);

        em.persist(laptop4);
        em.persist(laptop5);

        tx.commit();
        em.close();
    }

    @Override
    public void fetchLaptopFromStudent(int studentId) {

        EntityManager em = emf.createEntityManager();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {
            System.out.println(student.getLaptop());
        }

        em.close();
    }

    @Override
    public void fetchStudentFromLaptop(int laptopId) {

        EntityManager em = emf.createEntityManager();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null && laptop.getStudent() != null) {
            System.out.println(laptop.getStudent());
        }

        em.close();
    }

    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null) {
            laptop.setBrand(newBrand);
        }

        tx.commit();
        em.close();
    }

    @Override
    public void updateStudentCourse(int studentId, String newCourse) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {
            student.setCourse(newCourse);
        }

        tx.commit();
        em.close();
    }

    @Override
    public void changeLaptopForStudent(int studentId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {

            Laptop oldLaptop = student.getLaptop();

            if (oldLaptop != null) {
                oldLaptop.setStudent(null);
                student.setLaptop(null);
            }

            List<Laptop> laptops;

            if (oldLaptop != null) {
                laptops = em.createQuery(
                                "from Laptop l where l.student is null and l.laptopId != :oldId",
                                Laptop.class
                        ).setParameter("oldId", oldLaptop.getLaptopId())
                        .getResultList();
            } else {
                laptops = em.createQuery(
                        "from Laptop l where l.student is null",
                        Laptop.class
                ).getResultList();
            }

            if (!laptops.isEmpty()) {

                int randomIndex =
                        new java.util.Random().nextInt(laptops.size());

                Laptop randomLaptop = laptops.get(randomIndex);

                student.setLaptop(randomLaptop);
                randomLaptop.setStudent(student);
            } else {
                System.out.println("No new laptop available.");
            }
        }

        tx.commit();
        em.close();
    }

    @Override
    public void removeLaptopFromStudent(int studentId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {

            Laptop laptop = student.getLaptop();

            student.setLaptop(null);
            laptop.setStudent(null);
        }

        tx.commit();
        em.close();
    }

    @Override
    public void deleteStudentAndLaptop(int studentId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {
            em.remove(student);
        }

        tx.commit();
        em.close();
    }
}
