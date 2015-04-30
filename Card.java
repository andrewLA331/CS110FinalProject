/*
Andrew Allen
CS110
Card Class
*/
//This class creates a card object.
public class Card
{
   public static final int CLUBS = 1;
   public static final int DIAMONDS = 2;
   public static final int HEARTS = 3;
   public static final int SPADES = 4;
   
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   
   private int rank;
   private int suit;
   
   public void Card(int r, int s)
   {
      rank = r;
      suit = s;
   }
     
   public int getSuit()
   {
      return suit;
   }
   
   public int getRank()
   {
      return rank;
   }
   
   public String toString()
   {
      String cardSuit;
      
      if(suit == CLUBS)
      { 
         cardSuit = "Clubs";
      }
      else if(suit == DIAMONDS)
      {
         cardSuit = "Diamonds";
      }
      else if(suit == HEARTS)
      {
         cardSuit = "Hearts";
      }
      else
      {
         cardSuit = "Spades";
      }
      
      String cardRank;
      
      if(rank == ACE)
      {
         cardRank = "Ace";
      }
      else if(rank == JACK)
      {
         cardRank = "Jack";
      }
      else if(rank == QUEEN)
      {
         cardRank = "Queen";
      }
      else if(rank == KING)
      {
         cardRank = "King";
      }
      else
      {
         cardRank = Integer.toString(rank);
      }
      
      return (cardRank + " of" + cardSuit);
   }
   
   public boolean equals(Card otherCard)
   {
      if(this.toString().equals(otherCard.toString()))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public String getCardImage()
   {
      String cardSuit;
      
      if(suit == CLUBS)
      {
         cardSuit = "c";
      }
      else if(suit == DIAMONDS)
      {
         cardSuit = "d";
      }
      else if(suit == HEARTS)
      {
         cardSuit = "h";
      }
      else
      {
         cardSuit = "s";
      }
      
      String cardRank;
      
      if(rank == ACE)
      {
         cardRank = "ace";
      }
      else if(rank == JACK)
      {
         cardRank = "jack";
      }
      else if(rank == QUEEN)
      {
         cardRank = "queen";
      }
      else if(rank == KING)
      {
         cardRank = "king";
      }
      else
      {
         cardRank = Integer.toString(rank);
      }
      
      return ("cardpics/" + cardRank + cardSuit + ".jpg");
   }
}
