package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<Student> search30yearOldStudents() {
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() <= 39).toList();
  }


  public List<StudentsCourses> searchStudentcoursesList() {
    return repository.StudentsCourses();
  }

  public List<StudentsCourses> searchJavaCourseInfo() {
    return repository.StudentsCourses().stream()
        .filter(course -> course.getCourseName().equals("Javaコース"))
        .collect(Collectors.toList());
  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for (StudentsCourses studentsCourses : studentDetail.getStudentsCourses()) {
      studentsCourses.setStudentId(studentDetail.getStudent().getId());
      studentsCourses.setStartTime(LocalDateTime.now());
      studentsCourses.setEndTime(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentsCourses);
    }
  }
}
