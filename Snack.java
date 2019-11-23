package lab2;

/*
 * The objects of the type Snack will have a type, i.e. Cookie, Candy, Chips, they will have an
 * associated cost, as well as an initial quantity. The constructor takes 3 arguments specifying
 * the type, cost, and stock of that particular Snack Object.
 */

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
	}
}
