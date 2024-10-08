package christmas.domain;

import christmas.view.InputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EventMenu {

	private final static int MAX_ORDER_NUMBER = 20;

	public static Map<String, Integer> inputMenu() {
		while (true) {
			try {
				String menuInput = InputView.readMenu();
				return parseInputMenu(menuInput);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}
		}
	}

	private static Map<String, Integer> parseInputMenu(String menuInput) {
		List<String> menuAndNumber = List.of(menuInput.split(",|-"));
		Map<String, Integer> menu = new HashMap<>();
		int count = 0;
		for (int i = 0; i < menuAndNumber.size(); i += 2) {
			String menuName = validateMenu(menu, menuAndNumber.get(i));
			int menuNumber = validateMenuNum(menuAndNumber.get(i + 1));
			menu.put(menuName, menuNumber);
			count += menuNumber;
		}
		validate(count, menu);
		return menu;
	}

	private static void validate(int count, Map<String, Integer> menu) {
		validateCount(count);
		validateExist(menu);
		validateOnlyDrink(menu);
	}

	private static void validateOnlyDrink(Map<String, Integer> menu) {
		boolean alwaysDrink = true;
		for (String key : menu.keySet()) {
			if (!Objects.equals(Menu.getMenuInfo(key)
					.getType(), "음료")) {
				alwaysDrink = false;
			}
		}
		if (alwaysDrink) {
			System.out.println("[ERROR] 음료만 주문할 수 없습니다.");
			throw new IllegalArgumentException();
		}
	}

	private static void validateExist(Map<String, Integer> menu) {
		boolean exist = false;
		for (String key : menu.keySet()) {
			if (Objects.equals(Menu.getMenuInfo(key)
					.getName(), key)) {
				exist = true;
			}
		}
		if (exist == false) {
			System.out.println("[ERROR] 메뉴가 존재하지 않습니다.");
			throw new IllegalArgumentException();
		}
	}

	private static void validateCount(int count) {
		if (count > MAX_ORDER_NUMBER) {
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
			System.out.println("[ERROR] 중복된 메뉴 이름입니다. 한번에 입력해주세요.");
			throw new IllegalArgumentException();
		}
		return name;
	}
}
