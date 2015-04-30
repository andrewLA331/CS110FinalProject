/*
Andrew Allen
CS110
Shuffled Deck Class
*/
//This class creates an object for final card deck  
import java.util.ArrayList;

public class ShuffledDeck
{
   ArrayList<Card> deck = new ArrayList<Card>();
      
   public void ShuffledDeck(Card[] cardArray, int arraySize)
   {
      for(int i = 0; i < arraySize; i++)
      {
         deck.add(cardArray[i]);
      }  
   } 
   
   public void add(Card card)
   {
      deck.add(card);
   } 
   
   public void add(ArrayList<Card> cardArray)
   {
      for(int i = 0; i < cardArray.size(); i++)
      {
         add(cardArray.get(i));
      }
   }
   //draws card from deck
   public Card draw()
   {
      try
      {
         Card drawnCard = deck.get(0);
         deck.remove(0);
         return drawnCard;
      }
      
      catch(IndexOutOfBoundsException e)
      {
         return null;
      }
   }   
   //return amount of cards in deck
   public int size()
   {
      return deck.size();
   }
          
}