package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Mission {
	LEVEL1(Level.LEVEL1, Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2(Level.LEVEL2, Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3(Level.LEVEL3, Collections.emptyList()),
	LEVEL4(Level.LEVEL4, Arrays.asList("성능개선", "배포")),
	LEVEL5(Level.LEVEL5, Collections.emptyList());

	Mission(Level level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	private Level level;
	private List<String> missions;

	public Level getLevel() {
		return level;
	}

	public List<String> getMissions() {
		return missions;
	}

	public static Mission findByLevelAndName(Level level, String name) {
		return Arrays.stream(values())
				.filter(mission -> mission.getLevel().equals(level) && mission.getMissions().contains(name))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
}
