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
		OutputView.printStart(date);
		Map<String, Integer> menu = EventMenu.setMenuList();
		int amount = getAmount(menu);

		printEventPlanner(menu, amount);
		applyEvent(date, menu, amount);

	}

	private void applyEvent(int date, Map<String, Integer> menu, int amount) {
		int christmasSaleMoney = Event.christmasDDaySale(date,amount);
		int daySaleMoney = Event.daySale(date, menu, amount);
		int specialSaleMoney = Event.specialSale(date, amount);
		int giftMoney = Event.giveGift(amount);
		OutputView.printGiftMenu(giftMoney);
		OutputView.printBenefitsDetails(christmasSaleMoney, daySaleMoney, specialSaleMoney, giftMoney, date);
	}


	private int getAmount(Map<String, Integer> menu) {
		int amount = 0;
		for(String key : menu.keySet()){
			amount += Menu.getMenuInfo(key)
					.getPrice() * menu.get(key);
		}
		return amount;
	}


	private void printEventPlanner(Map<String, Integer> menu, int amount) {
		OutputView.printAmountBeforeDiscount(amount);

	}
}
