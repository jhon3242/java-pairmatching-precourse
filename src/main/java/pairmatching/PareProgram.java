package pairmatching;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.MenuValidator;
import pairmatching.domain.PareMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PareProgram {
	private List<PareMatching> history = new ArrayList<>();

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
			pareMatching();
		} else if (choice.equals("2")) {
			pareHistory();
		} else if (choice.equals("3")) {
			initialize();
		} else if (choice.equals("Q")) {
			return;
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
			pareMatching.matching();
			OutputView.printPare(pareMatching);
			addToHistory(pareMatching);
		} catch (Exception error) {
			OutputView.printError(error);
			pareMatching();
		}
	}

	private void addToHistory(PareMatching pareMatching) {
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).isSame(pareMatching)) {
				history.remove(i);
				break;
			}
		}
		history.add(pareMatching);
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

	private void pareHistory() {
		try {
			String input = InputView.inputPareMatching();
			PareMatching pareMatching = new PareMatching(Util.getSplitList(input, ", "));
			PareMatching matching = history.stream()
					.filter(pare -> pare.isSame(pareMatching))
					.findAny()
					.orElseThrow(() -> new IllegalArgumentException("No matching history"));
			OutputView.printPare(matching);
		} catch (Exception error) {
			OutputView.printError(error);
			pareHistory();
		}
	}

	private void initialize() {
		history = new ArrayList<>();
		OutputView.printMessage(Message.INITIALIZE_MSG);
	}

}
