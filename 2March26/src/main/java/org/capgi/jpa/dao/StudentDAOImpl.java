package org.capgi.jpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.capgi.jpa.entity.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa-students");

    @Override
    public void save(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
        em.close();
    }

    @Override
    public Student getById(int id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Student> list =
                em.createQuery("from Student", Student.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(student);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        tx.commit();
        em.close();
    }
}