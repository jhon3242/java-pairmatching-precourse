package pairmatching.view;

import pairmatching.Message;
import pairmatching.domain.Crew;
import pairmatching.domain.PareMatching;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static void printError(Exception error) {
		System.out.println("[ERROR] : " + error);
	}

	public static void printMessage(Message msg) {
		System.out.println(msg.getMsg());
	}

	public static void printPare(PareMatching pareMatching) {
		System.out.println(Message.PARE_MATCHING_MSG.getMsg());
		List<List<Crew>> matchList = pareMatching.getMatchList();
		matchList.forEach(pare -> {
			List<String> names = new ArrayList<>();
			for (Crew crew : pare) {
				names.add(crew.getName());
			}
			String result = String.join(Message.PARE_MATCHING_DIV.getMsg(), names);
			System.out.println(result);
		});
	}
}
