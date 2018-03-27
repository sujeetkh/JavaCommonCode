package in.iisc.csa.sujeet.common.utils;

import org.apache.commons.lang.RandomStringUtils;
//join example
public class StringExamples {
	public static void spliting() {
		String log = "2018-01-02 08:47UTC|abc|10.999.11.211|{\"v\": \"1\", \"ov\": \"7.0\", \"di\": \"and:4f246a02f1318ccab\", \"r\": 151483210, \"os_ver\": 24, \"nw\": 3}";
		String[] arr = log.split("\\|");
		for (String val : arr)
			System.out.println(val);
	}

	public static void format() {
		String localFilePath = String.format("/tmp/reader_%s_%s.orc", "abc", System.currentTimeMillis());
		System.out.println(localFilePath);
	}

	public static void randomString() {
		String str = RandomStringUtils.randomAlphanumeric(16);
		System.out.println(str);
	}

	public static void main(String[] args) {
		randomString();
	}
}
