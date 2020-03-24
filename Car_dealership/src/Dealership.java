/*This Project is based on the project on udemy by the instructor Imtiaz.  Thanks to him for the project idea.
Write a program to simulate a car "dealership" sales process. We'll have "employee"s working and selling "vehicles" to "customer"s
 * */
import java.util.*;

public class Dealership {
	
	public static void main(String[] args) {
		
		int manue = 0;
		boolean flag = false;
		Scanner input = new Scanner(System.in);
		//Create an instance of Customer
		Customer cust = new Customer();
		//Create the Employee object
		Employee emp = new Employee();
		//Create the Vehicle object
		Vehicle car = new Vehicle();
		car.setMake("Hyundai Sonata GL");
		car.setModel(2015);
		car.setColor("Silver");
		car.setPrice(35000.00);
		
		System.out.println("Welcome to purchase your new car!!");
		
		do {
		System.out.println("1. Process a car sell" + "\n2. Show sold car information" + "\n3.Exit");
		if(input.hasNextInt()) {
			manue = input.nextInt();
			flag = true;
		}else {
			System.out.println("Choose from the list. 1 or 2");
			input.next();
		}
		}while(!flag);
		
		switch(manue) {
		case 1:
			boolean financedCar = false;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Sales Representative's name and ID ");
			String empName = scanner.nextLine();
			String empId = scanner.nextLine();
			emp.setEmployeeName(empName);
			emp.setEmployeeId(empId);
			
			System.out.println("Enter the customer information");
			String cName = scanner.nextLine();
			String cAddress = scanner.nextLine();
			double cCash = scanner.nextDouble();
			cust.setCustName(cName);
			cust.setCustAddress(cAddress);
			cust.setCashOnHand(cCash);
			System.out.println("Is the vehicle financed? Y/N");
			do {
			if(scanner.hasNext("y") || scanner.hasNext("Y")) {
				financedCar = true;
				cust.purchaseCar(car, emp, true);
			}
			else if(scanner.hasNext("n") || scanner.hasNext("N")) {
				financedCar = true;
				cust.purchaseCar(car, emp, false);
			}
			else {
				System.out.println("Please type Y or N");
				financedCar = false;
				scanner.next();
				}
			}
			while(!financedCar);
			
			break;
		case 2: 
			Scanner scanner1 = new Scanner(System.in);		
			System.out.println("Enter the customer information");
			String cName1 = scanner1.nextLine();
			String cAddress1 = scanner1.nextLine();
			double cCash1 = scanner1.nextDouble();
			cust.setCustName(cName1);
			cust.setCustAddress(cAddress1);
			cust.setCashOnHand(cCash1);
			
			System.out.println("Is the vehicle financed? Y/N");
			do {
				if(scanner1.hasNext("Y") || scanner1.hasNext("y")) {
					financedCar = true;
					emp.handleCustomer(cust, car, true);
				}
				else if(scanner1.hasNext("n") || scanner1.hasNext("N")) {
					financedCar = true;
					emp.handleCustomer(cust, car, false);
				}
				else {
					financedCar = false;
					System.out.println("Please enter y/n");
					scanner1.next();					
				}
				
			}
			while(!financedCar);
			break;
		case 3: 
			System.out.println("Have a wonderful day!");
			break;
		default:
			System.out.println("Hummm! It's okay. Have a nice day!!");
			break;
		}
	}

}
