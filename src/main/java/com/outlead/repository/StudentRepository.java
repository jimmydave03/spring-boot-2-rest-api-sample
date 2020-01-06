package com.outlead.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outlead.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
