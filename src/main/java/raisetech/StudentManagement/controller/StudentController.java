package raisetech.StudentManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.Studentscourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<Studentscourses> studentscourses = service.searchStudentcoursesList();

    return converter.convertStudentDetails(students, studentscourses);
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
