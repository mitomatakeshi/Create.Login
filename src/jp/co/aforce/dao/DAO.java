package jp.co.aforce.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO{
	static DataSource ds;
	public java.sql.Connection getConnection() throws Exception{
		if(ds ==null) {
			InitialContext ic = new InitialContext();
			ds =(DataSource) ic.lookup("java:/comp/env/jdbc/SampleLogin2");
					}
		return  ds.getConnection();
		
	}
}