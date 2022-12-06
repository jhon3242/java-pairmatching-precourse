package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewFileInputStream {

	public static List<Crew> getCrewsFromFile(String path, Course course) throws IOException {
		List<Crew> crews = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		while (true) {
			String name = br.readLine();
			if (name == null) {
				break;
			}
			crews.add(new Crew(course, name));
		}
		return crews;
	}
}
