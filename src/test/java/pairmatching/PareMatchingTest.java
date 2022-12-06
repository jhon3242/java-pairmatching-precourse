package pairmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.domain.PareMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PareMatchingTest {

	@DisplayName("페어 매칭 정상 테스트")
	@ParameterizedTest
	@MethodSource("generateSuccessArgument")
	void matchingCourseSuccessTest(List<String> argument) {
		Assertions.assertThatCode(() -> new PareMatching(argument));
	}

	private static Stream<Arguments> generateSuccessArgument() {
		List<Arguments> arguments = new ArrayList<>();
		arguments.add(Arguments.of(Arrays.asList("백엔드", "레벨1", "로또")));
		arguments.add(Arguments.of(Arrays.asList("백엔드", "레벨4", "성능개선")));
		arguments.add(Arguments.of(Arrays.asList("프론트엔드", "레벨2", "지하철노선도")));
		arguments.add(Arguments.of(Arrays.asList("프론트엔드", "레벨4", "배포")));
		return arguments.stream();
	}

	@DisplayName("페어 매칭 실패 테스트")
	@ParameterizedTest
	@MethodSource("generateFailArgument")
	void matchingCourseFailTest(List<String> argument) {
		Assertions.assertThatThrownBy(() -> new PareMatching(argument))
				.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> generateFailArgument() {
		List<Arguments> arguments = new ArrayList<>();
		arguments.add(Arguments.of(Arrays.asList("안드로이드", "레벨1", "로또")));
		arguments.add(Arguments.of(Arrays.asList("백엔드", "레벨5", "성능개선")));
		arguments.add(Arguments.of(Arrays.asList("프론트엔드", "레벨1", "지하철노선도")));
		arguments.add(Arguments.of(Arrays.asList("프론트엔드", "레벨5", "배포")));
		return arguments.stream();
	}
}
