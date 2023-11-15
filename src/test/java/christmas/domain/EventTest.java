package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventTest {
	@DisplayName("증정 메뉴 - 수가 아닌 입력에 대한 예외 처리")
	@ValueSource(strings = {"a", "--", "1000a"})
	@ParameterizedTest
	void isNumberInputGiveGift(String input){
		assertThatThrownBy(() -> Event.giveGift(Integer.parseInt(input)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("증정 메뉴 - 12만원 이하의 금액에 대한 예외 처리")
	@Test
	void underInputGiveGift(){
		int amount = Event.giveGift(88500);
		assertThat(amount).isEqualTo(0);
	}

	@DisplayName("특별 할인 - 수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputSpecialSale(){
		assertThatThrownBy(() -> Event.specialSale(3, Integer.parseInt("1000a")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("특별 할인 - 수가 아닌 입력에 대한 예외 처리2")
	@Test
	void isNumberInputSpecialSale2(){
		assertThatThrownBy(() -> Event.specialSale(Integer.parseInt("a"), Integer.parseInt("1000")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("특별 할인 - 만원 이하의 금액에 대한 예외 처리")
	@Test
	void underInputSpecialSale(){
		int amount = Event.specialSale(3,8500);
		assertThat(amount).isEqualTo(0);
	}

	@DisplayName("특별 할인 - 정상 작동 테스트")
	@ValueSource(strings = {"3", "10", "17", "24", "25"})
	@ParameterizedTest
	void executeAllSpecialSale(String input){
		int amount = Event.specialSale(Integer.parseInt(input), 15000);
		assertThat(amount).isEqualTo(1000);
	}

	@DisplayName("특별 할인 - 정상 작동 테스트")
	@ValueSource(strings = {"26", "1", "4", "13"})
	@ParameterizedTest
	void executeNotSpecialSale(String input){
		int amount = Event.specialSale(Integer.parseInt(input), 15000);
		assertThat(amount).isEqualTo(0);
	}



	@DisplayName("평일/주말 할인 - 수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputDaySale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("양송이스프", 3);
		assertThatThrownBy(() -> Event.daySale(Integer.parseInt("a"), menu, 1000))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("평일/주말 할인 - 만원 이하의 금액에 대한 예외 처리")
	@Test
	void underInputDaySale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("아이스크림", 1);
		int amount = Event.daySale(3,menu,5000);
		assertThat(amount).isEqualTo(0);
	}

	@DisplayName("평일/주말 할인 - 주말 + 메인 메뉴가 여러개일때 할인이 제대로 적용되는지 테스트")
	@Test
	void multiInputWeekendSale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("티본스테이크", 3);
		int amount = Event.daySale(1, menu, 165000);
		assertThat(amount).isEqualTo(2023 * 3);
	}

	@DisplayName("평일/주말 할인 - 평일 + 디저트 메뉴가 여러개일때 할인이 제대로 적용되는지 테스트")
	@Test
	void multiInputWeekdaySale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("초코케이크", 5);
		int amount = Event.daySale(4, menu, 75000);
		assertThat(amount).isEqualTo(2023 * 5);
	}

	@DisplayName("크리스마스 디데이 할인 - 수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputChristmasDDaySale(){
		assertThatThrownBy(() -> Event.christmasDDaySale(3, Integer.parseInt("1000a")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("만원 이하의 금액에 대한 예외 처리")
	@Test
	void underInputChristmasDDaySale(){
		int amount = Event.christmasDDaySale(3,8500);
		assertThat(amount).isEqualTo(0);
	}

	@DisplayName("크리스마스 할인 - 정상 작동 테스트")
	@ValueSource(strings = {"26", "27", "28", "29", "30", "31"})
	@ParameterizedTest
	void executeNotChristmasDDaySale(String input){
		int amount = Event.christmasDDaySale(Integer.parseInt(input), 15000);
		assertThat(amount).isEqualTo(0);
	}


}
