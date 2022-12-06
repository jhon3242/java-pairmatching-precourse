package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드", "/Users/choewonjun/Documents/coding/woowaPre/java-pairmatching-precourse/src/main/resources/backend-crew.md"),
	FRONTEND("프론트엔드", "/Users/choewonjun/Documents/coding/woowaPre/java-pairmatching-precourse/src/main/resources/frontend-crew.md");

	private String name;
	private String filePath;

	Course(String name, String filePath) {
		this.name = name;
		this.filePath = filePath;
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filePath;
	}

	public static Course findByName(String name) {
		return Arrays.stream(values())
				.filter(course -> course.getName().equals(name))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
}
