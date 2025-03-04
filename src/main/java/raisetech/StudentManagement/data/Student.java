package raisetech.StudentManagement.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id;
  private String name;
  private String nickname;
  private int age;
  private String sex;
  private String email;
  private String area;
  private String remark;
  private boolean isDeleted;
  private String kanaName;
}
