package com.assessment.utils;

import com.assessment.stock.*;

public class SearchStock {

	public int SearchStockPrice(Stock stock[],double key) {

		int left=0;
		int right=stock.length-1;
		int mid=(left+right)/2;
		boolean isAvailble=false;

		do
		{
			if(left>right || mid>right) {
				return -1;
			}
			
			if(key==stock[left].getStockPrice()) return left;
			if(key==stock[mid].getStockPrice()) return mid;
			if(key==stock[right].getStockPrice()) return right;
		
			if ((key>stock[left].getStockPrice() && key<stock[mid].getStockPrice()) || (key<stock[left].getStockPrice() && key>stock[mid].getStockPrice())) {
				right=mid;
				mid = (left+right)/2;
				isAvailble=true;
			}else if(key<stock[mid].getStockPrice() && key>stock[right].getStockPrice() ||(key<stock[mid].getStockPrice() && key<stock[right].getStockPrice())){
				left=mid;
				mid = (left+right)/2;
				isAvailble=true;
			}
			
			if (!isAvailble) {
				for (int i=0;i<stock.length;i++) {
					if(key==stock[i].getStockPrice()) return i;
				}
				return -1;
			}
				

		}while(left<=right);

		return -1;
	}
}
