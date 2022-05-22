package ru.geekbrains.isemenov.trainingCorse_hibernate;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.isemenov.trainingCorse_hibernate.entities.Student;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.isemenov.trainingCorse_hibernate");

        StudentDao studentDao = context.getBean(StudentDaoImpl.class);

        for (int i = 0; i < 1000; i++) {
            studentDao.saveOrUpdate(new Student("Student"+i, 3));
        }
        studentDao.deleteStudentById(1L);
        System.out.println(studentDao.saveOrUpdate(new Student("Nick", 5)).getId());
        studentDao.saveOrUpdate(new Student(5L, "Jack", 4));
        Student student = studentDao.findById(10L);
        System.out.println(student.getName());
        List<Student> studentList = studentDao.findAll();
        for (int i = 200; i < 210; i++) {
            System.out.println(studentList.get(i).getName());
        }
    }
}
