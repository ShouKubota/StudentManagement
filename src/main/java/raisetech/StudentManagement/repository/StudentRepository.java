package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> StudentsCourses();

  // データベースに学生を挿入する処理
  @Insert("INSERT INTO students (name, nickname, email, region, age, gender, remark) " +
      "VALUES (#{name}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark})")
  void insertStudent(Student student);

  @Insert("INSERT INTO students_courses (student_id, course_name) VALUES (#{studentId}, #{courseName})")
  void insertStudentCourse(@Param("studentId") String studentId, @Param("courseName") String courseName);
}
