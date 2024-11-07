package raisetech.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	private String name = "Kubota Shou";
	private String age = "24";
	private String name2 = "Satou Tarou";
	private String age2 = "36";

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo(){
		return name + " " + age + "歳" + name2 + " " + age2 + "歳";
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(String name, String age, String name2, String age2){
		this.name = name;
		this.age = age;
		this.name2 = name2;
		this.age2 = age2;
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name){
		this.name = name;
	}

	@PostMapping("/studentName2")
	public void updateStudentName2(String name2){
		this.name2 = name2;
	}
}