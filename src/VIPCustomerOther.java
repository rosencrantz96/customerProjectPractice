
public class VIPCustomerOther extends Customer {
	// 필드 
		private int agentID; // 상담원 아이디 
		double saleRatio; // 할인비율 
		
		// 생성자 
		public VIPCustomerOther(int customerID, String customerName, int agentID) {
			super(customerID, customerName); 
			super.customerGrade = "VIP";  
			super.bonusRatio = 0.03; // 여기와 
			this.saleRatio = 0.2;  // 여기를 바꿔주면 됨 
			this.agentID = agentID; 
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

		public int getAgentID() {  //agentID는 private이라서 겟터 함수 필요 
			return agentID;
		}
}
