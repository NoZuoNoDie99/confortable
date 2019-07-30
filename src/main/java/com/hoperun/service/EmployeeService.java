package com.hoperun.service;

import com.hoperun.pojo.Employee;

import java.util.List;
public interface EmployeeService {

	
	void insert(Employee employee) throws Exception;
	
	void delete(Integer empno) throws Exception;
	
	void update(Employee employee) throws Exception;
	
	List<Employee> selectAll() throws Exception;
	
	Employee selectByEmpno(Integer empno) throws Exception;
	
	List<Employee> selectByLike(Employee employee) throws Exception;

}
