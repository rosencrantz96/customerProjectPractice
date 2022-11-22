
public class VIPCustomer extends Customer {
	// 필드 
	private int agentID; // 상담원 아이디 (vip는 상담원이 내정되어 있음) 
	double saleRatio;
	
	// 생성자 
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName); // 기본적인 것은 그대로 상속받아오기 
		super.customerGrade = "VIP"; // initCustomer() 초기값 재설정! 
		super.bonusRatio = 0.05;
		this.saleRatio = 0.1; // 여기 saleRatio 다르니깐... 
		this.agentID = agentID; // 이건 여기에서 새로 생긴거니까 this.로 초기값 넣어주면 된다. 
	}

	// 메소드 
	@Override
	public int calcPrice(int price) {
		bonusPoint += (price * bonusRatio);
		return price - (int) (price * saleRatio);
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo() + ", 담당 상담원 ID: " + agentID;  
		// 상위 메소드 호출 (기존의 showCustomerInfo를 호출해서 결과값 그대로 리턴) 
		//+ 필드에 만들어둔 agentID 그대로 가져와주면 됨! 
	}

	public int getAgentID() {  // agentID는 private이라서 겟터 함수 필요 
		return agentID;
	}

	// 여기까지 하면 VIPCustomer도 끝~!! 
}
