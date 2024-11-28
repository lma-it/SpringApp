package ru.kors.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.service.StudentService;

import java.util.*;

@RestController
@RequestMapping("/api/v1/students")
/**
 * ПРИМЕР функционала DEPENDENCY INJECTION
 * Добавляет конструктор с параметрами, который не нужно прописывать явно, за нас это делает Spring.
 * Так же он автоматически инициализирует поле service, которое имеет тип StudentService.
 * Благодаря этому мы можем спокойно вызывать метод service.findAllStudent из класса StudentService.
 *
 * */
@AllArgsConstructor
public class StudentController {
    private final StudentService service;
    @GetMapping
    public List<Student> findAllStudent() {
        //todo
        return service.findAllStudent();
    }
    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return "Student successfully saved!";
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @PutMapping("update_student")
    public Student updatestudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }
}
