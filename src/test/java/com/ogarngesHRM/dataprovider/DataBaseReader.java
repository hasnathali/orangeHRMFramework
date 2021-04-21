package com.ogarngesHRM.dataprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseReader {

	public Object[][] getMySqlData()  {
		
		Object data[][]=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load driver"+ e.getMessage());
		}
		/* jdbc:mysql://localhost:3306/sha
		 * localhost we may use ip address 3306 is port number & sha is database name
		 */
		/*
		String url = "jdbc:mysql://localhost:3306/sha?serverTimezone=UTC";
		String user = "root";
		String password = "Sha120";
		Connection connection = DriverManager.getConnection(url, user, password);
		*/
		ConfigDataBaseReader ConDataBase = new ConfigDataBaseReader();
		Connection connection= null;
		String query1 = "select admin_id,admin_pass, user_role, emp_name, user_name, user_pass from sha.user_info";
		String query2 = "select * from sha.logininfo";
		try
		{
			connection = ConDataBase.connectToSqlDatabase();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet ReSet = statement.executeQuery(query1);
			ReSet.last();
			int RowsCount = ReSet.getRow();
			System.out.println("Number of Rows" + RowsCount);
			ResultSetMetaData rsmd = ReSet.getMetaData();
			int columncount = rsmd.getColumnCount();
			System.out.println("number of Columns " + columncount);
			data = new Object[RowsCount][columncount];
			ReSet.beforeFirst();
			//using while loop
			int i = 0;
			while (ReSet.next()) {

				for (int j = 0; j < columncount; j++) {
					data[i][j] = ReSet.getString(j + 1);
				}
				i++;

			}
			
			connection.close();
			statement.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find the class" +e.getMessage());
		} catch (SQLException e) {
			System.out.println("Could not execute sql statement" +e.getMessage());
		}



		//using for loop
		/*
		for(int i=0;i<RowsCount;i++)
		{
			ResSet.next();
			for(int j=0;j<columncount;j++)
			{
				data[i][j]= ResSet.getString(j+1);
				System.out.prinlnt(data[i][j]+"  ");
			}
		}
		*/
		
		return data;
	}
}

