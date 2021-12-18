package com.assessment.stockdetails;

import com.assessment.stock.*;
import com.assessment.utils.*;


public class StockDetails{

	Stock Stock[];
	SortStock sortStock = new SortStock();
	SearchStock searchStock = new SearchStock();
	int maxCompanyCount;
	int priceRoseCounter=0;
	int priceDeclineCounter=0;

	public Stock[] getStockCompanies() {
		return Stock;
	}

	public void setPriceStatusCounter(boolean bRose) {
		if(bRose)this.priceRoseCounter++;
		else this.priceDeclineCounter++;
	}

	public int getPriceRoseCounter() {
		return priceRoseCounter;
	}

	public int getPriceDeclineCounter() {
		return priceDeclineCounter;
	}


	public void setStockCompanies(int maxCompanyCount) {
		this.Stock = new Stock[maxCompanyCount];
	}


	public int getMaxCompanyCount() {
		return maxCompanyCount;
	}


	public void setMaxCompanyCount(int maxCompanyCount) {
		this.maxCompanyCount = maxCompanyCount;
		setStockCompanies(this.maxCompanyCount);	
	}


	public void setStockDetails(int index, double stockPrice, boolean isUp) {
		if(index>this.maxCompanyCount)
			System.out.println("Max Companies reached, no furhter input is encouraged");

		Stock[index] = new Stock();
		Stock[index].setStockPrice(stockPrice);
		Stock[index].setPriceUp(isUp);
		setPriceStatusCounter(isUp);
	}

	public void getStockDetails() {

		for (int i=0;i<Stock.length;i++) {

			System.out.println("Stok Price : " + Stock[i].getStockPrice() + " Stock Price Increaed Today ? : " + Stock[i].isPriceUp());
		}
	}

	public void stockPriceAcending(Stock stocks[]) {
		this.sortStock.SortStockPrice(stocks, true);
	}

	public void stockPriceDecending(Stock stocks[]) {
		this.sortStock.SortStockPrice(stocks, false);	
	}

	public int findStockPrice (Stock stocks[],double price) {
		return searchStock.SearchStockPrice(stocks, price);
	}

	public void printStockPrice() {
		System.out.println("");
		for(int i=0;i<Stock.length;i++) {
			System.out.print(Stock[i].getStockPrice()+" ");
		}
		System.out.println("");
	}

}
