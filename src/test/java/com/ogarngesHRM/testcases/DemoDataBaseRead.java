package com.ogarngesHRM.testcases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.ogarngesHRM.base.BaseClass;



public class DemoDataBaseRead extends BaseClass {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		/* jdbc:mysql://localhost:3306/sha
		 * localhost we may use ip address 3306 is port number & sha is database name
		 */
		//I 
		//String url = "jdbc:mysql://localhost:3306/sha?serverTimezone=UTC";
		String url = "jdbc:mysql://localhost:3306/sha";
		String user = "root";
		String password = "Sha120";

		//String query2 = "select * from sha.logininfo";
		String query2 = "select * from sha.user_info";

		Connection connection = DriverManager.getConnection(url, user, password);

		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet ResSet = statement.executeQuery(query2);

		ResSet.last();

		int RowCount = ResSet.getRow();
		System.out.println("Number of Rows" + RowCount);

		ResultSetMetaData rsmd = ResSet.getMetaData();

		int Columncount = rsmd.getColumnCount();
		System.out.println("number of Columns " + Columncount);

		Object data[][] = new String[RowCount][Columncount];
		ResSet.beforeFirst();
		
		
		//
		for(int i=0;i<RowCount;i++)
		{
			ResSet.next();
			for(int j=0;j<Columncount;j++)
			{
				data[i][j]= ResSet.getString(j+1);
				System.out.print(data[i][j]+"  ");
			}
			System.out.println();
		}
		//*/
		/*
		int i = 0;
		while (ResSet.next()) {

			for (int j = 0; j < Columncount; j++) {
				data[i][j] = ResSet.getString(j + 1);
			}
			i++;

		}
		*/

		connection.close();
		statement.close();

	//	return data;	
		
	}//End Main
	
}//End Class
