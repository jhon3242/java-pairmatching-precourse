package pairmatching;

import java.util.List;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public static void run() {
        PairMatchingService.initCrews();
        proceed();
    }

    private static void proceed() {
        while (true) {
            String validateMenu = getValidateMenu();
            if (validateMenu.equals("Q")) {
                break;
            }

            // TODO 메뉴에 따라 기능 수행
        }
    }

    private static String getValidateMenu() {
        try {
            return PairMatchingService.getValidateMenu(InputView.readMenu());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateMenu();
        }
    }

    private static void pairMatching(Course course, Level level) {
        List<Pair> matchingResult = PairMatchingService.pairMatching(course);
        if (PairMatchingService.hasSamePair(course, level) && getValidateRematch().equals("네")) {
            // 3번 리매칭

            return;
        }
        OutputView.printMatchingResult(matchingResult);
    }

    private static String getValidateRematch() {
        try {
            return PairMatchingService.getValidateRematch(InputView.readRematch());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateRematch();
        }
    }
}
