package raisetech.StudentManagement;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Studentscourses {

  private String id;
  private String studentId;
  private String courseName;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

}
