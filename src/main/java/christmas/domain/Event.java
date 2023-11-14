package christmas.domain;

import java.util.Map;
import java.util.Objects;

public class Event {

	public static int giveGift(int amount) {
		if (amount > 120000) {
			return 25000;
		}
		return 0;
	}

	public static int specialSale(int date, int amount) {
		if (amount < 10000) {
			return 0;
		}
		if (date % 7 == 3 || date == 25) {
			return 1000;
		}
		return 0;
	}

	public static int daySale(int date, Map<String, Integer> menu, int amount) {
		if (amount < 10000) {
			return 0;
		}
		if (date % 7 == 1 || date % 7 == 2) {
			return weekendSale(date, menu);
		}
		if (date % 7 != 1 && date % 7 != 2) {
			return weekdaySale(date, menu);
		}
		return 0;
	}

	public static int weekdaySale(int date, Map<String, Integer> menu) {
		int saleMoney = 0;
		for (String key : menu.keySet()) {
			if (Objects.equals(Menu.getMenuInfo(key)
					.getType(), "디저트")) {
				saleMoney += 2023 * menu.get(key);
			}
		}
		return saleMoney;
	}

	public static int weekendSale(int date, Map<String, Integer> menu) {
		int saleMoney = 0;
		for (String key : menu.keySet()) {
			if (Objects.equals(Menu.getMenuInfo(key)
					.getType(), "메인")) {
				saleMoney += 2023;
			}
		}
		return saleMoney;
	}

	public static int christmasDDaySale(int date, int amount) {
		if (amount < 10000) {
			return 0;
		}
		if (date < 26) {
			return 1000 + (date - 1) * 100;
		}
		return 0;
	}
}
