package consoleUI;

import java.util.Scanner;

import Valide.Valide;
import Valide.ValideException;

/**
 * Utilites for the console
 * 
 * @author jfernandezpe
 *
 */
public class UtilsUI {

	private static Scanner reader = new Scanner(System.in);

	/**
	 * Get string to the console
	 * 
	 * @param text
	 * @return
	 */
	public static String getConsole(String text) {
		boolean valid = false;
		String data = null;
		while (!valid) {
			System.out.print(text+": ");
			data = reader.nextLine();
			try {
				Valide.valideStringNotEmpty(data);
				valid = true;
			} catch (ValideException e) {
				printError(e);
			}
		}
		return data;
	}
	

	/**
	 * Get a String for a option
	 * 
	 * @param text
	 * @param options
	 * @return
	 */
	public static String getCololeOption(String text, String[] options, String error){
		boolean valid = false;
		String data = null;
		while(!valid){
			System.out.print(text+": ");
			data = reader.nextLine();
			try {
				data = Valide.valideOption(options,data);
				valid = true;
			} catch (UtilsUIValideException e){
				printError(e);
			}
		}
		return data;		
	}
	
	public static String getCololeOption(String text, String[] options){
		return getCololeOption(text, options, "Not found");
	}
	
	/**
	 * Get int for the console
	 * 
	 * @param text
	 * @return
	 */
	public static int getConsoleInt(String text) {
		return getConsoleInt(text, false, 0);
	}
	
	/**
	 * Get int for the console
	 * 
	 * @param text
	 * @return
	 */
	public static int getConsoleInt(String text, int vdefault) {
		return getConsoleInt(text, true, vdefault);
	}
	
	/**
	 * Get int for the console
	 * 
	 * @param text
	 * @return
	 */
	public static int getConsoleInt(String text, boolean nulltable) {
		return getConsoleInt(text, nulltable, 0);
	}
	
	/**
	 * Get int for the console
	 * 
	 * @param text
	 * @return
	 */
	public static int getConsoleInt(String text, boolean nulltable, int vdefault) {
		boolean valid = false;
		int data = 0;
		while (!valid) {
			System.out.print(text+": ");
			try{
				String tmp = reader.nextLine();
				data = Valide.valideStrint2int(tmp);
				valid = true;
			} catch(UtilsUIValideException e){
				if (nulltable){
					data = vdefault;
					valid = true;
				} else {
					printError(e);
				}
			}			
		}
		return data;
	}

	/**
	 * Get a filename with console.
	 * 
	 * @param text
	 * @return
	 */
	public static String getConsoleFilename (String text, String extension){
		boolean valid = false;
		String data = null;
		while (!valid) {
			System.out.print(text+": ");
			data = reader.nextLine();
			try {
				data = Valide.valideFilename(data, extension);
				valid = true;
			} catch (UtilsUIValideException e) {
				printError(e);
			}
		}
		return data;
	}

	
	/**
	 * Get a double for the console
	 * 
	 * @param text
	 * @return
	 */
	public static Double getConsoleDouble(String text) {
		boolean valid = false;
		String data;
		double number = 0;
		while (!valid) {
			System.out.print(text+": ");
			data = reader.nextLine();
			try {
				number = Valide.valideDouble(data);
				valid = true;
			} catch (ValideException e) {
				printError(e);
			}
		}
		return number;
	}


	/**
	 * Get an option to the menu
	 * 
	 * @param text
	 * @return
	 */
	public static int menu(String text) {
	
		System.out.print(text);
		
		String order = reader.nextLine();
		int option;
		if (order.equals((String) "q")) {
			option = 99;
		} else {
			try {
				option = Integer.parseInt(order);
			} catch (Exception e) {
				option = 0;
			}
		}
		return option;
	}
	
	public static void close(){
		reader.close();
	}
		
	private static void printError(ValideException e) {
		String text = "";
		switch(e.getProblem()){
		case -1:
			text = "No es un número";
			break;
		case -2:
			text = "El string está vacío";
			break;
		case -3:
			text = "No es un double";
			break;
		case -4:
			text = "No se ha encontrado la opcion";
			break;
		default:
			text = "Ha ocurrido un problema";
			break;				
		}
		System.out.println(text);
	}
}
