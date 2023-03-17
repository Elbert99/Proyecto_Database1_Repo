/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class Connection {
    private static java.sql.Connection connection;

	public Connection(String serveraddres, String database, String user,String pass) throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://" + serveraddres + ":5433/"+ database;
			connection = DriverManager.getConnection(url, user, pass);
	}

	 public java.sql.Connection getConnection() {
		return connection;
	}
}
