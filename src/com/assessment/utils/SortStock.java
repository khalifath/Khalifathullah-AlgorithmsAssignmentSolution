package com.assessment.utils;
import com.assessment.stock.Stock;

public class SortStock {

	public  void SortStockPrice(Stock stock[],boolean bAcending) {
		double temp=0;
		int offset=stock.length-1;

		do
		{
			if(bAcending)
			{
				for(int i=0;i<offset;i++) {
					if (stock[i].getStockPrice()>stock[i+1].getStockPrice()) {
						temp=stock[i].getStockPrice();
						stock[i].setStockPrice(stock[i+1].getStockPrice());
						stock[i+1].setStockPrice(temp);
					}
				}
			}
			else
			{
				for(int i=0;i<offset;i++) {
					if (stock[i].getStockPrice()<stock[i+1].getStockPrice()) {
						temp=stock[i].getStockPrice();
						stock[i].setStockPrice(stock[i+1].getStockPrice());
						stock[i+1].setStockPrice(temp);
					}
				}
			}
			offset--;
		}while(offset>0);
	}
}
