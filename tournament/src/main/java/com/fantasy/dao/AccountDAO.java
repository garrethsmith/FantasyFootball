package com.fantasy.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAO {

	JdbcTemplate jdbcTemplate;
	
	
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

}
