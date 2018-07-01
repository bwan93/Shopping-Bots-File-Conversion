import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Eve {
	
	public static File inputFile = new File("C:/Users/chris/Desktop/ProgForBen/Master File.csv");
	public static File outputFile = new File("C:/Users/chris/Desktop/ProgForBen/NewEve.xml");
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedWriter bwStart = null;
		BufferedWriter bwEnd = null;
		
		String line = "";
		String csvSplitBy = ",";
		
		//beginning of file
		try {
			bwStart = new BufferedWriter(new FileWriter(outputFile));
			bwStart.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
					"<ArrayOfProfile xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
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
		
		//end of file
		try {
			bwEnd = new BufferedWriter(new FileWriter(outputFile, true));
			bwEnd.write("</ArrayOfProfile>");
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
	
	//given each profile in a csv line, addProfile writes data to the file
	public static void addProfile(String[] data) {
		BufferedWriter bwProfile = null;
		try {
			bwProfile = new BufferedWriter(new FileWriter(outputFile, true));
			bwProfile.write("  <Profile>\r\n" + 
					"    <ProfileName>" + data[0] + "</ProfileName>\r\n" + 
					"    <BillingFirstName>" + data[1] + "</BillingFirstName>\r\n" + 
					"    <BillingLastName>" + data[2] + "</BillingLastName>\r\n" + 
					"    <BillingAddressLine1>" + data[3] + "</BillingAddressLine1>\r\n" + 
					"    <BillingAddressLine2>" + data[4] + "</BillingAddressLine2>\r\n" + 
					"    <BillingCity>" + data[6] + "</BillingCity>\r\n" + 
					"    <BillingState>" + data[7] + "</BillingState>\r\n" + 
					"    <BillingCountryCode>" + data[9] + "</BillingCountryCode>\r\n" + 
					"    <BillingZip>" + data[10] + "</BillingZip>\r\n" + 
					"    <BillingPhone>" + data[11] + "</BillingPhone>\r\n" + 
					"    <BillingEmail>" + data[12] + "</BillingEmail>\r\n" + 
					"    <ShippingFirstName>" + data[13] + "</ShippingFirstName>\r\n" + 
					"    <ShippingLastName>" + data[14] + "</ShippingLastName>\r\n" + 
					"    <ShippingAddressLine1>" + data[15] + "</ShippingAddressLine1>\r\n" + 
					"    <ShippingAddressLine2>" + data[16] + "</ShippingAddressLine2>\r\n" + 
					"    <ShippingCity>" + data[18] + "</ShippingCity>\r\n" + 
					"    <ShippingState>" + data[19] + "</ShippingState>\r\n" + 
					"    <ShippingCountryCode>" + data[21] + "</ShippingCountryCode>\r\n" + 
					"    <ShippingZip>" + data[22] + "</ShippingZip>\r\n" + 
					"    <ShippingPhone>" + data[23] + "</ShippingPhone>\r\n" + 
					"    <ShippingEmail>" + data[24] + "</ShippingEmail>\r\n" + 
					"    <NameOnCard>" + data[25] + "</NameOnCard>\r\n" + 
					"    <CreditCardNumber>" + data[26] + "</CreditCardNumber>\r\n" + 
					"    <ExpirationMonth>" + data[27] + "</ExpirationMonth>\r\n" + 
					"    <ExpirationYear>" + data[28] + "</ExpirationYear>\r\n" + 
					"    <Cvv>" + data[29] + "</Cvv>\r\n" + 
					"    <CardType>" + data[30] + "</CardType>\r\n" + 
					"    <OneCheckoutPerWebsite>" + data[31] + "</OneCheckoutPerWebsite>\r\n" + 
					"    <SameBillingShipping>" + data[32] + "</SameBillingShipping>\r\n" + 
					"  </Profile>\n");
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
