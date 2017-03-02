package com.atguigu.ajax.app.test;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 该类用于测试：Jackson 工具：将一个对象或者集合转换为一个JSON字符串
 * @author john
 *
 */
public class Customer {
	
	private String name;
	private String id;
	
	public String getCustomerName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getCity(){
		return "BeiJing";
	}
	@JsonIgnore //(忽略该getter对应的JSON属性)
	public String getBirth(){
		return "1990-12-12";
	}
	
	
	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	//测试如何使用jackson框架作用：1.将对象转换为JSON字符串；2.将一个集合转换为JSON字符串
	public static void main(String[] args) throws JsonProcessingException {
		
		//使用Jackson步骤：
		//1.导入jar包
		//2.创建ObjectMappter对象：此例中不应该使用：com.fasterxml.jackson.databind.ObjectMapper创建，
		//而应该使用：jackson.map.ObjectMapper 类来创建对象 ！！！由于jar包问题暂时使用该类。
		ObjectMapper mapper = new ObjectMapper();
		
		//3.调用mapper的writeValueAsString() 方法 把一个对象转换为一个 JSON字符串 
		
		Customer customer = new Customer("atguigu", "1001");
		String jsonStr = mapper.writeValueAsString(customer);
		System.out.println(jsonStr);
		
		//4.注意：jackson使用getter 方法来定位JSON 对象的属性！！！
		
		//5.可以通过添加注解:com.fasterxml.jackson.annotation.JsonIgnore来忽略此getter属性
		
		//6.将一个集合转换为JSON字符串
		List<Customer> customers = Arrays.asList(customer,new Customer("baidu", "1002"));
		//jsonTwo 为一个JSON的数组
		String jsonTwo =mapper.writeValueAsString(customers);
		System.out.println(jsonTwo);
	}
}
