package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PareMatching {
	private final Course course;
	private final Level level;
	private final Mission mission;
	private final Crews crews;
	private List<List<Crew>> matchList = new ArrayList<>();

	public PareMatching(List<String> input) throws IOException {
		course = Course.findByName(input.get(0));
		level = Level.findByName(input.get(1));
		mission = Mission.findByLevelAndName(level, input.get(2));
		crews = new Crews(course);
	}

	public void matching() {
		if (matchList.isEmpty()) {
			firstMatching();
			return ;
		}
		for (int i = 0; i < 3; i++) {
			if (reMatchingSuccess()) {
				return ;
			}
		}
		throw new RuntimeException("Rematch 3 times");
	}

	private void firstMatching() {
		matchList = new ArrayList<>();
		List<String> shuffledCrew = crews.getShuffledCrew();
		for (int i = 0; i < shuffledCrew.size() - 1; i+=2) {
			List<Crew> tmpList = new ArrayList<>();
			tmpList.add(crews.findByName(shuffledCrew.get(i)));
			tmpList.add(crews.findByName(shuffledCrew.get(i + 1)));
			if (i + 2 == shuffledCrew.size() - 1) {
				tmpList.add(crews.findByName(shuffledCrew.get(i + 2)));
			}
			matchList.add(tmpList);
		}
	}

	private boolean reMatchingSuccess() {
		List<String> shuffledCrew = crews.getShuffledCrew();
		List<List<Crew>> newMatchList = new ArrayList<>();
		for (int i = 0; i < shuffledCrew.size() - 1; i+=2) {
			List<Crew> tmpList = new ArrayList<>();
			tmpList.add(crews.findByName(shuffledCrew.get(i)));
			tmpList.add(crews.findByName(shuffledCrew.get(i + 1)));
			if (i + 2 == shuffledCrew.size() - 1) {
				tmpList.add(crews.findByName(shuffledCrew.get(i + 2)));
			}
			if (isSameMatch(tmpList)) {
				return false;
			}
			newMatchList.add(tmpList);
		}
		matchList = newMatchList;
		return true;
	}

	private boolean isSameMatch(List<Crew> tmpList) {
		int sameMatchCount = (int) tmpList.stream()
				.mapToInt(member -> getSameCrewCount(tmpList, getLastMatch(member)))
				.filter(count -> count > 1)
				.count();
		return sameMatchCount > 0;
	}

	private int getSameCrewCount(List<Crew> tmpList, List<Crew> lastMatch) {
		return (int) lastMatch.stream()
				.filter(member -> tmpList.contains(member))
				.count();
	}

	private List<Crew> getLastMatch(Crew crew) {
		return matchList.stream()
				.filter(list -> list.contains(crew))
				.findAny()
				.get();
	}


	public boolean isSame(PareMatching pareMatching) {
		return course.equals(pareMatching.getCourse()) &&
				level.equals(pareMatching.getLevel()) &&
				mission.equals(pareMatching.getMission());
	}

	private Course getCourse() {
		return course;
	}

	private Level getLevel() {
		return level;
	}

	private Mission getMission() {
		return mission;
	}

	public List<List<Crew>> getMatchList() {
		return matchList;
	}
}
