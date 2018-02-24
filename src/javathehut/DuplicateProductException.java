package javathehut;
import java.util.Scanner;


public class DuplicateProductException extends Exception
{
    Scanner keyboard = new Scanner(System.in);

    public DuplicateProductException()
    {
        super("Sorry! This product is already on your list.");
    }

    public DuplicateProductException(String message)
    {
        super(message);
    }
}
