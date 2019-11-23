package lab2;
import java.util.*;
import java.text.DecimalFormat;

public class VendingMachine {
	// create the snack objects sold by VM
	private Snack Chips = new Snack("Chips", 1.50, 3);
	private Snack Candy = new Snack("Candy", 0.95, 2);
	private Snack Cookies = new Snack("Cookies", 1.25, 10);
	private int snackTypes;
	private int selection = -1;
	private List<Integer> numCoins = new ArrayList<>();
	
	// create an array of Snack objects sold by this vm
	List<Snack> vmSnacks = new ArrayList<Snack>(); {
		vmSnacks.add(Chips);
		vmSnacks.add(Candy);
		vmSnacks.add(Cookies);
	}
			
	// create the scanner object
	Scanner sc = new Scanner(System.in);
	
	// create a decimal format object
	DecimalFormat df = new DecimalFormat("#.00");
	
	public VendingMachine(int numSnackTypes) {
		snackTypes = numSnackTypes;
	}

	public void displayMenu() {
		// generate a menu for items sold by the VM
		for (int i = 0; i < snackTypes; i++) {
			System.out.println("\nFor "+ vmSnacks.get(i) + " Press " + i);
		}
		// make selection
		selection = sc.nextInt();
		System.out.println("You Have Selected " + vmSnacks.get(selection));
	}
	
	public void acceptPayment() {
		// ask for num quarters, and add to array numCoins
		System.out.println("Please Enter the Number of Quarters You would like to Spend");
		int numQuarters = sc.nextInt();
		numCoins.add(numQuarters);
		// repeat for nickles
		System.out.println("Please Enter the Number of Nickles You would like to Spend");
		int numNickles = sc.nextInt();
		numCoins.add(numNickles);
		// repeat for dimes
		System.out.println("Please Enter the Number of Dimes You would like to Spend");
		int numDimes = sc.nextInt();
		numCoins.add(numDimes);
		
		// confirm payment amount
		System.out.println("You Have Inserted " + numCoins.get(0) + " Quarters, " + numCoins.get(1) + 
				" Nickles, and " +numCoins.get(2) + " Dimes\n");
	}
	
	public void checkFunds() {
		double dollarAmt = 0;
		// convert number of coins into dollars
		double sumQuarters = (numCoins.get(0))*(0.25);
		dollarAmt = dollarAmt + sumQuarters;
		double sumNickles = (numCoins.get(1))*(0.05);
		dollarAmt = dollarAmt +sumNickles;
		double sumDimes = (numCoins.get(2))*(0.10);
		dollarAmt = dollarAmt + sumDimes;
		
		// confirm dollar amt
		System.out.println("\nYou Have $" + df.format(dollarAmt));
		
		// get cost from snack object and display
		double cost = vmSnacks.get(selection).getCost();
		System.out.println("\nYour " + vmSnacks.get(selection).getType() + " Cost $" + df.format(cost));
		
		// validate sufficient funds
		if (dollarAmt < cost) {
			System.out.println("Insufficient Funds");
		}
		// check stock of snack if funds are sufficient
		if (dollarAmt >= cost) {
			checkStock(vmSnacks.get(selection), dollarAmt, cost);
		}
	}
	
	public void checkStock(Snack item, double tender, double cost) {
		// get current stock from Snack obj
		int currentStock = item.getInventory();
		// dispense snack and change if in stock
		if (currentStock > 0) {
			dispenseSnack(item);
			dispenseChange(tender, cost);
		}
		// dispense money if out of stock
		else {
			System.out.println("This Vending Machine is Out of " + item.getType());
			dispenseChange(tender, 0);
		}
	}
	
	public void dispenseSnack(Snack item) {
		// decrement and dispense
		item.decrementInventory();
		System.out.println("\nEnjoy Your " + item.getType() + "!");
		//System.out.println(item.getInventory() + " " + item.getType() + " Are Left.");
	}
	
	public void dispenseChange(double tender, double cost) {
		// calculate and return change
		double change = (tender - cost);
		System.out.println("\nDon't Forget your change!\nYour Change is $" + df.format(change));
	}
	
	public void keepVending() {
		
		boolean keepVending = true;
		int userCmnd;
		
		while (keepVending) {
			this.acceptPayment();
			this.displayMenu();
			this.checkFunds();
			
			// ask buyer if they would like to keep vending
			System.out.println("\nWould You Like to Keep Vending?"
					+ "\nTo Stop Vending Press 0\nTo Continue Vending Press 1");
			userCmnd = sc.nextInt();
			// end program if user doesn't want to continue vending
			if (userCmnd == 0) {
				keepVending = false;
				endProgram();
			}
			// if user wants to continue vending reset selection field to -1
			else {
				selection = -1;
			// empty contents of List<Integer> numCoins
				numCoins.clear();
				keepVending = true;
			}	
		}
	}
	
	public void endProgram() {
		System.out.println("\nGoodbye!");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		VendingMachine myVM = new VendingMachine(3);
		myVM.keepVending();

		// ask buyer for money
		// display snack menu
		// ask buyer for choice
		// check cash amount
			// if buyer is short
				// notify buyer they are short
				// display their options
		// if buyer provided enough cash
			// check stock 
				// if snack is stocked
					// dispense snack
					// give change where applicable
				// if snack is sold out
					// notify buyer to make another choice
		
	}

}
