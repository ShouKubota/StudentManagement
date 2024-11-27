package raisetech.StudentManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student WHERE name = #{name}")
  Student searchByName(String name);

  @Insert("INSERT student value(#{name},#{age}),#{gender},#{region}")
  void registerStudent(String name, int age, String gender, String region);

  @Update("UPDATE student SET age = #{age}, gender = #{gender}, region = #{region} WHERE name = #{name}")
  void updateStudent(String name, int age, String gender, String region);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);
}
