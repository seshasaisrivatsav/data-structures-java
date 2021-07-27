package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromCsvFile {
	
	public static void main(String[] args) throws IOException {
		String csvFile = "/Volumes/edu/MapReduce/assignment_1/1763.csv";
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		List<String> lines = new ArrayList<String>();
		String newLine;
		while((newLine = br.readLine()) != null) {
			System.out.println(newLine);
			lines.add(newLine);
		}
		br.close();
	}

}
