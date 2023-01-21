package department.repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import department.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	@Bean
	Department findBydepartmentCode(String departmentCode);

}
