package pairmatching;

import pairmatching.domain.MenuValidator;
import pairmatching.domain.PareMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PareProgram {
	List<PareMatching> pares = new ArrayList<>();

	public void process() {
		String choice = handleMenu();
		handleChoice(choice);
	}

	private String handleMenu() {
		try {
			String choice = InputView.inputChoice();
			MenuValidator.isValidate(choice);
			return choice;
		} catch (Exception error) {
			OutputView.printError(error);
			return handleMenu();
		}
	}

	private void handleChoice(String choice) {
		if (choice.equals("1")) {
			pareMatching();//
		} else if (choice.equals("2")) {
			;//
		} else if (choice.equals("3")) {
			;//
		} else if (choice.equals("Q")) {
			;//
		}
	}

	private void pareMatching() {
		try {
			String input = InputView.inputPareMatching();
			PareMatching pareMatching = new PareMatching(Util.getSplitList(input, ", "));
		} catch (Exception error) {
			OutputView.printError(error);
			pareMatching();
		}
	}


}
