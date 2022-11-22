
public class GoldCustomer extends Customer {
	// 필드
	double saleRatio; // 할인율 
	
	// 생성자
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName); // 상위 클래스에서 상속 받아오기 (상위 클래스 생성자 호출, 아이디와 네임 가져옴) (공통적으로 쓰이는 것이기 때문에) 
		// 아이디와 이름은 기본적으로 customer에 있는 애들을 가져다 쓰는 것임 (이미 존재하는 건 그냥 가져다 쓰면 되니까!) 상속의 장점~ 
		// 그렇다면... initCustomer()는 어케 될까요? 얘도 실행이 될텐데 말입니다. 
		// 그대로 가져오면 안되겠죠? 그래서 이렇게 아래 초기값을 넣어줍니다. 
		super.customerGrade = "GOLD";
		super.bonusRatio = 0.02;
		// 또! saleRatio도 초기값을 줘야겠죠? 
		this.saleRatio = 0.1;
	}

	// 메소드 
	@Override
	public int calcPrice(int price) { // 보너스 포인트 적립은 어차피 공식 똑같음! 비율도 우리가 따로 줬음! 하지만 리턴이 다르다. 
		bonusPoint += (price * bonusRatio);
		return price - (int) (price * saleRatio); // (실수 타입이기 때문에 int형으로 강제형변환 해주고, 그 값을 빼주어야 가격이 됨. 왜냐면 얘네는 할인이 들어가니까! 공식은 이해 가시져 
		// 할인금액 리턴! 
	}
	
}
