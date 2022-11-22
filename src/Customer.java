
public class Customer {
	// 필드
	protected int customerID; // 고객아이디
	protected String customerName; // 고객이름 
	protected String customerGrade; // 고객등급: silver, gold... 
	int bonusPoint; // 포인트 적립
	double bonusRatio; // 보너스 포인트 적립 비율
	
	// 생성자 
	public Customer() {
		initCustomer(); // 1. 매개변수가 없으면 얘가 실행이 되고 
	}
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID; // 여기는 this.를 써주세요! (매개변수와 필드의 변수명이 같으면 필드 앞에는 this.를 붙이는 것이 좋다.) 
		this.customerName = customerName; 
		initCustomer(); // 2. 매개변수가 있으면 얘가 실행이 된다! 
	}
	
	// 메소드 
	// 고객 등급 초기화
	private void initCustomer() {
		this.customerGrade = "SILVER"; // this. 생략 가능! (여기서는 매개변수로 받는 것이 없기 때문에 생략해도 되는 것임) 
		bonusRatio = 0.01; // 두 가지 필드에 초기값을 줍니다. 
	}
	
	//보너스 포인트 계산, 가격 리턴 
	public int calcPrice(int price) { // 매개변수 price: 지불 금액
		bonusPoint += (price * bonusRatio); // 보너스 비율을 계산해서 bonusPoint를 적립해준다. 
		return price; // 일단 우리는 일반 고객에 대한 걸 작성 중임. 일반고객은 할인율이 없기 때문에 지불 금액 그대로 리턴해주면 된다. 
	}
	
	// 고객정보 보여주기 (이름, 등급, 보너스 포인트는 계속 바뀌어야 하기 때문에 아까 만들어준 필드를 넣어준다.) 
	public String showCustomerInfo() {
		return customerName + "님의 등급: " + customerGrade + ", 보너스 포인트: " + bonusPoint + "점";
	}

	// get, set 메소드 (get: 가져올 때) (set: 수정할 때)
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	// 여기까지 하면 가장 기본 고객 customer에 대한 것은 끝이다. silver 등급 고객! 
}
