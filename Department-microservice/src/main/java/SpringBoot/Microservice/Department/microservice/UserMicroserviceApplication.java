package SpringBoot.Microservice.Department.microservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


import user.model.User;
import user.service.UserRepository;

@SpringBootApplication(scanBasePackages={"user.service","ueserservice.impl","userDTO"})
@ComponentScan({"user*"})
@EntityScan("user*")
@EnableJpaRepositories("user*")
@ComponentScan("user*")
@EnableAutoConfiguration
@EnableEurekaClient
public class UserMicroserviceApplication {
	@Autowired
	  private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}
    // spring calls after the initialization of bean properties
  @PostConstruct
  private void initDb() {
    User user = new User();
    user.setFirstName("Daulat");
    user.setLastName("Bachhav");
    user.setEmail("db@gmail.com");
    user.setDepartmentId("18");
    
    userRepository.save(user);
  }
  
  @Bean
  public RestTemplate restTemplate(){
      return new RestTemplate();
  }
}
