import java.sql.*;
import java.util.*;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		
		LaptopDAO laptopDAO = new LaptopDAO();
		
		Scanner in = new Scanner(System.in);
		int choice = -1;
		boolean q = true;
		
		System.out.println("-> 1. Admin");
		System.out.println("-> 2. User");
		System.out.println("-> 0. Close");
		System.out.println("\n-> ");
		
		while(q) {
			try {
				choice = in.nextInt();
				while(choice < 0 || choice > 2) {
					System.out.println("\nChoice doesn't exist!\n");
					System.out.println("-> 1. Admin");
					System.out.println("-> 2. User");
					System.out.println("-> 0. Close");
					System.out.println("\n-> ");
					choice = in.nextInt();
				}
				q = !q;
			} catch (InputMismatchException e) {
			System.out.println("\nWrong input! Integers only!");
			in.nextLine();
			}
		}
		
		if(choice == 0) System.exit(0);
		
		else if(choice == 1) {
			
			System.out.println("\n-> 1. Show all products");
			System.out.println("-> 2. Search");
			System.out.println("-> 3. Add");
			System.out.println("-> 4. Remove");
			System.out.println("-> 5. Update/Change");
			System.out.println("-> 0. Close");
			System.out.println("\n-> ");
			
			q = !q;
			while(q) {
				try {
					choice = in.nextInt();
					while(choice < 0 || choice > 5) {
						System.out.println("\nChoice doesn't exist!\n");
						System.out.println("-> 1. Show all products");
						System.out.println("-> 2. Search");
						System.out.println("-> 3. Add");
						System.out.println("-> 4. Remove");
						System.out.println("-> 5. Update/Change");
						System.out.println("-> 0. Close");
						System.out.println("\n-> ");
						choice = in.nextInt();
					}
					q = !q;
				} catch (InputMismatchException e) {
				System.out.println("\nWrong input! Integers only!");
				in.nextLine();
				}				
			}
			
			if(choice == 0) System.exit(1);
			
			else if(choice == 1) {
				//get all products
				ArrayList<Laptop> laptops = laptopDAO.getLaptops();
				//print all
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
				
			} else if(choice == 2) {
				System.out.println("\nO- you can search laptops by: brand name, year of manufacture, amount of RAM, \nHDD capacity, "
						+ "CPU brand/model and/or display diagonal -O\n");
				System.out.println("Search -> ");
				String data = in.next();
				ArrayList<Laptop> laptops = laptopDAO.searchLaptop(data);
				//print results
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
				
			} else if(choice == 3) {
				laptopDAO.addLaptop();
				
			} else if(choice == 4) {
				//get all products
				ArrayList<Laptop> laptops = laptopDAO.getLaptops();
				//print all
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
				
				System.out.println("\nEnter laptop ID that you want to delete: ");
				int ID = in.nextInt();
				laptopDAO.deleteLaptop(ID);
				
			} else if(choice == 5) {
				//get all products
				ArrayList<Laptop> laptops = laptopDAO.getLaptops();
				//print all
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
				
				System.out.println("\nEnter laptop ID that you want to update/change: ");
				int ID = in.nextInt();
				laptopDAO.updateLaptop(ID);
			}
			
		} else if(choice == 2) {
			
			System.out.println("\n-> 1. Show all products");
			System.out.println("-> 2. Search");
			System.out.println("-> 0. Close");
			System.out.println("\n-> ");
			
			q = !q;
			while(q) {
				try {
					choice = in.nextInt();
					while(choice < 0 || choice > 2) {
						System.out.println("\nChoice doesn't exist!\n");
						System.out.println("-> 1. Show all products");
						System.out.println("-> 2. Search");
						System.out.println("-> 0. Close");
						System.out.println("\n-> ");
						choice = in.nextInt();
					}
					q = !q;
				} catch (InputMismatchException e) {
				System.out.println("\nWrong input! Integers only!");
				in.nextLine();
				}				
			}
			
			if(choice == 0) System.exit(2);
			
			else if(choice == 1) {
				//get all products
				ArrayList<Laptop> laptops = laptopDAO.getLaptops();
				//print all
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
				
			} else if(choice == 2) {
				System.out.println("\nO- you can search laptops by: brand name, year of manufacture, amount of RAM, \nHDD capacity, "
						+ "CPU brand/model and/or display diagonal -O\n");
				System.out.println("Search -> ");
				String data = in.next();
				ArrayList<Laptop> laptops = laptopDAO.searchLaptop(data);
				//print results
				for (Laptop e : laptops) {
					laptopDAO.printLaptop(e);
				}
			}
		}

		in.close();
	}

}
