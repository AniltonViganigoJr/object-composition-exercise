package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name:");
		String departmentName = sc.nextLine();
		System.out.println("\n*Enter worker data*");
		System.out.print("Name:");
		String workerName = sc.nextLine();
		System.out.print("Worker Level (J/M/S):");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary:");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.workerLevelType(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("\nHow many contracts to this worker?");
		int contractsQuantity = sc.nextInt();
		
		for (int i = 0; i < contractsQuantity; i++) {
			System.out.printf("Enter contract #%d data:",i+1);
			System.out.print("\nDate (DD/MM/YYYY):");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(hours):");
			int hours = sc.nextInt();
			
			worker.addContract(new HourContract(contractDate, valuePerHour, hours));
		}
	
		System.out.print("\nEnter month and year to calculate income (MM/YYYY):");
		sc.nextLine();
		String monthAndYear = sc.nextLine();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name:" + worker.getName());
		System.out.println("Worker Level:" + worker.getLevel());
		System.out.println("Department:" + worker.getDepartment().getName());
		System.out.printf("Income for " + monthAndYear + ": $" + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}