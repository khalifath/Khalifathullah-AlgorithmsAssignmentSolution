package com.assessment.stock;

public class Stock {
	private double stockPrice=0;
	private boolean isPriceUp = false;
	
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public boolean isPriceUp() {
		return isPriceUp;
	}
	public void setPriceUp(boolean isPriceUp) {
		this.isPriceUp = isPriceUp;
	}
}
