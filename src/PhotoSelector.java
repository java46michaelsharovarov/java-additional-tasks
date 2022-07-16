import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  This example demonstrates how file names could be selected 
 *  by different criteria: Location, Date, Period of time, type of file -
 *  using Regular exception
 */
public class PhotoSelector {
	/*
	 * Full list of picture file Names for selection in format:
	 * folder\\YYYYMMDD_hhmmss.ext, where:
	 *    folder - name of folder equal to location where picture was taken
	 *    YYYY, MM, DD - year, month, day
	 *    hh,mm,ss - hours, minutes, seconds
	 */
	private static final String pictures[] = {
		"Paris\\20140101_090000.jpg",
		"Paris\\20140201_121005.jpg",				
		"Paris\\20150301_211035.jpg",				
		"Paris\\20150401_110023.gif",
		"Paris\\20150401_181705.jpg",				
		"Paris\\20150501_231035.gif",				
		"London\\20140205_090000.jpg",
		"London\\20140205_121005.jpg",				
		"London\\20140601_211035.gif",				
		"London\\20151001_110023.jpg",
		"London\\20151001_121705.jpg",				
		"London\\20151001_231035.jpg",
		"Chicago\\20150301_120001.png",
		"Chicago\\20151111_232000.png"
	};

	/**
	 * Prints list of picture file Names due to filtering criterion
	 * @param regex The filtering criterion 
	 */
	static void selectPictures(String title, String regex) {
		System.out.printf("%n%s%n------------------------%n", title);
        Pattern pattern = Pattern.compile(regex);
        for (String picture: pictures) {
        	if (pattern.matcher(picture).find()) {
        		System.out.println(picture);
        	}
        }
	}
	
	/**
	 * Selects pictures due to regular expression typed by user
	 */
	private static void selectCustom() {
		Scanner scanner = new Scanner(System.in);
		while(true){					
        	System.out.printf("%n=====>Enter your regex:");
        	String regex = scanner.nextLine();
        	if (regex.isEmpty()) 
        		break;
        	selectPictures("Custom:" + regex, regex);
		}
		scanner.close();
		System.out.println("\n=====>Good bye");
	}
	
	/**
	 * Testing example
	 */
	public static void main(String[] args){
		
		/*======== Uncomment this test to work in dialog mode ======*/
		//selectCustom();
		
		// Test 1. All London pictures
		selectPictures("All London pictures", "London");

		// ====> TODO: Write the following tests ==========
		// Test 2. All Europe pictures
		selectPictures("All Europe pictures", "Paris|London");
		// Test 3. All autumn pictures
		selectPictures("All autumn pictures", "[a-zA-Z]+\\\\[\\d]{4}(09|1[0-2])");
		// Test 4  All 2015 spring pictures
		selectPictures("All 2015 spring pictures", "[a-zA-Z]+\\\\2015(03|0[45])");
		// Test 5. All night pictures (from 18:00 till 24:00)
		selectPictures("All night pictures (from 18:00 till 24:00)", "[a-zA-Z]+\\\\[\\d]{8}_(1[89]|2[0-4])[0-5]\\d");
		// Test 6. All night pictures from Chicago
		selectPictures("All night pictures from Chicago", "Chicago\\\\[\\d]{8}_(1[89]|2[0-4])[0-5]\\d");
		// Test 7. All jpg and png pictures
		selectPictures("All jpg and png pictures", "[a-zA-Z]+\\\\[\\d]{8}_\\d{6}.(jpg|png)"); //".(jpg|png)"
		// Test 8* All pictures taken in dates with equal number of month and day
		selectPictures("All pictures taken in dates with equal number of month and day", "[a-zA-Z]+\\\\[\\d]{4}(\\d\\d)\\1");
	}
}