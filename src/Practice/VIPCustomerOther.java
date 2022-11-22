package Practice;

public class VIPCustomerOther extends Customer {
	// 필드
		private int agentID;
		double saleRatio;
		
		// 생성자
		public VIPCustomerOther(int customerID, String customerName, int agentID) {
			super(customerID, customerName);
			super.customerGrade = "VIP";
			super.bonusRatio = 0.03;
			this.saleRatio = 0.2;
			this.agentID = agentID;
		}

		// 메소드
		@Override
		public int calcPrice(int price) {
			bonusPoint += price * bonusRatio;
			return (int) (price - (price * saleRatio));
		}

		@Override
		public String showCustomerInfo() {
			return super.showCustomerInfo() + ", 담당 상담원ID: " + agentID; 
		}

		public int getAgentID() {
			return agentID;
		}
}
