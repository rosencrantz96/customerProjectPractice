package Practice;

import java.util.ArrayList;

public class CustomerApplication {
	
	protected ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// 실버 
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		
		// 골드
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerJung = new GoldCustomer(10040, "정약용");
		
		// vip
		Customer customerYul = new VIPCustomer(10050, "이율곡", 12345);
		
		customerList.add(customerLEE);
		
	}

	

}
