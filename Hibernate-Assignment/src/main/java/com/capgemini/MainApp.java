package com.capgemini;

import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;
import com.capgemini.util.HibernateUtil;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        repository.addStudent(new Student("Om", "IT", 21,88));
        repository.addStudent(new Student("Rish", "CSE", 22,91));
        repository.addStudent(new Student("Manazes", "CE", 20,85));

        List<Student> all = repository.findAll();
        all.forEach(System.out::println);

        Student student = repository.findStudent(1);
        if (student != null) {
            student.setMarks(95.0);
            repository.updateStudent(student);
        }

        repository.deleteStudent(3);

        repository.sortByDept().forEach(System.out::println);
        repository.sortByAge().forEach(System.out::println);
        repository.fetchAllNative().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}