package consoleUI;

import java.util.Scanner;

public class UtilsUIValide {

	private static Scanner reader = new Scanner(System.in);
	
	public boolean valideInt(String text){
		boolean valid = false;
		try {
			Integer.parseInt(text);
			valid = true;
		} catch (NumberFormatException exception) {
			throw new UtilsUIException(UtilsUIException.NotInteger);
		}
		return valid;
	}
}
