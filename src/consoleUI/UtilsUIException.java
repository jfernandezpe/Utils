package consoleUI;

public class UtilsUIException extends Exception {
	
	private int error = 0;
	public final static int NotInteger = -1;
	public final static int NotString = -2;
	public final static int NotDouble = -3;
	
	UtilsUIException(){
		super();
	}
	UtilsUIException(int e){
		error = e;
	}
	public int getProblem() {
		return error;
	} 
}
