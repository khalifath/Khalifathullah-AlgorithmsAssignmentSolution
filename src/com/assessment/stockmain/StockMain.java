package com.assessment.stockmain;

import com.assessment.stockdetails.StockDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StockMain {

	static StockDetails stockDetails= new StockDetails();
	static Scanner sc = new Scanner(System.in);


	public static void main (String args[]) {
		double stockprice=0;
		boolean isPriceUp=false;
		boolean flag=true;

		try {		
			System.out.println("enter the no of companies ");
			int MaxCompanies = sc.nextInt();
			stockDetails.setMaxCompanyCount(MaxCompanies);
			for(int i=0;i< MaxCompanies;i++) {
				int count=i+1;
				System.out.println("Enter current stock price of the company " + count);
				stockprice = sc.nextDouble();
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				isPriceUp = sc.nextBoolean();

				stockDetails.setStockDetails(i, stockprice, isPriceUp);
			}

			do {


				System.out.println("\r\n"
						+ "-----------------------------------------------\r\n"
						+ "Enter the operation that you want to perform\r\n"
						+ "1. Display the companies stock prices in ascending order\r\n"
						+ "2. Display the companies stock prices in descending order\r\n"
						+ "3. Display the total no of companies for which stock prices rose today\r\n"
						+ "4. Display the total no of companies for which stock prices declined today\r\n"
						+ "5. Search a specific stock price\r\n"
						+ "6. press 0 to exit\r\n"
						+ "-----------------------------------------------");

				int menuOption=sc.nextInt();

				switch (menuOption) {
				case 1:
					stockDetails.stockPriceAcending(stockDetails.getStockCompanies());
					stockDetails.printStockPrice();
					break;
				case 2:
					stockDetails.stockPriceDecending(stockDetails.getStockCompanies());
					stockDetails.printStockPrice();
					break;
				case 3:
					System.out.println("Total no of companies whose stock price rose today :" + stockDetails.getPriceRoseCounter());
					break;
				case 4:
					System.out.println("Total no of companies whose stock price declined today :" + stockDetails.getPriceDeclineCounter());
					break;
				case 5:
					System.out.println("enter the key value ");
					stockprice = sc.nextDouble();
					if(-1!=stockDetails.findStockPrice(stockDetails.getStockCompanies(), stockprice)) {
						System.out.println("Stock of value " + stockprice + " is present");
					}
					else {
						System.out.println("Value not found");
					}
					break;
				case 0:
					flag=false;
					System.out.println("Exited successfully");
					break;
				default:
					System.out.println("Invalid Input.. ");
					break;
				}
			}while (flag==true);

		}catch (InputMismatchException e) {
			System.out.println("Invalid option... Please re-execute the program, exiting!!! "); 
			//e.printStackTrace();
			sc.close();
			System.exit(0);
		}
		sc.close();
	}
}
