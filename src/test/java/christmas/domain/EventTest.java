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
	@DisplayName("수가 아닌 입력에 대한 예외 처리")
	@ValueSource(strings = {"a", "--", "1000a"})
	@ParameterizedTest
	void isNumberInputGiveGift(String input){
		assertThatThrownBy(() -> Event.giveGift(Integer.parseInt(input)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputSpecialSale(){
		assertThatThrownBy(() -> Event.specialSale(3, Integer.parseInt("1000a")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputSpecialSale2(){
		assertThatThrownBy(() -> Event.specialSale(Integer.parseInt("a"), Integer.parseInt("1000")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("수가 아닌 입력에 대한 예외 처리")
	@Test
	void isNumberInputDaySale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("양송이스프", 3);
		assertThatThrownBy(() -> Event.daySale(Integer.parseInt("a"), menu, 1000))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메인 메뉴가 여러개일때 되는지 테스트")
	@Test
	void isExistInputDaySale(){
		Map<String, Integer> menu = new HashMap<>();
		menu.put("티본스테이크", 3);
		int amount = Event.daySale(1, menu, 13000);
		assertThat(amount == 2023 * 3);
	}



}
