package com.example.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.example.myapp.hr.model.Emp;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<Map<String, Object>> getEmpListMap();
	Map<String, Object> getEmpInfoMap(int empid);

	List<Emp> getEmpList();
	Emp getEmpInfo(int empid);
	void updateEmp(Emp emp);
	void insertEmp(Emp emp);
	int deleteEmp(int empid, String email);
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}