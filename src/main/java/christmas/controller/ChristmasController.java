package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
	public void startEvent() {
		OutputView.printGreet();
		int date = InputView.readDate();
		String menu = InputView.readMenu();
		OutputView.printStart(date);
		printEventPlanner();


	}

	private void printEventPlanner() {
		OutputView.printMenu();
		OutputView.printAmountBeforeDiscount();
		OutputView.printGiftMenu();
		OutputView.printBenefitsDetails();
		OutputView.printTotalBenefitsAmount();
		OutputView.printAmountAfterDiscount();
		OutputView.printEventBadge();
	}
}
