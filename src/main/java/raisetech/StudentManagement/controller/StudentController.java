package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentscourses;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.searchStudentList();
  }

  @GetMapping("/30yearOldStudentList")
  public List<Student> get30yearOldStudentList(){
    return service.search30yearOldStudents();
  }

  @GetMapping("/studentcoursesList")
  public List<Studentscourses> getStudentcoursesList() {
    return service.searchStudentcoursesList();
  }

  @GetMapping("/studentsJavaCourseInfo")
  public  List<Studentscourses> getJavaCourseInfo(){
    return service.searchJavaCourseInfo();
  }
}
