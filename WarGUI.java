/*
Andrew Allen
CS110
War GUI Class
*/
//Creates the GUI for the game of War program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   War war = new War(); 
   //Initialize fields
   String cardBackImg = "cardPics/back.jpg";
   int winner;
   boolean warB = false;  
   JPanel frame;
   Label hand1;
   JLabel hand2;
   JLabel warHand1;
   JLabel warHand2;
   JLabel face1;
   JLabel face2;
   ImageIcon image1;
   ImageIcon image2;
   final int WIDTH = 900;
   final int HEIGHT = 600;
   //main GUI framework and layout
   public WarGUI()
   {
      String name = "A game of war"; 
      setTitle(name);
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(3,0));
      String beginWar = "Begin War"; 
      JButton button = new JButton(beginWar);
      button.addActionListener(new ButtonListener());
                
      ImageIcon cardBack = new ImageIcon(cardBackImg);
      JLabel hand1 = new JLabel(cardBack);
      JLabel hand2 = new JLabel(cardBack); 
      JLabel warHand1 = new JLabel(cardBack);
      JLabel warHand2 = new JLabel(cardBack);
      face1 = new JLabel(cardBack);
      face2 = new JLabel(cardBack);
      
      String startingHand = "26";
      hand1 = new JLabel(startingHand);
      hand2 = new JLabel(startingHand);
      warHand1 = new JLabel("0");
      warHand2 = new JLabel("0"); 
      JLabel label1 = new JLabel("Player 1");
      JLabel label2 = new JLabel("Player 2");
      frame = new JPanel();     
      frame.setLayout(new GridLayout(2,6));
              
      frame.add(hand1);
      frame.add(warHand1);
      frame.add(face1);
      frame.add(face2);
      frame.add(warHand2);
      frame.add(hand2);
      frame.add(hand1);
      frame.add(warHand1);
      frame.add(label1);
      frame.add(label2);
      frame.add(warHand2);
      frame.add(hand2);
      pack();
      setVisible(true);    
   }
   
   //Create actions and outcomes for GUI buttons
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         System.out.println("Round # " + war.getRound());
         winner = war.battle();
         System.out.println(war.getImage1());
         image1 = new ImageIcon(war.getImage1());
         face1.setIcon(image1);
         image2 = new ImageIcon(war.getImage2());
         face2.setIcon(image2);
         JLabel sysMessage;
         sysMessage = new JLabel("");
         if(winner == 0)
         {
            if(war.getWinner() == 1)
            {
               sysMessage.setText("Player 1 wins!");
            }
      
         else
         {
            sysMessage.setText("Player 2 wins!");
         }

         }
         else if(winner == 1)
         {
            sysMessage.setText("Player 1 won this round!");
            hand1.setText(String.valueOf(war.getHandSize1()));
            hand2.setText(String.valueOf(war.getHandSize2()));           
         }
          
         else if(winner == 2)
         {
            sysMessage.setText("Player 2 won this round!");
            hand1.setText(String.valueOf(war.getHandSize1()));
            hand2.setText(String.valueOf(war.getHandSize2()));
         }
          
         else
         {
            sysMessage.setText("It's war!");
            warB = true;
            while(warB == true)
            {
               winner = war.war();
               if(winner == 0)
               {
                  warB = false;
               }
               
               else if(winner == 1)
               {
                  sysMessage.setText("Player 1 won the war!");
                  hand1.setText(String.valueOf(war.getHandSize1()));
                  hand2.setText(String.valueOf(war.getHandSize2()));
                  warB = false;
               }
                         
               else if(winner == 2)
               {
                  sysMessage.setText("Player 2 won the war!");
                  hand1.setText(String.valueOf(war.getHandSize1()));
                  hand2.setText(String.valueOf(war.getHandSize2()));
                  warB = false;
               }
               
               else
               {
                  sysMessage.setText("Keep Going");
               }
            }   
         }
      }         
   }
}