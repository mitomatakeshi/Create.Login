package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.been.Customer;

public class CustomerDAO extends DAO{
	public Customer search(String login, String password)
			throws Exception{
		
				Customer customer = null;
				
				Connection con = getConnection();
				
				PreparedStatement st;
				st = con.prepareStatement(
						"select * from costomer where login=? and password =?");
				st.setString(1,login);
				st.setString(2,password);
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					customer=new Customer();
					customer.setId(rs.getInt("id"));
					customer.setLogin(rs.getString("login"));
					customer.setPassword(rs.getString("password"));
				}
				st.close();
				con.close();
				return customer;
			}	

		}


