package user.contoller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import user.model.User;
import user.service.UserRepository;
import user.service.UserService;
import userDTO.ResponseDTO;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UesrController {
	@Autowired
	  private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	  @GetMapping("{id}")
	    public ResponseEntity<User> getUeserByDepartmentById(@PathVariable("id") Long id){
		  User ueser = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not availbele for Id :"+id));
	     
	       return ResponseEntity.ok().body(ueser);
	    }
	  
	  @GetMapping
	  public List<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	  
	  @PostMapping
	  public ResponseEntity<User> saveDepartment(@RequestBody User user){
		  User savedDepartment = userRepository.save(user);
	        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	    }
	  
	  @GetMapping("/userwithdept/{id}")
	    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Long userId){
		  ResponseDTO responseDto = userService.getUser(userId);
	        return ResponseEntity.ok(responseDto);
	    }
}
