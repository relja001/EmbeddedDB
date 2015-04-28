
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zad;create=true";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("create table channels32(kolona1 varchar(20), kolona2 varchar(20))");
		connection.createStatement().execute("insert into channels32 values " +
											"('oodp', 'nesto u kolonu 2'),"
											+ "('oodp', 'nesto u kolonu 2'), "
											+ "('oodp', 'i tako dalje')");
	}
}
