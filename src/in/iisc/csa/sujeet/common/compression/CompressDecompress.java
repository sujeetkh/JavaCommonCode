package in.iisc.csa.sujeet.common.compression;

import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;

import java.io.*;

public class CompressDecompress {

	public static void main(String[] args) throws IOException {
		String str = "Test String";

		FileOutputStream fos = new FileOutputStream("str.txt");
		GZIPOutputStream gzos = new GZIPOutputStream(fos);
		gzos.write(str.getBytes());
		gzos.close();
		FileInputStream fis = new FileInputStream("str.txt");
		GZIPInputStream gzis = new GZIPInputStream(fis);
		// I am taken the size of array as 11 since i know the size.
		// But it should be fetched dynamically.
		byte arr[] = new byte[11];

		gzis.read(arr);
		str = new String(arr);
		System.out.println("==> " + str);
	}

}
