package com.assessment.utils;
import com.assessment.stock.Stock;

public class SortStock {

	public  void SortStockPrice(Stock stock[],boolean bAcending) {
		Stock temp=null;
		int offset=stock.length-1;

		do
		{
			if(bAcending)
			{
				for(int i=0;i<offset;i++) {
					if (stock[i].getStockPrice()>stock[i+1].getStockPrice()) {
						temp=stock[i];
						stock[i]=stock[i+1];
						stock[i+1]=temp;
					}
				}
			}
			else
			{
				for(int i=0;i<offset;i++) {
					if (stock[i].getStockPrice()<stock[i+1].getStockPrice()) {
						temp=stock[i];
						stock[i]=stock[i+1];
						stock[i+1]=temp;
					}
				}
			}
			offset--;
		}while(offset>0);
	}
}
