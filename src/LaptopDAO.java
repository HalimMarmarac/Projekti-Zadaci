import java.sql.*;
import java.util.*;

public class LaptopDAO implements LaptopInterface {

	// connect to the database
		Connection connection = ConnectionManager.getInstance().getConnection();

		@Override
		public ArrayList<Laptop> getLaptops() throws SQLException {
			// create an array list to hold laptops
			ArrayList<Laptop> laptops = new ArrayList<>();
			// create an SELECT SQL query
			String query = "SELECT * FROM laptops";
			// create a new ResultSet
			ResultSet rs = null;
			try (
			// java.sql.Statement
			Statement statement = connection.createStatement();) {
				// execute the query
				rs = statement.executeQuery(query);
				// add students to the arrayList
				while (rs.next()) {
					laptops.add(new Laptop(rs.getInt("ID"), rs.getString("Brand"), rs.getString("YearOm"), 
							rs.getInt("RAMuGB"), rs.getInt("HDDuGB"), rs.getString("CPU"), rs.getString("Display")));
				}

			}

			return laptops;
		}

		@Override
		public  ArrayList<Laptop> searchLaptop(String data) throws SQLException {
			// create an array list to hold laptops
			ArrayList<Laptop> laptops = new ArrayList<>();
			// create an SELECT SQL query
			String query = "SELECT * FROM laptops WHERE Brand LIKE '%"+data+"%' OR YearOm = '"+data+"' OR RAMuGB = '"+data+"'"
					+ "OR HDDuGB = '"+data+"' OR CPU LIKE '%"+data+"%' OR Display LIKE '%"+data+"%';";
			// create a new ResultSet
			ResultSet rs = null;

			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {
				// execute the query
				rs = statement.executeQuery();
				// set the cursor
				while (rs.next()) {
					laptops.add(new Laptop(rs.getInt("ID"), rs.getString("Brand"), rs.getString("YearOm"), 
							rs.getInt("RAMuGB"), rs.getInt("HDDuGB"), rs.getString("CPU"), rs.getString("Display")));
				}
			}

			return laptops;
		}

		@Override
		public void updateLaptop(int ID) throws SQLException {
			// create an SELECT SQL query
			String query = "UPDATE laptops SET RAMuGB = ?, HDDuGB = ? WHERE ID =" + ID;
			// new Scanner
			java.util.Scanner input = new java.util.Scanner(System.in);

			int RAM = 0;
			int HDD = 0;
			boolean q = true;
			while(q){
				System.out.print("Set a new amount of RAM: ");
				try {
					RAM = input.nextInt();
					q = !q;
				} catch (InputMismatchException e) {
					System.out.println("\nWrong input! Integers only!");
					input.nextLine();
				}
			}

			while(!q){
				System.out.print("Set a new HDD capacity: ");
				try {
					HDD = input.nextInt();
					q = !q;
				} catch (InputMismatchException e) {
					System.out.println("\nWrong input! Integers only!");
					input.nextLine();
				}
			}
			
			// close the scanner
			input.close();

			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {
				// fill in the placeholders/parameters
				statement.setInt(1, RAM);
				statement.setInt(2, HDD);
				// execute the query
				statement.executeUpdate();

				System.out.println("\nLaptop updated in the database.");
			}
		}

		@Override
		public void deleteLaptop(int ID) throws SQLException {
			// create an SELECT SQL query
			String query = "DELETE FROM laptops WHERE ID = " + ID;

			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {
				// execute the query
				statement.executeUpdate();

				System.out.println("\nLaptop deleted from the database.");
			}
		}

		@Override
		public void addLaptop() throws SQLException {
			// create an SELECT SQL query
			String query = "INSERT INTO laptops(Brand, YearOm, RAMuGB, HDDuGB, CPU, Display) VALUES (?, ?, ?, ?. ?. ?)";
			// new Scanner
			java.util.Scanner input = new java.util.Scanner(System.in);

			System.out.print("Enter laptop brand (e. HP, SONY, TOSHIBA, ACER...): ");
			String brand = input.next();

			System.out.print("Enter laptop year of manufacture (e. 2015): ");
			String yearom = input.next();

			int RAM = 0;
			int HDD = 0;
			boolean q = true;
			while(q){
				System.out.print("Enter laptop RAM (e. 4): ");
				try {
					RAM = input.nextInt();
					q = !q;
				} catch (InputMismatchException e) {
					System.out.println("\nWrong input! Integers only!");
					input.nextLine();
				}
			}

			while(!q){
				System.out.print("Enter laptop HDD (e. 500): ");
				try {
					HDD = input.nextInt();
					q = !q;
				} catch (InputMismatchException e) {
					System.out.println("\nWrong input! Integers only!");
					input.nextLine();
				}
			}
			
			System.out.print("Enter laptop CPU (e. INTEL DualCore, INTEL i3, i5, i7, AMD A6...): ");
			String CPU = input.next();
			
			System.out.print("Enter laptop display diagonal (e. 15,6): ");
			String display = input.next();

			// close the scanner
			input.close();
			
			try (
			// java.sql.Statement
			PreparedStatement statement = connection.prepareStatement(query);) {
				// fill in the placeholders/parameters
				statement.setString(1, brand);
				statement.setString(2, yearom);
				statement.setInt(3, RAM);
				statement.setInt(4, HDD);
				statement.setString(5, CPU);
				statement.setString(6, display);
				// execute the query
				statement.executeUpdate();

				System.out.println("\nLaptop added to the database.");
			}
		}

		@Override
		public void printLaptop(Laptop laptop) {
			if (laptop != null) {
				System.out.println("ID: " + laptop.getID() + ", brand: " + laptop.getBrand() 
						+ ", YearOm: " + laptop.getYearOm() + ", RAM: " + laptop.getRam()
						+ " GB, HDD: " + laptop.getHdd() + " GB, CPU: " + laptop.getCpu()
						+ ", display: " + laptop.getDisplay());
			} else {
				System.out.println("\nNo data to print.");
			}
		}

}
