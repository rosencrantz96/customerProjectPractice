import java.util.ArrayList;

public class CustomerApplication {
	// Customer 객체(고객)를 저장할 ArrayList를 생성 
	private static ArrayList<Customer> customerList = new ArrayList<Customer>(); 
	// 배열에 customer 객체를 저장할 것이기 때문에 꺽쇠 안에 써주면 된다
	// 고객을 한 명 한 명 저장하는 것! 
	
	public static void main(String[] args) {
		// 일반 고객 (silver)
		Customer customerLee = new Customer(10010, "이순신"); // 1. 객체 생성 
		Customer customerShin = new Customer(10020, "신사임당");
		// 객체가 생성되면 생성자가 실행된다. 필드에 초기값이 들어가고 initCustomer() 메소드도 실행됨!
		
		// 골드 고객
		Customer customerHong = new GoldCustomer(10030, "홍길동"); // GoldCustomer라고 해야 자동형변환이 일어나서 다형성을 실행할 수 있다! 
		// Customer : 부모, GoldCustomer : 자식 -> 자동형변환 
		// GoldCustomer의 생성자 실행! -> 재지정한 값들을 실행. saleRatio는 자체적으로 지정한 것이기 때문에 바로 0.1 고고.
		Customer customerYul = new GoldCustomer(10040, "정약용");
		
		// VIP 고객 (상담원 번호도 넣어줘야 합니다) 
		// 다형성이라는 상속의 개념 덕분에 코드도 줄어들고 ! 필요한게 있으면 재정의를 해서 쓰고! 조은 것임. 
		Customer customerLee2 = new VIPCustomer(10050, "이율곡", 12345);
		// 자식 필드에는 접근 불가하지만 vip 같은 경우에는 showCustomerInfo를 오버라이드 해줬기 때문에 출력 가능 
		
		// 생성을 했으니까 배열에 넣어주면 된다!! 
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerLee2);
		// 배열에 더해줘서 배열 각각의 방에 객체들이 들어가 있음. (배열 인덱스 번호 받음) 
		
		showAllCustomer(); // (static 전역변수니까 여기서 바로 실행 가능!)
		
		// id로 고객 찾기
		Customer customer = findCustomer(10050); // Customer 객체를 받는다.  ( 객체에 받아준다? )
		
		// id로 찾은 고객의 실제 지불 금액, 보너스 포인트 출력 
		if (customer == null) {
			System.out.println("존재하지 않는 회원입니다."); // 찾은 고객 정보가 없을 때 예외 문구 작성 
		} else {
			// 고객의 실제 지불 금액, 보너스 포인트는 여기서 출력하면 됨. 
			showPriceBonus(customer, 10000); // 메소드에 변수 넣어주면 showPriceBonus 실행! 
			
		}
		
	}
	
	// 모든 고객정보 출력
	public static void showAllCustomer() {
		System.out.println("=========모든 고객 정보 출력=========");
		// 배열에 들어간 고객 정보들을 출력해주면 된다. (향상된 for문 사용... 공부하자) 
		for (Customer customer : customerList) { // 데이터 타입 Customer, 변수명 customer로 받아주시면 됩니다. 
			System.out.println(customer.showCustomerInfo());
			// 실행은 메인 메소드에서 해주어야 한다! 
		} 
	}
	
	// id로 해당 고객 객체를 찾아주는 메소드  
	public static Customer findCustomer(int customerID) { // 리턴 타입 Customer로 받는다는 뜻임 .
		Customer resultCustomer = null; // 데이터타입: Customer
		
		for (Customer customer : customerList) { // 고객 객체에서 아이디를 뽑아와서 매개변수와 비교 -> 맞으면 리턴 
			// 해당 객체의 customerID와 매개변수로 받아온 customerID가 같은지 비교한다. 
			if(customer.getCustomerID() == customerID) { // 해당 객체에 있는 customerID를 가져옴 
				resultCustomer = customer; // 같으면 그대로 받아주면 된다. 
				break; // 찾으면 멈춰줘야 하니까 break를 넣어줘야 함! for 문을 빠져나올 수 있게.
				//그리고 나서 그냥 리턴 시켜주면 된다! 
			}
		}
		return resultCustomer; // 해당 객체를 찾지 못하면 null을 리턴! 
	} 
	
	public static void showPriceBonus(Customer customer, int price) {
		System.out.println("====== 해당 고객의 할인율과 보너스 포인트 계산 ======");
		// 지불할 비용 출력할 것. 
		int cost = customer.calcPrice(price); // 이율곡 객체에서 calcPrice 실행 
		System.out.println(customer.getCustomerName() + "님의 지불금액: " + cost +"원");
		System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트: " + customer.bonusPoint + "점");
	}
}
