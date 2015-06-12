package Valide;

import java.util.regex.Pattern;

/**
 * 
 * @author jfernandezpe
 * @version 12/06/2015
 *
 */
public class Valide {

	public static String valideStringNotEmpty(String text) throws ValideException{
		String svoid = "";
		if (text.equals((String) svoid)) {
			throw new ValideException(ValideException.StringEmpty);
		} 
		return text;
	}
	
	
	
	/**
	 * Valide and conver String to Text.
	 * @param text
	 * @return
	 * @throws ValideException
	 */
	public static int valideStrint2int(String text) throws ValideException{
		int number = 0;
		try {
			number = Integer.parseInt(text);
		} catch (NumberFormatException exception) {
			throw new ValideException(ValideException.NotInteger);
		}
		return number;
	}
	
	/**
	 * Valide a option
	 * 
	 * @param options
	 * @param option
	 * @return
	 * @throws ValideException
	 */
	public static String valideOption(String[] options, String option) throws ValideException{
		boolean valid = false;
		option = option.toLowerCase();
		for (int i = 0; i < options.length; i++){
			options[i].toLowerCase();
			if (options[i].equals(option)){
				valid = true;
			}		
		}
		if (!valid){
			throw new ValideException(ValideException.OptionNotFound);
		}
		return option;
	}
	
	/**
	 * Valide a filename
	 * 
	 * @param filename
	 * @param extension
	 * @return
	 * @throws ValideException
	 */
	public static String valideFilename(String filename,String extension) throws ValideException{
		try {
			valideStringNotEmpty(filename);
			String expr = ".*(."+extension+")$";
			boolean cumplePatron = Pattern.matches(expr, filename);
			if (!cumplePatron) {
				filename += "."+extension;
			}
		} catch (ValideException e){
			filename = "";
			throw new ValideException(ValideException.StringEmpty);			
		}
		return filename;
	}
	
	/**
	 * Valide and formate properly double (autoimplement in valideDouble)
	 * 
	 * @param x
	 * @return
	 * @throws ValideException 
	 */
	public static double valideStringQuotesDouble(String x) throws ValideException {
		double y;
		try {
			x = x.replace(",", ".");
			y = Double.parseDouble(x);
		} catch (NumberFormatException exception){
			throw new ValideException(ValideException.NotDouble);
		}
		return y;
	}
	
	/**
	 * Valide and formate properly double (alias of valideStringQuoteDouble);
	 * 
	 * @param x
	 * @return
	 * @throws ValideException
	 */
	public static double valideDouble(String x) throws ValideException{
		return valideStringQuotesDouble(x);
	}
}
