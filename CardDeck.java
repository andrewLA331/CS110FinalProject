/*
Andrew Allen
CS110
Card Deck Class
*/
//This class creates a deck of cards from card objects created by the
//card class and gets passed to get shuffled.
import java.util.Random;

public class CardDeck extends ShuffledDeck
{
   
   public CardDeck()
   {      
      for(int i = 0;i < 1000; i++)
      {
         Random random = new Random();
         int num = random.nextInt(52);
         add(num);
         remove(num);
      }
   }
}

