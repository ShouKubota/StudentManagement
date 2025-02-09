package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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

  @Insert("INSERT INTO students (name, kananame, nickname, email, area, age, sex, remark,is_deleted) "
      + "VALUES (#{name}, #{kanaName},  #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark},false)")

  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course_name, start_time, end_time)"
      + "VALUES(#{studentId},#{courseName},#{startTime},#{endTime})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);
}
