package pairmatching.domain;

import java.util.List;

public class PareMatching {
	private Course course;
	private Level level;
	private Mission mission;

	public PareMatching(List<String> input) {
		course = Course.findByName(input.get(0));
		level = Level.findByName(input.get(1));
		mission = Mission.findByLevelAndName(level, input.get(2));
	}

}
