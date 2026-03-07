package org.capgi.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.capgi.jpa.entity.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-students");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

//        Student s1 = new Student();
//        s1.setName("Manas");
//        s1.setDept("CSDS");
//        s1.setAge(22);
//        s1.setMarks(87.5);
//
//        Student s2 = new Student();
//        s2.setName("Rish");
//        s2.setDept("CSE");
//        s2.setAge(23);
//        s2.setMarks(58.5);
//
//        entityManager.persist(s1);
//        entityManager.persist(s2);
//
//        entityTransaction.commit();

        // ----------------- Fetch All -------------------------------
        List<Student> students =
                entityManager.createQuery("from Student", Student.class)
                        .getResultList();

        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        //  ---------------- Fetch By ID -----------------------

//        Student studentById = entityManager.find(Student.class, 1);
//        System.out.println("Student with ID 1:");
//        System.out.println(studentById);
//
//        entityManager.close();
//        emf.close();
//
//        System.out.println("Operation completed");

        // --------------- Update --------------------

//        Student student = entityManager.find(Student.class, 1);
//        student.setAge(23);
//        entityManager.merge(student);
//        entityTransaction.commit();
//        System.out.println("Updated row");

        // ------------------- Delete --------------------------

//        Student studentDelete = entityManager.find(Student.class,2);
//        entityManager.remove(studentDelete);
//        entityTransaction.commit();
    }
}