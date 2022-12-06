package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
	public static List<String> getSplitList(String src, String regex) {
		String[] split = src.split(regex);
		return new ArrayList<String>(Arrays.asList(split));
	}
}
