package com.rana.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rana.dao.PatientDAO;
import com.rana.javabeans.PatientBO;
import com.rana.javabeans.PatientDTO;

@Service
public class PatientMgmtServiceImpl implements PatientMgmtService {
	
	@Autowired
	private PatientDAO dao;

	@Override
	public String register(PatientDTO dto) {
		
		int count =0;
		PatientBO bo = new PatientBO();
		BeanUtils.copyProperties(dto, bo);
		count = dao.insertData(bo);
		return (count == 0) ? " Registration is failed " : " Registration is successful";
	}
}
