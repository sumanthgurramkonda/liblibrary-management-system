package com.library.librarymanaegmentsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.librarymanaegmentsystem.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByRollNumber(long rollNo);

}
