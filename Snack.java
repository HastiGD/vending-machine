package lab2;

public class Snack {
	private String snackType; 
	private double snackCost;
	private int snackInventory;
	
	public Snack( String snack, double cost, int inventory) {
		snackType = snack;
		snackCost = cost;
		snackInventory = inventory;
	}
	
	public String getType() {
		// method returns name
		return snackType;
	}
	
	public double getCost() {
		// method returns cost
		return snackCost;
	}
	
	public int getInventory() {
		// method returns stock
		return snackInventory;
	}
	
	public void decrementInventory() {
		// method decrements stock
		snackInventory--;
	}

	@Override
	  public String toString() {
	    return snackType;   
	}
	
	public static void main(String[] args) {
		Snack mySnack = new Snack("Potato Chips", 1.25, 10);
		System.out.println(mySnack.getType());	
	}
}
