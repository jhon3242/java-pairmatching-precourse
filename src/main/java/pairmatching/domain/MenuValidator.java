package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public class MenuValidator {
	private static List<String> value = Arrays.asList("1", "2", "3", "Q");

	public static void isValidate(String input) {
		isNull(input);
		isMatchingMenu(input);
	}

	private static void isNull(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Input Value is null");
		}
	}

	private static void isMatchingMenu(String input) {
		if (!value.contains(input)) {
			throw new IllegalArgumentException("No matching input");
		}
	}
}
