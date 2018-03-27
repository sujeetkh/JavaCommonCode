package in.iisc.csa.sujeet.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExamples {
	public static void groups() {
		String wideTableFile = "path/dt=2017-12-01/5_7_15.orc";
		String filePattern = "path/dt=([^/]*)/([0-9]*)_([0-9]*)_(.*)";
		Matcher matcher = Pattern.compile(filePattern).matcher(wideTableFile);
		matcher.find();
		System.out.println("date: " + matcher.group(0));
		System.out.println("hour: " + matcher.group(2));
		System.out.println("minute: " + matcher.group(3));
		System.out.println(Pattern.matches(filePattern, wideTableFile));
	}

	public static void main(String[] args) {
		groups();
	}
}
