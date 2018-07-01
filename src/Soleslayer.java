import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
public class Soleslayer {
	
	public static File inputFile = new File("C:/Users/chris/Desktop/ProgForBen/Master File.csv");
	public static File outputFile = new File("C:/Users/chris/Desktop/ProgForBen/NewSoleslayer.txt");
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedWriter bwStart = null;
		
		String line = "";
		String csvSplitBy = ",";
		
		//beginning of File
		try {
			bwStart = new BufferedWriter(new FileWriter(outputFile));
			bwStart.write("Profile Name\tEmail Address\tCard Type\tCard Number\tCard CVV\tCard Expires\tBilling Country\tBilling Phone\tBilling First\tBilling Last\tBilling Street 1\tBilling Street 2\tBilling Zip\tBilling City\tBilling State\tShipping Country\tShipping Phone\tShipping First\tShipping Last\tShipping Street 1\tShipping Street 2\tShipping Zip\tShipping City\tShipping State\r\n");
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
			bwProfile.write(data[0] + "\t"					//Profile Name//
						//TODO: billing or shipping email?
						+ data[12] + "\t"					//Email Address//
						+ data[30] + "\t"					//Card Type//
						+ data[26] + "\t"					//Card Number//
						+ data[29] + "\t"					//Card CVV//
						+ data[27] + "/" + data[28] + "\t"	//Card Expires//
						//!data!//
						+ data[9] + "\t"					//Billing Country//
						+ data[11] + "\t"					//Billing Phone//
						+ data[1] + "\t"					//Billing First//
						+ data[2] + "\t"					//Billing Last//
						+ data[3] + "\t"					//Billing Street 1//
						+ data[4] + "\t"					//Billing Street 2//
						+ data[10] + "\t"					//Billing Zip//
						+ data[6] + "\t"					//Billing City//
						+ data[7] + "\t"					//Billing State//
						//!data!//
						+ data[21] + "\t"					//Shipping Country//
						+ data[23] + "\t"					//Shipping Phone//
						+ data[13] + "\t"					//Shipping First//
						+ data[14] + "\t"					//Shipping Last//
						+ data[15] + "\t"					//Shipping Street 1//
						+ data[16] + "\t"					//Shipping Street 2//
						+ data[22] + "\t"					//Shipping Zip//
						+ data[18] + "\t"					//Shipping City//
						+ data[19] 							//Shipping State//
						+ "\t\t\t\t\t\t\t\t\t\r\n");	
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
