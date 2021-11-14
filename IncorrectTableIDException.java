/**
 * Represents an exception when table ID cannot be found
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-14
 */
public class IncorrectTableIDException extends Exception{
    /*
     * Empty Constructor
     */
	public IncorrectTableIDException(){
        super("Table ID cannot be found in List!");
    }
	/*
	 * Creates an IncorrectTableIDException with message.
	 * @param message to be produced when Exception encountered.
	 */
    public IncorrectTableIDException(String message){
        super(message);
    }
}
