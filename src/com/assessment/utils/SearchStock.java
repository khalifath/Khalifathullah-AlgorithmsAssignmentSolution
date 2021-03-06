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
				
		
				if(left>=right || mid>=right) {
					return -1;
				}
				isAvailble = false;
				
				if ((key>stock[left].getStockPrice() && key<stock[mid].getStockPrice()) || (key<stock[left].getStockPrice() && key>stock[mid].getStockPrice())) {
					right=mid;
					mid = (left+right)/2;
					isAvailble=true;
					if(right==mid && mid==left+1)
						isAvailble=false;
				}else if(key<stock[mid].getStockPrice() && key>stock[right].getStockPrice() ||(key<stock[mid].getStockPrice() && key<stock[right].getStockPrice())){
					left=mid;
					mid = (left+right)/2;
					isAvailble=true;
					if(left==mid && mid==right-1)
						isAvailble=false;
				}

				if(key==stock[left].getStockPrice()) return left;
				if(key==stock[mid].getStockPrice()) return mid;
				if(key==stock[right].getStockPrice()) return right;
				if (!isAvailble) {
					for (int i=0;i<stock.length;i++) {
					
						if(key==stock[i].getStockPrice()) {
							//System.out.println("Liner search...");
							return i;
						}
					}
					return -1;
				}
			
			}while(left<=right);

			return -1;
		}
}
