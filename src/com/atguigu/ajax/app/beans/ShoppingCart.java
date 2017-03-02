package com.atguigu.ajax.app.beans;

import java.util.HashMap;
import java.util.Map;

//购物车类：
public class ShoppingCart {
	
	//存放ShoppingCartItem的Map，键：书名  值：ShoppingCartItem对象
	private Map<String, ShoppingCartItem> items = new HashMap<>(); 
	
	private String bookName;
	
	//添加书到购物车中的方法：
	public void addToCart(String bookName,int price){
		
		this.bookName=bookName;
		
		if(items.containsKey(bookName)){
			ShoppingCartItem item = items.get(bookName);
			item.setNumber(item.getNumber()+1);
		}else {
			ShoppingCartItem item = new ShoppingCartItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
			
			items.put(bookName, item);
		}
	}
	//总的书的数量：
	public int getTotalBookNumber(){
		int total = 0;
		
		for(ShoppingCartItem item :items.values()){
			total +=item.getNumber();
		}
		return total;
	}
	//书的名字：
	public String getBookName() {
		return bookName;
	}
	
	//总的书的价格：
	public int getTotalMoney(){
		int money = 0;
		
		for(ShoppingCartItem item:items.values()){
			money +=item.getNumber()*item.getPrice();
		}
		
		return money;
	}
}
