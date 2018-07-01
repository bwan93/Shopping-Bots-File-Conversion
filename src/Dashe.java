import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Dashe {
	
	public static File inputFile = new File("C:/Users/chris/Desktop/ProgForBen/Master File.csv");
	public static File outputFile = new File("C:/Users/chris/Desktop/ProgForBen/NewDashe.json");
	
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
			bwStart.write("{");
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
						bwEnd.write("}");
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
			bwProfile = new BufferedWriter(new FileWriter(outputFile, true));
			bwProfile.write("\"" + data[0] + "\"" 
			//same as billing address?//
			+ ":{\"address\":\"" + data[3] 
			+ "\",\"apt\":\"" + data[5] 
			+ "\",\"billingAddress\":\"" + data[3]
			+ "\",\"billingApt\":\"" + data[5]
			+ "\",\"billingCity\":\"" + data[6]
			+ "\",\"billingCountry\":\"" + data[8]
			+ "\",\"billingFirstName\":\"" + data[1]
			+ "\",\"billingLastName\":\"" + data[2]
			+ "\",\"billingMatch\":\"" + data[32]
			+ "\",\"billingPhone\":\"" + data[11]
			+ "\",\"billingZipCode\":\"" + data[10]
			+ "\",\"cardCvv\":\"" + data[29]
			+ "\",\"cardExpiry\":\"" + data[27] + "/" + data[28]
			+ "\",\"cardName\":\"" + data[25]
			+ "\",\"cardNumber\":\"" + data[26]
			//TODO: should below be SHIPPING info now?
			+ "\",\"city\":\"" + data[6]
			+ "\",\"country\":\"" + data[8]
			//TODO: which email?
			+ "\",\"email\":\"" + data[12]
			+ "\",\"firstName\":\"" + data[1]
			+ "\",\"lastName\":\"" + data[2]
			+ "\",\"oneUseOnly\":\"" + data[33]
			//!formatting!//
			+ "\",\"phone\":\"" + data[11]
			+ "\",\"state\":\"" + data[7]
			+ "\",\"zipCode\":\"" + data[10] + "\"}");
		} catch (IOException e) {
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
