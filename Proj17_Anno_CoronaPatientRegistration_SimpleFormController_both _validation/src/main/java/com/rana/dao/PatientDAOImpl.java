package com.rana.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rana.javabeans.PatientBO;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	private static final String Insert_query = "INSERT INTO CORONA_PATIENT(PATNAME, HOSPITAL, LOCATION, AGE) VALUES(?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	
	    @Override
	     public int insertData(PatientBO bo) {
	    	 return  jt.update(Insert_query, bo.getPatName(), bo.getHospital(), bo.getLocation(), bo.getAge() );
	     }

}
