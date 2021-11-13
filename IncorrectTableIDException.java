/**
 * 
 * @author 
 * @version 
 * @since 
 */
public class IncorrectTableIDException extends Exception{
    public IncorrectTableIDException(){
        super("Table ID cannot be found in List!");
    }
    public IncorrectTableIDException(String message){
        super(message);
    }
}
