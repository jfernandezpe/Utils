package Valide;

/**
 * 
 * @author jfernandezpe
 * @version 11/06/2015
 *
 */
public class ValideException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int error = 0;
	public final static int NotInteger = -1;
	public final static int StringEmpty = -2;
	public final static int NotDouble = -3;
	public final static int OptionNotFound = -4;
	
	ValideException(){
		super();
	}
	ValideException(int e){
		error = e;
	}
	public int getProblem() {
		return error;
	} 
}
