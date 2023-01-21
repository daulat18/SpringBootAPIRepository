package user.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import userDTO.ResponseDTO;
@Repository
public interface UserService {
	
	ResponseDTO getUser(Long userId);

}
