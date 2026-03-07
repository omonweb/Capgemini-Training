package com.capgemini.dao;

import com.capgemini.entity.Student;
import com.capgemini.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @Override
    public Student getById(int id) {
        Session session = HibernateUtil.getFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = HibernateUtil.getFactory().openSession();
        List<Student> list = session
                .createQuery("from Student", Student.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public void update(Student student) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(student);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
    }

    @Override
    public List<Student> sortByDept() {
        Session session = HibernateUtil.getFactory().openSession();
        List<Student> list = session
                .createQuery("from Student order by dept", Student.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Student> sortByAge() {
        Session session = HibernateUtil.getFactory().openSession();
        List<Student> list = session
                .createQuery("from Student order by age", Student.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Student> fetchAllNative() {
        Session session = HibernateUtil.getFactory().openSession();
        List<Student> list = session
                .createNativeQuery("SELECT * FROM students", Student.class)
                .getResultList();
        session.close();
        return list;
    }
}