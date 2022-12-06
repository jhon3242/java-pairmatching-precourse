package pairmatching.domain;

import java.util.List;

public class PareMatching {
	private Course course;
	private Level level;
	private Mission mission;

	public PareMatching(List<String> input) {
		course = Course.findByName(input.get(0));
	}
}
