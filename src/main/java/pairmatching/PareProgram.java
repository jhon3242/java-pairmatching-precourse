package pairmatching;

import pairmatching.view.InputView;

public class PareProgram {
	public void process() {
		String choice;
		do {
			choice = InputView.inputChoice();
			handleChoice(choice); // TODO 입력값이 매칭되지 않느 경우 예외처리
		} while (isNotEnd(choice));
	}

	private void handleChoice(String choice) {
		if (choice.equals("1")) {
				//
		} else if (choice.equals("2")) {
			//
		} else if (choice.equals("3")) {
			//
		}
	}

	private boolean isNotEnd(String choice) {
		return !choice.equals("Q");
	}


}
