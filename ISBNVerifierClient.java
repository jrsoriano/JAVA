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

import java.awt.*;  import javax.swing.*;

public class ISBNVerifierClient extends JFrame
{
   final static private int WIDTH= 450, HEIGHT= 200;//Window width & height
   private Container       c;    // A reference to the frame's content pane
   private ISBNVerifierGUI gui;             // A reference to the GUI class

   /**
      Constructor
   */
  
   public ISBNVerifierClient()
   {
      // Get an instance of the content pane
      c = getContentPane();         
      
      // Add the GUI to the content pane
      c.add(gui= new ISBNVerifierGUI());    

      // JFrame setup parms:
      setTitle("ISBN Validator");
      setSize(WIDTH,HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
       
   }

   public static void main(String[] args) { new ISBNVerifierClient(); }

}// end ISBNVerifierClient class
