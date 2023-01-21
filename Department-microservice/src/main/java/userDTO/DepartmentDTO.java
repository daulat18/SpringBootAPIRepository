package userDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	
	 private Long id;
	 private String departmentName;
	 private String departmentAddress;
	 private String departmentCode;

}
