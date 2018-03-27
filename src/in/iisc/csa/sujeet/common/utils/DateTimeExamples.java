package in.iisc.csa.sujeet.common.utils;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeExamples {
	public static void formatterWithUTCTime() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm").withZoneUTC();
		DateTime dt = formatter.parseDateTime("2017-12-24-15-00");
		System.out.println(dt);
		System.out.println(dt.toString("yyyy-MM-dd HH:mm:sss"));
	}

	public static void fromTimestamp() {
		Timestamp ts = Timestamp.valueOf("2017-12-24 15:00:00");
		DateTime dt = new DateTime(ts);
		System.out.println(dt);
	}

	public static void printFiveConsecutiveHoursTimestamp() {
		DateTime dt = DateTime.now();
		for (int i = 0; i < 5; i++) {
			System.out.println(dt);
			dt = dt.plusHours(1);
		}
	}

	public static void main(String[] args) {
		printFiveConsecutiveHoursTimestamp();
	}

}
