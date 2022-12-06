package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Mission {
	LEVEL1(Level.LEVEL1, Arrays.asList("자동차경주", "로또", "숫자야구게임"));
	// TODO 레벨 추가 구현

	Mission(Level level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	private Level level;
	private List<String> missions;
}
