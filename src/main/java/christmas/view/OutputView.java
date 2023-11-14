package christmas.view;

import java.util.Map;

public class OutputView {

	public static void printGreet() {
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
	}

	public static void printStart(int date) {
		System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!");
		System.out.println();

	}

	public static void printMenu(Map<String, Integer> menu) {
		System.out.println("<주문 메뉴>");
		for (String key : menu.keySet()) {
			System.out.println(key + " " + menu.get(key) + "개");
		}
		System.out.println();
	}

	public static void printAmountBeforeDiscount(int amount) {
		System.out.println("<할인 전 총주문 금액>");
		System.out.printf("%,d원\n", amount);
		System.out.println();
	}

	public static void printGiftMenu(int giftMoney) {
		System.out.println("<증정 메뉴>");
		if (giftMoney == 25000) {
			System.out.println("샴페인 1개");
		}
		if (giftMoney != 25000) {
			System.out.println("없음");
		}
		System.out.println();
	}

	public static void printBenefitsDetails(int christmasSaleMoney, int daySaleMoney, int specialSaleMoney,
	                                        int giftMoney, int date) {
		boolean benefits = false;
		System.out.println("<혜택 내역>");
		if (christmasSaleMoney >= 1000) {
			System.out.printf("크리스마스 디데이 할인: -%,d원\n", christmasSaleMoney);
			benefits = true;
		}
		if (daySaleMoney >= 2023 && (date % 7 != 1 && date % 7 != 2)) {
			System.out.printf("평일 할인: -%,d원\n", daySaleMoney);
			benefits = true;
		}
		if (daySaleMoney >= 2023 && (date % 7 == 1 || date % 7 == 2)) {
			System.out.printf("주말 할인: -%,d원\n", daySaleMoney);
			benefits = true;
		}
		if (specialSaleMoney == 1000) {
			System.out.printf("특별 할인: -%,d원\n", specialSaleMoney);
			benefits = true;
		}
		if (giftMoney == 25000) {
			System.out.printf("증정 이벤트: -%,d원\n", giftMoney);
			benefits = true;
		}
		if (benefits == false) {
			System.out.println("없음");
		}
		System.out.println();
	}

	public static void printTotalBenefitsAmount(int totalBenefits) {
		System.out.println("<총혜택 금액>");
		if (totalBenefits != 0) {
			System.out.printf("-%,d원\n\n", totalBenefits);
		}
		if (totalBenefits == 0) {
			System.out.println("0원\n\n");
		}
	}

	public static void printAmountAfterDiscount(int christmasSaleMoney, int daySaleMoney, int specialSaleMoney,
	                                            int amount) {
		System.out.println("<할인 후 예상 결제 금액>");
		int afterDiscount = amount - christmasSaleMoney - daySaleMoney - specialSaleMoney;
		System.out.printf("%,d원\n\n", afterDiscount);
	}

	public static void printEventBadge(int totalBenefits) {
		System.out.println("<12월 이벤트 배지>");
		if (totalBenefits >= 20000) {
			System.out.println("산타");
		}
		if (totalBenefits < 20000 && totalBenefits >= 10000) {
			System.out.println("트리");
		}
		if (totalBenefits < 10000 && totalBenefits >= 5000) {
			System.out.println("별");
		}
		if (totalBenefits < 5000) {
			System.out.println("없음");
		}
	}
}
