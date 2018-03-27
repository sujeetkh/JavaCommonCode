package in.iisc.csa.sujeet.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalFileExamples {
	public static void listFilesRecursively(String path, List<String> collectedFiles) {
		File root = new File(path);
		File[] files = root.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				listFilesRecursively(file.getAbsolutePath(), collectedFiles);
			} else {
				collectedFiles.add(file.getAbsolutePath());
			}
		}
	}

	public static void printFilesRecursively() {
		List<String> filesList = new ArrayList<String>();
		listFilesRecursively("/Users/admin/test/lib", filesList);
		String files = String.join("\n", filesList);
		System.out.println(files);
	}

	public static void localReadWrite() throws IOException {
		String fileData = "writing data to file \n second line";
		FileOutputStream outputStream = new FileOutputStream("/tmp/test_file.txt");
		outputStream.write(fileData.getBytes());
		outputStream.close();
		String data = new String(Files.readAllBytes(Paths.get("/tmp/test_file.txt")));
		System.out.println(data);
	}

	public static void main(String[] args) throws IOException {
		localReadWrite();
	}
}
