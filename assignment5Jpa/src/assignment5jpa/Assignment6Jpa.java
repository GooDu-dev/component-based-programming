/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment5jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wutic
 */
public class Assignment6Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department d1 = new Department(1, "IT");
        persist(d1);
        Department d2 = new Department(2, "HR");
        persist(d2);
        // Persist a new student
        Student john = new Student(1, "John", "Network Admin", 56789, 1);
        persist(john);
        Student marry = new Student(2, "Marry", "HR Manager", 46789, 2);
        persist(marry);
        Student henry = new Student(3, "Henry", "Programmer", 67890, 1);
        persist(henry);
        Student clark = new Student(4, "Clark", "HR recuiter", 36789, 2);
        persist(clark);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.findAll(Student.class));
        System.out.println(em.findAll(Department.class));

        em.close();

    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updateStudent(int id, String newName, double newGpa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Student std = em.find(Student.class, id);
            if (std != null) {
                std.setName(newName);
                std.setGpa(newGpa);
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + id + " not found.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteStudent(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5JpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Student std = em.find(Student.class, id);
            if (std != null) {
                em.remove(std);
                em.getTransaction().commit();
            } else {
                System.out.println("Student with ID " + id + " not found.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
