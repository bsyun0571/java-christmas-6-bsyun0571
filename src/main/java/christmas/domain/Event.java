package christmas.domain;

import java.util.Map;
import java.util.Objects;

public class Event {
	private final static int MIN_EVENT_PRICE = 10000;
	private final static int MIN_GIFT_PRICE = 120000;
	private final static int ZERO = 0;
	private final static int GIFT_PRICE = 25000;
	private final static int WEEK = 7;
	private final static int BASIC_PRICE = 1000;
	private final static int PER_DAY = 100;
	private final static int THIS_YEAR = 2023;
	public static int giveGift(int amount) {
		if (amount >= MIN_GIFT_PRICE) {
			return GIFT_PRICE;
		}
		return ZERO;
	}

	public static int specialSale(int date, int amount) {
		if (amount < MIN_EVENT_PRICE) {
			return ZERO;
		}
		if (date % WEEK == 3 || date == 25) {
			return BASIC_PRICE;
		}
		return ZERO;
	}

	public static int daySale(int date, Map<String, Integer> menu, int amount) {
		if (amount < MIN_EVENT_PRICE) {
			return ZERO;
		}
		if (date % WEEK == 1 || date % WEEK == 2) {
			return weekendSale(menu);
		}
		if (date % WEEK != 1 && date % WEEK != 2) {
			return weekdaySale(menu);
		}
		return ZERO;
	}

	public static int weekdaySale(Map<String, Integer> menu) {
		int saleMoney = 0;
		for (String key : menu.keySet()) {
			if (Objects.equals(Menu.getMenuInfo(key)
					.getType(), "디저트")) {
				saleMoney += THIS_YEAR * menu.get(key);
			}
		}
		return saleMoney;
	}

	public static int weekendSale(Map<String, Integer> menu) {
		int saleMoney = 0;
		for (String key : menu.keySet()) {
			if (Objects.equals(Menu.getMenuInfo(key)
					.getType(), "메인")) {
				saleMoney += THIS_YEAR * menu.get(key);
			}
		}
		return saleMoney;
	}

	public static int christmasDDaySale(int date, int amount) {
		if (amount < MIN_EVENT_PRICE) {
			return ZERO;
		}
		if (date < 26) {
			return BASIC_PRICE + (date - 1) * PER_DAY;
		}
		return ZERO;
	}
}
