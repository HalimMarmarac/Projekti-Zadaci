import java.sql.*;

public class CreateTable {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "0000"; // my password
	private static final String CONN_STRING = "jdbc:mysql://localhost/laptopstore";

	public static void main(String[] args) throws SQLException {

		String query = "CREATE TABLE laptops (ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, Brand VARCHAR(70),"
				+ "YearOm VARCHAR(4), RAMuGB INTEGER, HDDuGB INTEGER, CPU VARCHAR(30), Display VARCHAR(10));";

		try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
			System.out.println("Successfully created table.");
		}
	}
}