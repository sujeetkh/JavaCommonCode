package in.iisc.csa.sujeet.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.text.StrSubstitutor;
import org.joda.time.DateTime;

public class SubstitutorExamples {
	public static void substitutor() {
		DateTime dt = DateTime.now();
		Map<String, Object> valuesMap = new HashMap<String, Object>();
		valuesMap.put("date", dt.toString("yyyy-MM-dd"));
		valuesMap.put("hour", dt.getHourOfDay());
		valuesMap.put("minute", dt.getMinuteOfHour());
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String path = "path/dt=${date}/hour=${hour}/";
		System.out.println(sub.replace(path));
	}

	public static void main(String[] args) {
		substitutor();
	}
}
