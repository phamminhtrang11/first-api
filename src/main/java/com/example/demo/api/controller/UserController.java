package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
class StudentController {
    // Mock data - Danh sách học sinh và thông tin lớp
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(10, "Nguyen Van A", "10A"));
        students.add(new Student(11, "Pham Van B", "11A"));
        students.add(new Student(11, "Tran Van E", "11A"));
        students.add(new Student(12, "Pham Van F", "12B"));
    }

    // API endpoint để lấy danh sách học sinh theo lớp
    @GetMapping("/students/{class}")
    public ResponseEntity<List<Student>> getStudentsByClass(@PathVariable("class") String className) {
        List<Student> studentsByClass = new ArrayList<>();
        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                studentsByClass.add(student);
            }
        }

        if (studentsByClass.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentsByClass, HttpStatus.OK);
    }

    class Student {
        private int grade;
        private String name;
        private String className;

        public Student(int grade, String name, String className) {
            this.grade = grade;
            this.name = name;
            this.className = className;
        }

        // Getters and Setters

        public int getGrade() {
            return grade;
        }

        public void setId(int id) {
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}
