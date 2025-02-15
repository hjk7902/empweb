package com.example.myapp.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.hr.model.Emp;
import com.example.myapp.hr.service.IEmpService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpRestController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping
	public List<Map<String, Object>> getAllEmps() {
		return empService.getEmpListMap();
	}
	
	@GetMapping("/{empid}")
	public Map<String, Object> getEmp(@PathVariable int empid) {
		return empService.getEmpInfoMap(empid);
	}
	
	@PostMapping
	public Emp insertEmp(@RequestBody Emp emp) {
		empService.insertEmp(emp);
		return emp;
	}
	
	@PutMapping
	public void updateEmp(@RequestBody Emp emp) {
		empService.updateEmp(emp);
	}
	
	@DeleteMapping
	public void deleteEmp(int empid, String email) {
		empService.deleteEmp(empid, email);
	}
	
	@GetMapping("/jobids")
	public List<Map<String, Object>> getAllJobId() {
		return empService.getAllJobId();
	}
	
	@GetMapping("/deptids")
	public List<Map<String, Object>> getAllDeptId() {
		return empService.getAllDeptId();
	}
	
	@GetMapping("/mgrids")
	public List<Map<String, Object>> getAllManagerId() {
		return empService.getAllManagerId();
	}
}