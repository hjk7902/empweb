package com.example.myapp.hr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.hr.model.Emp;

@Mapper
@Repository
public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<Map<String, Object>> getEmpListMap();
	Map<String, Object> getEmpInfoMap(int empid);
	List<Emp> getEmpList();
	Emp getEmpInfo(int empid);
	void updateEmp(Emp emp);
	void insertEmp(Emp emp);
	void deleteJobHistory(int empid);
	
	@Transactional("transactionManager")
	int deleteEmp(int empid, String email);
	
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}