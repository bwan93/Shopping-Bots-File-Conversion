import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Wop {
	
	public static File inputFile = new File("User Profile.csv");
	public static File outputFile = new File("C:/Users/chris/Desktop/ProgForBen/NewWop.json");
	
	public static void main(String[] args) {
	
		BufferedReader br = null;
		BufferedWriter bwStart = null;
		BufferedWriter bwSeparator = null;
		BufferedWriter bwEnd = null;
		
		String line = "";
		String csvSplitBy = ",";
		
		//beginning of file
		try {
			bwStart = new BufferedWriter(new FileWriter(outputFile));
			bwStart.write("[");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bwStart != null) {
				try {
					bwStart.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//reading in csv data
		try {
			br = new BufferedReader(new FileReader(inputFile));
			//ignore first line
			br.readLine();
			while ( (line = br.readLine()) != null ) {
				String [] csvData = line.split(csvSplitBy);
				//write to output file
				addProfile(csvData);
				System.out.println("Successfully added profile " + csvData[0]);
				br.mark(10000);
				//add comma after profile if there are still more profiles
				if ((line = br.readLine()) != null) {
					try {
						bwSeparator = new BufferedWriter(new FileWriter(outputFile, true));
						bwSeparator.write(",");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (bwSeparator != null) {
							try {
								bwSeparator.close();
								br.reset();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				//close-off profiles
				else {
					try {
						bwEnd = new BufferedWriter(new FileWriter(outputFile, true));
						bwEnd.write("]");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (bwEnd != null) {
							try {
								bwEnd.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) { 
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//given each profile in a csv line, addProfile writes data to the file
	public static void addProfile(String[] data) {
		BufferedWriter bwProfile = null;
		try {
			//TODO: assume all data is shipping or billing?
			bwProfile = new BufferedWriter(new FileWriter(outputFile, true));
			bwProfile.write("{\"profileName\":\"" + data[0] 
			+ "\",\"city\":\"" + data[6]
			+ "\",\"phone\":\"" + data[11]
			+ "\",\"zipcode\":\"" + data[10]
			+ "\",\"firstName\":\"" + data[1]
			+ "\",\"lastName\":\"" + data[2]
			+ "\",\"country\":\"" + data[8]
			+ "\",\"address\":\"" + data[3]		
			+ "\",\"address2\":\"" + data[4]
			+ "\",\"state\":\"" + data[7]
			//TODO: which email?
			+ "\",\"email\":\"" + data[12]		
			+ "\",\"cardNumber\":\"" + data[14]
			+ "\",\"cardExpMonth\":\"" + data[15]
			+ "\",\"cardExpYear\":\"" + data[16]
			+ "\",\"cardCVV\":\"" + data[17]
			+ "\",\"countryCode\":\"" + data[9]
			+ "\",\"shipcountryCode\":\"" + data[9] + "\"}"
			);
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bwProfile != null) {
				try {
					bwProfile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
