package christmas.view;

public class OutputView {

	public void printStart() {
		System.out.println("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!");

	}
	public void printMenu() {
		System.out.println("<주문 메뉴>");

	}
	public void printAmountBeforeDiscount() {
		System.out.println("<할인 전 총주문 금액>");

	}
	public void printGiftMenu() {
		System.out.println("<증정 메뉴>");

	}

	public void printBenefitsDetails() {
		System.out.println("<혜택 내역>");

	}

	public void printTotalBenefitsAmount() {
		System.out.println("<총혜택 금액>");

	}

	public void printAmountAfterDiscount() {
		System.out.println("<할인 후 예상 결제 금액>");

	}

	public void printEventBadge() {
		System.out.println("<12월 이벤트 배지>");

	}
}
