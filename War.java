/*
Andrew Allen
CS110
War Class
*/
//Creates a game of war in relation to the GUI
import java.util.ArrayList;
import java.util.Random;

public class War extends WarGUI
{  
   //Initialize fields and instances
   boolean winner = false;
   boolean warB = false;     
   int round = 0; 
   int num; 
   Card card1;   
   Card card2; 
   Random random = new Random();       
   CardDeck deck = new CardDeck(); 
   ShuffledDeck player1 = new ShuffledDeck();   
   ShuffledDeck player2 = new ShuffledDeck();    
   ArrayList<Card> warHand = new ArrayList<Card>();  
   //calls to deal the cards
   public War() 
   {    
      dealCards();
   }
  //adds cards to hand 
  public void addCards(ShuffledDeck player, Card card1, Card card2)
  {
      Random random = new Random();
      int num = random.nextInt(1);
      
      if(num == 0)
      {
         player.add(card1);
         player.add(card2);
      }
      
      else
      {
         player.add(card2);
         player.add(card1);
      }
  }
  //returns winner  
  public int getWinner()
  {
      if (player1.size() == 0)
      {
         return 2;
      }
      
      else
      {
         return 1;
      }
  }
  //deals the cards
  public void dealCards()
  {   
   for(int i = 1; i<=52; i++)
   {
      Card card = deck.draw();
      if (i != 0)
      {
         player1.add(card);
      }
      
      else
      {
         player2.add(card);  
      }
   }
   
  }
  //return cards in player 1's hand 
  public int getHandSize1()
  {
     return player1.size();
  }
  //return cards in player 2's hand 
  public int getHandSize2()
  {
     return player2.size();    
  }
  //compares card ranks  
  public int battle()
  {
   round++;
    
      try
      {
         card1 = player1.draw();
         card2 = player2.draw();
   
         if((card1.getRank()) > (card2.getRank()))
         {
            addCards(player1, card1, card2);
            return 1;
         }
      
         else if((card1.getRank()) < (card2.getRank()))
         {
            addCards(player2, card1, card2);
            return 2;
         }
         
         else
         {
            return 3;
         }         
      }
      
      catch(NullPointerException e)
      {
         getWinner();
         winner = true;
         return 0;
      } 
  }
    
  public int war()
  {
     try
     {        
        warHand.add(card1);
        warHand.add(card2);
        card1 = player1.draw();
        System.out.println("Player 1 plays a card");
        card2 = player2.draw();
        System.out.println("Player 2 plays a card");
        System.out.println("Player 1 has " + getHandSize1() + " cards");
        System.out.println("Player 2 has " + getHandSize2() + " cards");
        warHand.add(card1);
        warHand.add(card2);
        card1 = player1.draw();
        System.out.println("Player 1 draws a " + card1.toString());
        card2 = player2.draw();
        System.out.println("Player 2 draws a " + card2.toString());
                              
        if((card1.getRank()) > (card2.getRank()))
        {
           player1.add(warHand);
           addCards(player1, card1, card2);
           warHand.clear();
           return 1;
        }
               
        else if((card1.getRank()) < (card2.getRank()))
        {
           player2.add(warHand);
           addCards(player2, card1, card2);
           warHand.clear();
           return 2;         
        }
                  
        else
        {
           return 3;
        }
      }
            
      catch(NullPointerException e)
      {
         getWinner();
         winner = true;
         return 0;
      }        
  }  
  //returns current round
  public int getRound()
  {
      return round;
  }
  
  //returns card image for correlating card
  public String getImage1()
  {
      return card1.getCardImage();
  }
  
  
  public String getImage2()
  {
      return card2.getCardImage();
  }
  
}