package pairmatching;

import pairmatching.domain.MenuValidator;
import pairmatching.domain.PareMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PareProgram {
	List<PareMatching> history = new ArrayList<>();

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
			OutputView.printMessage(Message.PROGRAM_INFO);
			pareMatching();//
		} else if (choice.equals("2")) {
			;//
		} else if (choice.equals("3")) {
			;//
		} else if (choice.equals("Q")) {
			return;//
		}
		process();
	}

	private void pareMatching() {
		try {
			String input = InputView.inputPareMatching();
			PareMatching pareMatching = new PareMatching(Util.getSplitList(input, ", "));
			if (HaveHistory(pareMatching) && isRematch()){
				pareMatching();
				return;
			}
			history.add(pareMatching);
		} catch (Exception error) {
			OutputView.printError(error);
			pareMatching();
		}
	}

	private boolean HaveHistory(PareMatching pareMatching) {
		int count = (int) history.stream()
				.filter(pare -> pare.isSame(pareMatching))
				.count();
		return count > 0;
	}

	private boolean isRematch() {
		return InputView.inputRematch().equals("아니오");
	}


}
