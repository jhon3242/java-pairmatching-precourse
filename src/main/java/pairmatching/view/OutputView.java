package pairmatching.view;

import pairmatching.Message;

public class OutputView {
	public static void printError(Exception error) {
		System.out.println("[ERROR] : " + error);
	}

	public static void printMessage(Message msg) {
		System.out.println(msg.getMsg());
	}
}
