package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.SpringLayout.Constraints;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		int fselect = 420;
		int selection;
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		do {
			try {
				fselect = displayFilterMenu(in);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("That is not a valid option.");
			} catch (java.util.InputMismatchException e) {
				System.out.println("That is not a valid option.");
				in.next();
			}
		} while(fselect == 420);
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(fselect);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int selection) {
		
		// TODO - create some more filters, and add logic to return the appropriate one
		switch (selection) {
			case 1: return new BlueFilter();	
			//TODO - add more filters here
			case 2: return new RedFilter();
			case 3: return new MysteryFilter();
			case 4: return new SepiaFilter();
		}
		
		return null;
	}
	
	private static int displayFilterMenu(Scanner in) {
		System.out.println("Please select a filter to apply.");
		System.out.println("1. Blue");
		System.out.println("2. Red");
		System.out.println("3. Mystery");
		System.out.println("4. Sepia");
		
		int[] options = new int[4];
		int selection = in.nextInt();
		int test = options[selection-1];
		return selection;
	}


}