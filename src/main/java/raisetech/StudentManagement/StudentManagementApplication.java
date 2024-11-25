package raisetech.StudentManagement;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private  StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/student")
	public String getStudent(@RequestParam String name){
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳" + " " + student.getGender() + " " + student.getRegion();
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age, String gender, String region){
		repository.registerStudent(name,age,gender,region);
	}

	@PatchMapping("/student")
	public void updateStudentName(String name, int age, String gender, String region){
		repository.updateStudent(name,age,gender,region);
	}

	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}
}