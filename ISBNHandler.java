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

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ISBNHandler implements ActionListener
{
    protected ISBNVerifierGUI gui;
   
    //pass ISBNVerifierGui
    public ISBNHandler(ISBNVerifierGUI gui)
    {
        this.gui = gui;
    }
    
    //actions performed by program 
    public void actionPerformed(ActionEvent e)
    {
        //validate button action
        if(e.getSource() == gui.validateButton) 
        {
            
            try
            {
                //try to validate ISBN 
                gui.isbn.getISBN();
            }
            //catch the custom exception error
            catch(ISBNException error)
            {
                //append JTextArea with error message
                gui.status.append(error.getMessage());
            }
        }
        
        //exit button action
        if(e.getSource() == gui.exitButton)
        {
            //exit the program
            System.exit(0);
        }
        
    }
     
}
