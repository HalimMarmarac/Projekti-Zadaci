import java.sql.*;

public class InsertIntoTable {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "0000"; // my password
	private static final String CONN_STRING = "jdbc:mysql://localhost/laptopstore";

	public static void main(String[] args) throws SQLException {

		String query = "INSERT INTO laptops VALUES(1, 'HP', '2014', '4', '500', 'INTEL DualCore', '15,6'),"
												+ "(2, 'TOSHIBA', '2013', '4', '320', 'INTEL i3', '15,6'),"
												+ "(3, 'ACER', '2014', '8', '1000', 'AMD A6', '15,6'),"
												+ "(4, 'SONY', '2015', '16', '1000', 'INTEL i7', '17'),"
												+ "(5, 'HP', '2016', '8', '500', 'INTEL i5', '15,6'),"
												+ "(6, 'ACER', '2016', '8', '500', 'AMD A6', '15,6'),"
												+ "(7, 'HP', '2016', '8', '750', 'INTEL i5', '15,6'),"
												+ "(8, 'TOSHIBA', '2015', '4', '500', 'INTEL i5', '15,6'),"
												+ "(9, 'DELL', '2014', '4', '500', 'INTEL DualCore', '15,6'),"
												+ "(10, 'SAMSUNG', '2015', '8', '500', 'INTEL i3', '15,6'),"
												+ "(11, 'TOSHIBA', '2014', '4', '500', 'INTEL i5', '15,6'),"
												+ "(12, 'HP', '2012', '4', '250', 'INTEL DualCore', '15,4')";

		try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(query);
			System.out.println("Successfully updated the table.");
		}
	}
}
