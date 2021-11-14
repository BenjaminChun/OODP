/**
 * Represents an exception when table ID cannot be found
 * @author Tan Zheng Kai
 * @version 1.0
 * @since 2021-11-14
 */
public class IncorrectTableIDException extends Exception{
    public IncorrectTableIDException(){
        super("Table ID cannot be found in List!");
    }
    public IncorrectTableIDException(String message){
        super(message);
    }
}
