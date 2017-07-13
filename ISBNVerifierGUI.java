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

import java.awt.*; 
import javax.swing.*;

public class ISBNVerifierGUI extends JPanel
{
   /**
    * fields
    */
  protected JPanel isbnPanel, buttonPanel;      
  // Replace the textfield with your custom control
  protected ISBNTextField isbn;         //  A custom control for the ISBN number
  protected JTextArea     status;      // Used to display status and error messages
  protected JButton       validateButton, // Validates the entered ISBN #
                          exitButton;     // Exits the application
  //add custom handler
  ISBNHandler handler = new ISBNHandler(this);
                        
   /**
      Constructor
   */
  
   public ISBNVerifierGUI()
   {
      // Set JPanel layout as Border
      setLayout(new BorderLayout()); 
      
      // Build the three components for the North, Center and South
      buildISBNPanel();
      JScrollPane sPane = new JScrollPane( status= new JTextArea(20, 20) );
      buildButtonPanel();
      
      // Add the components to the JPanel
      add(isbnPanel,   BorderLayout.NORTH);
      add(sPane,       BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
  }

  /** 
    The buildISBNPanel method creates a panel containing the
    ISBN prompt label and textfield  
  */
 
  private void buildISBNPanel()
  {
      // create the panel with a FlowLayout
      isbnPanel = new JPanel(new FlowLayout());

      // Add label and custom control to the panel
      isbnPanel.add(new JLabel("Enter ISBN-10 #: ")); 
      isbnPanel.add(isbn = new ISBNTextField(20));

  }// end buildISBNPanel() method

  /**
    The buildButtonPanel method creates a panel containing
    buttons.
  */
 
  private void buildButtonPanel()
  {
     //Create the button pannel, buttons & add buttons
     buttonPanel = new JPanel();
     buttonPanel.add( validateButton= new JButton("Validate ISBN") );
     buttonPanel.add( exitButton    = new JButton("Exit") );

     // Add an action listener to the validate and exit buttons.
     validateButton.addActionListener(handler);
     exitButton.addActionListener(handler);

  }// end buildButtonPanel() method\

}// end ISBNVerifierGUI class
