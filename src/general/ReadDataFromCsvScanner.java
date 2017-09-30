package general;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromCsvScanner {
	
	public static void main(String[] args) {
		String myFile = "/Volumes/edu/MapReduce/assignment_1/1763.csv";
		File file = new File(myFile);
		List<String> res = new ArrayList<String>();
		
		try {
			Scanner inputStream = new Scanner (file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				System.out.println(data);
				res.add(data);
			}
			inputStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
