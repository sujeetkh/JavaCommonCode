package in.iisc.csa.sujeet.common.utils;

import java.sql.Timestamp;

public class TimestampExamples {
	// LocalDateTime functions
	public static void initializationWithLongNumber() {
		Timestamp ts = new Timestamp(1509348357300l);
		System.out.println(ts);
	}

	public static void initializationWithString() {
		Timestamp ts = Timestamp.valueOf("2018-03-27 20:27:18.745");
		System.out.println(ts);
	}

	public static void currentTimestamp() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
	}

	public static void main(String[] args) {
		initializationWithString();
	}
}
