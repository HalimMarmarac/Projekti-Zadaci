
public class Laptop {
	
	// data fields
		private int ID;
		private String brand;
		private String yearom;
		private int ram;
		private int hdd;
		private String cpu;
		private String display;

		// constructor
		Laptop(int ID, String brand, String yearom, int ram, int hdd, String cpu, String display) {
			this.ID = ID;
			this.brand = brand;
			this.yearom = yearom;
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
			this.display = display;
		}

		// getters
		public int getID() {
			return ID;
		}

		public String getBrand() {
			return brand;
		}

		public String getYearOm() {
			return yearom;
		}

		public int getRam() {
			return ram;
		}

		public int getHdd() {
			return hdd;
		}
		
		public String getCpu() {
			return cpu;
		}
		
		public String getDisplay() {
			return display;
		}

}
