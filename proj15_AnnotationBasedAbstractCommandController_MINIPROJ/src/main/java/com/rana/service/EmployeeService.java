package com.rana.service;

import java.util.List;

import com.rana.javabeans.EmployeeDTO;
import com.rana.javabeans.EmployeeResultDTO;

public interface EmployeeService {

	 public List<EmployeeResultDTO>  search(EmployeeDTO dto);
	
}
