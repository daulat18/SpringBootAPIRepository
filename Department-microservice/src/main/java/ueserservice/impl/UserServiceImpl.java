package ueserservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import user.model.User;
import user.service.UserRepository;
import user.service.UserService;
import userDTO.DepartmentDTO;
import userDTO.ResponseDTO;
import userDTO.UesrDTO;
@Service
@AllArgsConstructor
@Configuration
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RestTemplate restTemplate;
    
	@Override
	public ResponseDTO getUser(Long userId) {

		ResponseDTO responseDto = new ResponseDTO();
        User user = userRepository.findById(userId).get();
        UesrDTO userDto = mapToUser(user);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@" + user.getDepartmentId());
        ResponseEntity<DepartmentDTO> responseEntity = restTemplate
                .getForEntity("http://127.0.0.1:8082/department/api/" + user.getDepartmentId(),
                		DepartmentDTO.class);
        
        DepartmentDTO departmentDto = responseEntity.getBody();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@" + responseEntity.getStatusCode());

        responseDto.setDpDepartmentDTO(departmentDto);
        responseDto.setUsDto(userDto);

        return responseDto;
	}
	  private UesrDTO mapToUser(User user){
		  UesrDTO userDto = new UesrDTO();
	        userDto.setId(user.getId());
	        userDto.setFirstName(user.getFirstName());
	        userDto.setLastName(user.getLastName());
	        userDto.setEmail(user.getEmail());
	        userDto.setDepartmentId(user.getDepartmentId());
	        return userDto;
	    }

}
