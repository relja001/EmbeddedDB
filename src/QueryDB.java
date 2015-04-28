

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDB {
	public static final String SQL_STATEMENT = "select * from channels32";
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(CreateDB.JDBC_URL);
		Statement statement = con.createStatement();
		ResultSet rSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = rSet.getMetaData();
		
		int columnCount = resultSetMetaData.getColumnCount();
		
		for (int x = 1; x <= columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+" | ");
		while (rSet.next()){
			System.out.println();
			for (int x = 1; x <= columnCount; x++) System.out.format("%20s", rSet.getString(x) + " | ");
		}
		if (statement != null) statement.close();
		if (con !=null) con.close();
	}
}