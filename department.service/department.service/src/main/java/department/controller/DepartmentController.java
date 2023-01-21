package department.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import department.model.Department;
import department.repository.DepartmentRepository;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/department/api")
@AllArgsConstructor
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	private List<Department> getAllDepartment() {
		
	return departmentRepository.findAll();
		
	}
	
	@PostMapping
	private ResponseEntity<Department> addNewDpartment(@RequestBody Department depart){
		Department dept= departmentRepository.save(depart);
		 return new ResponseEntity<>(dept,HttpStatus.CREATED);
		
	}
	//Single
	@GetMapping("{departmentCode}")
    public ResponseEntity<Department> getUeserByDepartmentById(@PathVariable("departmentCode") String departmentCode){
	  Department dept = departmentRepository.findBydepartmentCode(departmentCode);
     
       return ResponseEntity.ok().body(dept);
    }
	
	
}
