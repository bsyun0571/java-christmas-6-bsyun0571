package christmas.controller;

import christmas.domain.Event;
import christmas.domain.EventDate;
import christmas.domain.EventMenu;
import christmas.domain.Menu;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
	public void startEvent() {
		OutputView.printGreet();
		int date = EventDate.inputDate();
		Map<String, Integer> menu = EventMenu.inputMenu();

		OutputView.printStart(date);
		OutputView.printMenu(menu);

		int amount = getAmount(menu);
		OutputView.printAmountBeforeDiscount(amount);

		applyEvent(date, menu, amount);
	}

	private void applyEvent(int date, Map<String, Integer> menu, int amount) {
		int christmasSaleMoney = Event.christmasDDaySale(date, amount);
		int daySaleMoney = Event.daySale(date, menu, amount);
		int specialSaleMoney = Event.specialSale(date, amount);
		int giftMoney = Event.giveGift(amount);
		int totalBenefits = christmasSaleMoney + daySaleMoney + specialSaleMoney + giftMoney;

		printApplyEvent(christmasSaleMoney, daySaleMoney, specialSaleMoney, giftMoney, totalBenefits, date, amount);
	}

	private void printApplyEvent(int christmasSaleMoney, int daySaleMoney, int specialSaleMoney, int giftMoney,
	                             int totalBenefits, int date, int amount) {
		OutputView.printGiftMenu(giftMoney);
		OutputView.printBenefitsDetails(christmasSaleMoney, daySaleMoney, specialSaleMoney, giftMoney, date);
		OutputView.printTotalBenefitsAmount(totalBenefits);
		OutputView.printAmountAfterDiscount(christmasSaleMoney, daySaleMoney, specialSaleMoney, amount);
		OutputView.printEventBadge(totalBenefits);
	}

	private int getAmount(Map<String, Integer> menu) {
		int amount = 0;
		for (String key : menu.keySet()) {
			amount += Menu.getMenuInfo(key)
					.getPrice() * menu.get(key);
		}
		return amount;
	}
}
