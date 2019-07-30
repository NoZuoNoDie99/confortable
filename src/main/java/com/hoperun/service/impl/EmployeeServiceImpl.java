package com.hoperun.service.impl;

import com.hoperun.mapper.EmployeeMapper;
import com.hoperun.pojo.Employee;
import com.hoperun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public void insert(Employee employee) throws Exception {
		employeeMapper.insert(employee);
	}
	@Override
	public void delete(Integer empno) throws Exception {
		employeeMapper.delete(empno);
	}
	@Override
	public void update(Employee employee) throws Exception {
		employeeMapper.update(employee);
	}
	@Override
	public List<Employee> selectAll() throws Exception {
		return employeeMapper.selectAll();
	}
	@Override
	public Employee selectByEmpno(Integer empno) throws Exception {
		return employeeMapper.selectByEmpno(empno);
	}
	@Override
	public List<Employee> selectByLike(Employee employee) throws Exception {
		return employeeMapper.selectByLike(employee);
	}

}
