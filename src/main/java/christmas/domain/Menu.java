package christmas.domain;

public enum Menu {
	MUSHROOMSOUP("애피타이저", "양송이스프", 6_000),
	TAPAS("애피타이저", "타파스", 5_500),
	CAESARSALAD("애피타이저", "시저샐러드", 8_000),
	TBONESTEAK("메인", "티본스테이크", 55_000),
	BBQRIBS("메인", "바비큐립", 54_000),
	SEAFOODPASTA("메인", "해산물파스타", 35_000),
	CHRISTMASPASTA("메인", "크리스마스파스타", 25_000),
	CHOCOCAKE("디저트", "초코케이크", 15_000),
	ICECREAM("디저트", "아이스크림", 5_000),
	ZEROCOLA("음료", "제로콜라", 3_000),
	REDWINE("음료", "레드와인", 60_000),
	CHAMPAGNE("음료", "샴페인", 25_000);

	private final String type;
	private final String name;
	private final int price;

	Menu(String type, String name, int price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
