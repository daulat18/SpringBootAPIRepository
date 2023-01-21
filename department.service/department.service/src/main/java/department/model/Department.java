package department.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name="Department")
@Getter
@Setter
@NoArgsConstructor

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
    private Long id;
	@Column(name = "DEPARTMENT_NAME")
    private String departmentName;
	@Column(name = "DEPARTMENT_ADDRESS")
    private String departmentAddress;
	@Column(name = "DEPARTMENT_CODE")
    private String departmentCode;
}
