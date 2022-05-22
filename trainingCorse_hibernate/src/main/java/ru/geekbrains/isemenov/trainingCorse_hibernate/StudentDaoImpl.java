package ru.geekbrains.isemenov.trainingCorse_hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.geekbrains.isemenov.trainingCorse_hibernate.entities.Student;

import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {

    @Override
    public Student saveOrUpdate(Student student) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            //session.createNativeQuery("Insert into student (name, mark) values " + student.getName() + ", " + student.getMark())
            session.getTransaction().commit();
        }
        return student;
    }

    @Override
    public Student deleteStudentById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            return student;
        } catch (IllegalArgumentException e) {
            System.out.println("There is no entity with id=" + id);
            return null;
        }
    }


    @Override
    public Student findById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            if (student == null) {
                return new Student("", 0);
            }
            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Student> studentList = session.createNativeQuery("SELECT * FROM student", Student.class)
                    .getResultList();
            session.getTransaction().commit();
            return studentList;
        }
    }
}
