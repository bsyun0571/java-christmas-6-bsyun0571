package christmas.controller;


import christmas.domain.Event;
import christmas.domain.EventDate;
import christmas.domain.EventMenu;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
	public void startEvent() {
		OutputView.printGreet();
		int date = EventDate.inputDate();
		Map<String, Integer> menu = EventMenu.setMenuList();
		OutputView.printStart(date);

		Event.applyEvent(date, menu);
		printEventPlanner(menu);
	}


	private void printEventPlanner(Map<String, Integer> menu) {
		OutputView.printMenu();
		OutputView.printAmountBeforeDiscount();
		OutputView.printGiftMenu();
		OutputView.printBenefitsDetails();
		OutputView.printTotalBenefitsAmount();
		OutputView.printAmountAfterDiscount();
		OutputView.printEventBadge();
	}
}
