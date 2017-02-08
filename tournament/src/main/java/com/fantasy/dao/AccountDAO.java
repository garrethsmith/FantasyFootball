package com.fantasy.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.DispatcherServlet;


public class AccountDAO {

	JdbcTemplate jdbcTemplate;
	

	public void setDatasource(DataSource datasource) {
		//this.jdbcTemplate = new JdbcTemplate(datasource);
	}

}
