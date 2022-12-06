package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.CrewFileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	public List<Crew> crews;

	public Crews(Course course) throws IOException {
		if (Course.FRONTEND.equals(course)) {
			initFrontEnd();
		} else if (Course.BACKEND.equals(course)) {
			initBackEnd();
		}
	}

	private void initFrontEnd() throws IOException {
		crews = CrewFileInputStream.getCrewsFromFile(Course.FRONTEND.getFilePath(), Course.FRONTEND);
	}

	private void initBackEnd() throws IOException {
		crews = CrewFileInputStream.getCrewsFromFile(Course.BACKEND.getFilePath(), Course.BACKEND);
	}

	public List<String> getShuffledCrew() {
		List<String> crewNames = crews.stream()
				.map(Crew::getName)
				.collect(Collectors.toList());
		return Randoms.shuffle(crewNames);
	}

	public Crew findByName(String name) {
		return crews.stream()
				.filter(crew -> crew.getName().equals(name))
				.findAny()
				.get();
	}
}
