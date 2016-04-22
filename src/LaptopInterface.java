import java.sql.SQLException;
import java.util.ArrayList;

public interface LaptopInterface {

	public ArrayList<Laptop> getLaptops() throws SQLException;
	public  ArrayList<Laptop> searchLaptop(String data) throws SQLException;
	public void updateLaptop(int ID) throws SQLException;
	public void deleteLaptop(int ID) throws SQLException;
	public void addLaptop() throws SQLException;
	public void printLaptop(Laptop laptop);
}
