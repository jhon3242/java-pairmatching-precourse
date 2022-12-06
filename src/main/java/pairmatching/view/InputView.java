package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Message;

public class InputView {

	public static String inputChoice() {
		System.out.println(Message.MENU.getMsg());
		String input = Console.readLine();
		isValidate(input);
		return input;
	}

	private static void isValidate(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Input value is null");
		}
	}
}