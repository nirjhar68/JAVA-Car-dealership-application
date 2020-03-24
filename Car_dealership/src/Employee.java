import java.util.*;
public class Employee {
	private String employeeName;
	private String employeeId;
	/*
	 * In this class we are going to have a public void method like handleCustomer. This method will accept a customer object,
	 * a boolean object that will indicate whether the vehicle was financed or not and a vehicle object.
	 * ***If the vehicle was financed, then there will be another method that is called runCreditCheck. This method will
	 * accept a customer object and double object that indicates the loanAmount. The loanAmount will be the difference between the 
	 * vehicle price and the cashOnHand of that customer.
	 * ***Else when the vehicle was not financed, the processTransaction method will be implemented. Which accepts a customer and a 
	 * vehicle the customer wanted to purchase.
	 * Try to encapsulate the data by the class type.  */
	
	public void handleCustomer(Customer cust, Vehicle vecl,  boolean financed){
		System.out.println("*********************");
		
		if(financed == true) {
			double financedAmount = 0;
			String approval = null;
			double totalPrice = vecl.getPrice() * 1.13;
			financedAmount = totalPrice;
		
			System.out.println("Wait for approval...");
			approval = runCreditCheck(cust, vecl);
			if(approval.equalsIgnoreCase("Approved")) {
				System.out.println(approval + "\nCustomer name: " + cust.getCustName() + "\nMake: " + vecl.getMake() + "\nModel: " + vecl.getModel()
				+ "\nColor: " + vecl.getColor() + "\nPrice: " + vecl.getPrice() + "\nTotal Price with 13% HST: " + totalPrice
				+ "\nFinanced Amount: " + financedAmount);
			}
			else if(approval.equalsIgnoreCase("Not Approved")) {
				double upfront = 0.0;
				upfront = vecl.getPrice() * 0.10;
				System.out.println("10% Down payment required. Upfornt amount: " + upfront);
			}
			
		}
		else if (financed ==  false) {
			double downPayment, balance,totalPrice = 0.0;
			double hst = 1.13;
			totalPrice = vecl.getPrice() * hst;
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nCustomer name: " + cust.getCustName() + "\nMake: " + vecl.getMake() + "\nModel: " + vecl.getModel()
				+ "\nColor: " + vecl.getColor() + "\nPrice: " + vecl.getPrice() + "\nTotal Price with 13% HST: " + totalPrice);
			
			System.out.println("How much would you like to put down? ");
			downPayment = scanner.nextDouble();
			scanner.close();
			balance = totalPrice - downPayment;
			System.out.println("***********************\n" + "Customer name: " + cust.getCustName() 
				+ "\nMake: " + vecl.getMake() + "\nModel: " + vecl.getModel()
				+ "\nColor: " + vecl.getColor() + "\nPrice: " + vecl.getPrice() 
				+ "\nTotal Price with 13% HST: " + totalPrice + "\nDown payment: " + downPayment + "\nBalance: " + balance);
			}
		
	}
	
	public String runCreditCheck(Customer cust, Vehicle vecl) {		
		String approval = null;
		if(vecl.getPrice() <= cust.getCashOnHand()) {
			approval = "Approved";
		}
		else if (vecl.getPrice() > cust.getCashOnHand()) {
			approval = null;
			approval = "Not Approved";			
		}
		return approval;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setEmployeeId(String id) {
		this.employeeId = id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
}
