package christmas.domain;

import christmas.view.InputView;

public class EventDate {
	public static int inputDate() {
		while (true) {
			try {
				int date = validateNum(InputView.readDate());
				validateRange(date);
				return date;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
			}
		}
	}

	private static void validateRange(int date) {
		if(date < 1 || date > 31){
			System.out.println("[ERROR] 유효하지 않은 날짜입니다.");
			throw new IllegalArgumentException();
		}
	}

	private static int validateNum(String input) {
		try {
			return Integer.parseInt(input);
		} catch(NumberFormatException e){
			System.out.println("[ERROR] 수가 아닙니다.");
			throw new IllegalArgumentException();
		}
	}
}
