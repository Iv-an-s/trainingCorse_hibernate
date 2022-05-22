package ru.geekbrains.isemenov.trainingCorse_hibernate;

import ru.geekbrains.isemenov.trainingCorse_hibernate.entities.Student;

import java.util.List;

public interface StudentDao {
    Student saveOrUpdate(Student student);
    Student deleteStudentById(Long id);
    Student findById(Long id);
    List<Student> findAll();
}
