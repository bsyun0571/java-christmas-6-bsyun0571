package christmas.domain;

import christmas.view.InputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventMenu {
	public static Map<String, Integer> setMenuList() {
		while (true) {
			try {
				String menuInput = InputView.readMenu();
				// TODO validate 가능한 메뉴인지 enum 클래스 생성후 구현
				return parseMenuList(menuInput);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}
		}
	}

	private static Map<String, Integer> parseMenuList(String menuInput) {
		List<String> menuAndNumber = List.of(menuInput.split(",|-"));
		Map<String, Integer> menu = new HashMap<>();
		int count = 0;
		for (int i = 0; i < menuAndNumber.size(); i += 2) {
			String menuName = validateMenu(menu, menuAndNumber.get(i));
			int menuNumber = validateMenuNum(menuAndNumber.get(i + 1));
			menu.put(menuName, menuNumber);
			count += menuNumber;
		}
		validateCount(count);
		return menu;
	}

	private static void validateCount(int count) {
		if (count > 20) {
			System.out.println("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
			throw new IllegalArgumentException();
		}
	}

	private static Integer validateMenuNum(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 수가 아닙니다.");
			throw new IllegalArgumentException();
		}
	}

	private static String validateMenu(Map<String, Integer> menu, String name) {
		if (menu.containsKey(name)) {
			System.out.println("[ERROR] 중복된 메뉴 이름입니다.");
			throw new IllegalArgumentException();
		}
		return name;
	}
}
