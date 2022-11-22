package Practice;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.ArrayList;

public class CustomerApplication {
	
	protected static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// 실버 
		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		
		// 골드
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerJung = new GoldCustomer(10040, "정약용");
		
		// vip
		Customer customerYul = new VIPCustomer(10050, "이율곡", 12345);
		
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerJung);
		customerList.add(customerYul);
		
		showAllCustomer();
		
//		showPriceBonus(customerYul, 10050);
		
		// 먼저 id로 고객을 찾아야 함! 
		Customer customer = findCustomer(10050);
		
		// id로 찾은 고객의 실제 지불 금액, 보너스 포인트를 출력해야 한다. 
		if (customer == null) {
			System.out.println("존재하지 않는 회원입니다.");
		} else {
			showPriceBonus(customer, 10000); // 바로 함수를 호출하면 되는 것임 ㅠ... 
		}
	}

	public static void showAllCustomer() {
		System.out.println("========모든 고객 정보 출력========");
		for(Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}
	}
	
	public static Customer findCustomer(int customerID) {
		// 1. (for) 배열을 돌려서 번호가 일치하는지 확인 
		// 2. (if) 일치하는 번호를 리턴 
		Customer customerResult = null;
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerID) {
				customerResult = customer; // 시발 여기 똑바로 하자 
				break;
			}	 
		}
		return customerResult;
	}
	
	public static void showPriceBonus(Customer customer, int price) {
		System.out.println("===== 해당 고객의 할인율과 보너스 포인트 계산 =====");
		int cost = customer.calcPrice(price);
		System.out.println(customer.getCustomerName() + "님의 지불금액: " + cost + "원");
		System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트: " + customer.bonusPoint + "점");
		
	}
	

}
