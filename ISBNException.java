/**
 * Assignment 3 Creating Exceptions
 * This application will validate ISBN-10 number entered into a custom TextField object and throw custom exceptions if ISBN-10 is invalid.
 * 
 * @author Jose R. Soriano
 * @version 1.0
 * 
 * Assignment: #3
 * Course: ADEV-1001 (OPEN) Programming (Java 2)
 * Section: Online
 * Date Created: 03.12.2016
 * Last Update: 03.23.2016
**/

//custom exceptions
public class ISBNException extends Exception
{
    //default argument method
    public ISBNException(String error)
    {
        super(error);
    }
    //excepts a cause 
    public ISBNException(Throwable cause)
    {
        super(cause);
    }
    //excepts argument and cause
    public ISBNException(String error, Throwable cause)
    {
        super(error, cause);
    } 
    
}
