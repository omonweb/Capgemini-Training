package com.capgemini.repository;

import com.capgemini.dao.StudentDAO;
import com.capgemini.dao.StudentDAOImpl;
import com.capgemini.entity.Student;

import java.util.List;

public class StudentRepository {

    private final StudentDAO dao = new StudentDAOImpl();

    public void addStudent(Student student) {
        dao.save(student);
    }

    public Student findStudent(int id) {
        return dao.getById(id);
    }

    public List<Student> findAll() {
        return dao.getAll();
    }

    public void updateStudent(Student student) {
        dao.update(student);
    }

    public void deleteStudent(int id) {
        dao.delete(id);
    }

    public List<Student> sortByDept() {
        return dao.sortByDept();
    }

    public List<Student> sortByAge() {
        return dao.sortByAge();
    }
    public List<Student> fetchAllNative() {
        return dao.fetchAllNative();
    }
}