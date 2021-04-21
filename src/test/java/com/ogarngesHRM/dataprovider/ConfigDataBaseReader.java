package com.ogarngesHRM.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConfigDataBaseReader {

	FileInputStream fls;
	Properties pro;   
	public static Connection connect = null;
	public static Statement statement = null;
	public static PreparedStatement ps = null;
	public static ResultSet resultSet = null;

	public ConfigDataBaseReader() {
		File src = new File(System.getProperty("user.dir") + "/Config/Config.properties");
		try {
			fls = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the file." + e.getMessage());
		}

		pro = new Properties();
		try {
			pro.load(fls);
			fls.close();
		} catch (IOException e) {
			System.out.println("Could not read the file." + e.getMessage());
		}

	}// end method

	public String getProperty(String key) {
		String Dat = pro.getProperty(key);
		return Dat;
		// or
		// return pro.getProperty(key);
	}

	public Connection connectToSqlDatabase() throws ClassNotFoundException, SQLException {
		//Properties prop = loadProperties();
		//String driverClass = pro.getProperty("MYSQLJDBC.driver");		
		String driverClass = pro.getProperty("MYSQLJDBC.driver");
		String url = pro.getProperty("MYSQLJDBC.url");
		String userId = pro.getProperty("MYSQLJDBC.UserId");
		String password = pro.getProperty("MYSQLJDBC.Pass");
		
		Class.forName(driverClass);
		connect = DriverManager.getConnection(url, userId, password);
		System.out.println("Database is connected");
		return connect;
	}

}// end class
