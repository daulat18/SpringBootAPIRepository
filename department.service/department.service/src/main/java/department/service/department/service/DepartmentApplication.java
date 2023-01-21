package department.service.department.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import department.model.Department;
import department.repository.DepartmentRepository;



@SpringBootApplication
@ComponentScan({"department*"})
@EntityScan("department*")
@EnableJpaRepositories("department*")
@ComponentScan("department*")
@EnableEurekaClient
public class DepartmentApplication {
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	@PostConstruct
	  private void initDb() {
	    Department department = new Department();
	    department.setDepartmentAddress("Pune");
	    department.setDepartmentName("Computer");
	    department.setDepartmentCode("18");
	    
	    
	    departmentRepository.save(department);
	  }
}
