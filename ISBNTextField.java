/**
 * 
 * This application will validate ISBN-10 number entered into a custom TextField object and throw custom exceptions if ISBN-10 is invalid.
 * 
 * @author Jose R. Soriano
 * @version 1.0
 * 
 * Date Created: 03.12.2016
 * Last Update: 03.23.2016
 *
**/

import javax.swing.*;
import java.awt.*;

//custom text field which excepts Integers extends JTextField
public class ISBNTextField extends JTextField 
{
    protected String isbn;
    protected String error;
   
    /**
     * constructor
     */
    //object to instantiate a 20 column TextField
    public ISBNTextField(int size)
    {
        super(20);
    }
    
    
    /**
     * methods
     */
    //method to retrieve isbn and strip out all non alpha-numeric characters
    public String getISBN() throws ISBNException
    {
        this.isbn = isbn;
        isbn = getText();
        isbn = isbn.replaceAll("( |-)","");
        isbn = validateISBN(isbn);
        return isbn;
    }
    
    
    //validate ISBN entered, by passing isbn string entered 
    private String validateISBN(String isbn) throws ISBNException
    {     
        
        //is isbn is less than ten characters 
        if(isbn.length() != 10)
        {
            error = "ISBN # " + isbn + " must be 10 characters long\n";
            throw new ISBNException(error);
        }
        try
        {
            Integer.parseInt(isbn.substring(0,8));
        }
        catch(NumberFormatException e)
        {
            //error if any of the first nine characters are not digits 
            error = "ISBN # " + isbn + " must contain all digits and an 'X' in the last position\n";
            throw new ISBNException(error);
        }
        checkDigit(isbn);
        return isbn;
    }
    
    //check digit returns true if valid 
    public boolean checkDigit(String isbn) throws ISBNException
    {
        // holds checksum for comparison
        int checkSum = 0;
        
        //string to hold X 
        String lastLetter = isbn.substring(9);
        
        //check string for X 
        if(!lastLetter.equalsIgnoreCase("X"))
        {
           //if isbn is nine character but has X as the tenth
           try
           {
               checkSum = Integer.parseInt(lastLetter);
           }
           catch(NumberFormatException e)
           {
               error = "ISBN # " + isbn + " must contain all digits and an 'X' in the last position\n";
               throw new ISBNException(error);     
           }
           
        }
        else
        {
            //X equals the checksum    
            checkSum = 10;
        }
        
        
        //holds sum of the first nine isbn digits 
        int sum = 0;

        for(int i = 0; i < isbn.length()-1; i++)
        {
            String letter = "" + isbn.charAt(i);
            
            if(letter.equalsIgnoreCase("-"))
            {
                continue;
            }
            
            int number = Integer.parseInt(letter);
            sum += ((number*(i+1)));
        }
            
        //use mod 11 to determine check digit
        sum = sum % 11;
         
        
        if(checkSum != sum)
        {
            //if sum not equal to checkSum 
            error = "ISBN # " + isbn + " has an invalid check digit\nValid ISBN # should be " + isbn.substring(0,9) +"-"+ sum +"\n";   
            throw new ISBNException(error);
        }
        else if(checkSum != sum && !isbn.matches("^\\d{9}[\\d|X]$"))
        {
            error = "ISBN # " + isbn + " has an invalid check digit\nValid ISBN # should be " + isbn.substring(0,9) +"-X\n";   
            throw new ISBNException(error); 
        }
        else
        {
            //if sum = 0 its valid
            error = "ISBN # " + isbn + " is valid\n";
            throw new ISBNException(error);
            
        }
        
    }
   
    
    
     
}

        
        
       

    


 


    
   
   

     
     

    

              
             
              
              
              
             
    
    
    
    

        

