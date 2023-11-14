package christmas.controller;

import christmas.domain.Event;
import christmas.domain.EventDate;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasController {
	public void startEvent() {
		OutputView.printGreet();
		int date = EventDate.inputDate();
		String input = InputView.readMenu();
		Map<String, Integer> menu = setMenuList(input);
		OutputView.printStart(date);
		printEventPlanner(menu);

		Event.applyEvent(date, menu);

	}

	private Map<String, Integer> setMenuList(String input) {
		List<String> menuAndNumber = List.of(input.split(",|-"));
		Map<String, Integer> menu = new HashMap<>();
		for (int i = 0; i < menuAndNumber.size(); i += 2) {
			menu.put(menuAndNumber.get(i),
					Integer.valueOf(menuAndNumber.get(i + 1)));
		}
		return menu;
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
