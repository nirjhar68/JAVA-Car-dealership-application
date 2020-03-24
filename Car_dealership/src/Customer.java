import java.util.*;
public class Customer {
	//Create the attributes of Customer class
	private String custName;
	private String custAddress;
	private double cashOnHand;
	static Scanner scanner =new Scanner(System.in);
	
	//Here we have to define a method that returns nothing and implements the purchase of a vehicle by the customers
	//This method will accept a Vehicle object, an Employee object(sold by the employee) and a boolean object that indicates if the 
	//vehicle was financed or not.
	public void purchaseCar(Vehicle vehicleName, Employee employee, boolean financed){
		
		
		if(financed == true) {
			System.out.println("The car is sold! Congratulations!");
			System.out.println("The Sales Reresentative information:\n"
					+ employee.getEmployeeName());
			System.out.println("The vehicle information is:\n"
					+"Make " + vehicleName.getMake() + "\nModel: " + vehicleName.getModel() + "\nColor: " + vehicleName.getColor()
					+ "\nPrice: $" + vehicleName.getPrice());
			double hst = (vehicleName.getPrice() * 1.13) - vehicleName.getPrice();
			double totalPrice = vehicleName.getPrice() * 1.13;
			System.out.println("HST: $" + hst );
			System.out.println("Total price: $" + totalPrice);
			System.out.println("Total financed amount: $" + totalPrice);
			
		}
		else {
			//boolean flag = financed;
			System.out.println("How much do you want to put down?");
			double downPayment = scanner.nextDouble();
			System.out.println("The car is sold! Congratulations!");
			System.out.println("The Sales Reresentative information:\n"
					+ employee.getEmployeeName());
			System.out.println("The vehicle information is:\n"
					+"Make " + vehicleName.getMake() + "\nModel: " + vehicleName.getModel() + "\nColor: " + vehicleName.getColor()
					+ "\nPrice: $" + vehicleName.getPrice());	
			double hst = (vehicleName.getPrice() * 1.13) - vehicleName.getPrice();
			double totalPrice = vehicleName.getPrice() * 1.13;
			System.out.println("HST: $" + hst );
			System.out.println("Total price: $" + totalPrice);
			System.out.println("Down payment: $" + downPayment);
			System.out.println("Total financed amount: $" + (totalPrice - downPayment));
		}
	}
	
	public void setCustName(String s) {
		this.custName = s;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustAddress(String s) {
		this.custAddress = s;
	}
	
	public String getCustAddress() {
		return custAddress;
	}

	public double getCashOnHand() {
		return cashOnHand;
	}

	public void setCashOnHand(double cashOnHand) {
		this.cashOnHand = cashOnHand;
	}
	
	
}
