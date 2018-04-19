package in.iisc.csa.sujeet.common.datascience;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CleanData {

	public static void main(String[] args) throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get(
				"/Users/admin/AnacondaProjects/DataScience/patients_classification/data/patient_monthwise_revenue_train.csv"));
		List<String> newData = new ArrayList<String>();
		for (String line : allLines) {
			line = line.replace("\\N", "");
			newData.add(line);
			System.out.println(line);
		}
		FileOutputStream outputStream = new FileOutputStream(
				"/Users/admin/AnacondaProjects/DataScience/patients_classification/data/tmp.csv");
		outputStream.write(String.join("\n", newData).getBytes());
		outputStream.close();
	}

}
