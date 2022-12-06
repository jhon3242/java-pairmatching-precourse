package pairmatching.domain;

import java.util.List;

public class PareMatching {
	private Course course;
	private Level level;
	private Mission mission;
	//TODD 크루 리스트들


	public PareMatching(List<String> input) {
		course = Course.findByName(input.get(0));
		level = Level.findByName(input.get(1));
		mission = Mission.findByLevelAndName(level, input.get(2));
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
}
