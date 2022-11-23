package practice;

import java.util.ArrayList;

public class CustomerApplication {
	
	private static ArrayList<Customer> arrayList = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// 객체 생성 
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerJung = new GoldCustomer(10040, "정약용");
		Customer customerYul = new VIPCustomer(10050, "이율곡", 12345);
		
		// 배열에 넣어주기
		arrayList.add(customerLee);
		arrayList.add(customerShin);
		arrayList.add(customerHong);
		arrayList.add(customerJung);
		arrayList.add(customerYul);
		
		// 메소드 실행 
		showAllCustomer();
		
		Customer customer = findCustomer(10050);
		if (customer == null) {
			System.out.println("존재하지 않는 회원입니다.");
		} else {
			showPriceBonus(customer, 10000);
		}
	}

	public static void showAllCustomer() {
		System.out.println("=========모든 고객 정보 출력=========");
		for(Customer customer : arrayList) {
			System.out.println(customer.showCustomerInfo());
		}
	}
	
	public static Customer findCustomer(int customerID) {
		Customer resultCustomer = null;
		
		for(Customer customer : arrayList) {
			if (customer.getCustomerID() == customerID) {
				resultCustomer = customer;
				break;
			}
		}
		return resultCustomer;
	}
	
	public static void showPriceBonus(Customer customer, int price) {
		System.out.println("====== 해당 고객의 할인율과 보너스 포인트 계산 ======");
		int cost = customer.calcPrice(price);
		System.out.println(customer.customerName + "님의 지불금액: " + cost + "원");
		System.out.println(customer.customerName + "님의 현재 보너스 포인트" + customer.bonusPoint + "점");
	}
	

}
