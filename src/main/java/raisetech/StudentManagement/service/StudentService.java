package raisetech.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
    //学生情報を保存
    repository.insertStudent(studentDetail.getStudent());

    //各コース情報を保存
    for (StudentsCourses course : studentDetail.getStudentsCourses()) {
      repository.insertStudentCourse(studentDetail.getStudent().getId(),
          course.getCourseName());
    }

  }
}
