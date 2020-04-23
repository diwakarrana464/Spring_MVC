package com.rana.dao;

import java.util.List;

import com.rana.javabeans.EmployeeBO;
import com.rana.javabeans.EmployeeResultBO;

public interface EmployeeDAO {
	
	public List<EmployeeResultBO>  find(EmployeeBO bo);

}
