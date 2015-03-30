/**
 * 
 */
package com.sjsu.finalproj.mymedico.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sjsu.finalproj.mymedico.domain.User;

/**
 * @author mitikadia
 *
 */
public class UserRepository implements UserRepositoryInterface{
	
	
	@Override
	public int registerUser(User request){
		// TODO Auto-generated method stub
		
		//String url = "jdbc:mysql://dbname.test.us-east-1.rds.amazonaws.com:3306/";
		String url = "jdbc:mysql://meddbinstance.cozrev6gggap.us-west-1.rds.amazonaws.com:3306/";
		String userName ="CMPE295B";
		String password = "rememberme";
		String dbName = "mitidb";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Connection connection = DriverManager.getConnection(url + dbName, userName, password);
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO users " + "VALUES (1001, 'Jack', 'Smith', 'jacksmith@mailinator.com', 'abc')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return 200;
	}

}
