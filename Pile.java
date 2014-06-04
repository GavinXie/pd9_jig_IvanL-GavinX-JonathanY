import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.*;

public class Pile{

    //variables
    public ArrayList<Card> pile=new ArrayList<Card>();
    public int cardCount;

    //pile is intially created having no cards
    public Pile(){
	cardCount=0;
    }
    //Less restrictive add catered to allow a card to be added in the beginning of Crazy Eights.
    public void addCard(Card a){
    	pile.add(a);
    	cardCount++;
    	System.out.println(a);
    }
    //First card is taken from player's hand and added to the pile
    public boolean addCard(Player player){
	Player temp=new Player();
	Card card=player.getCard();

	//if the player cannot put any more cards in the pile, he has lost 
	if(card.equals(null)){
	    System.out.println(player.getName()+" has lost");
	} 
	//if he can add a card, he does and the card count increments
	else{
	    pile.add(card);
	    cardCount++;
	
	}
	//if the value of the card is the same as the current count 
	if(cardCount%13==card.getValue()||card.getValue()==11){
	    return true;
	}else
	    {return false;
	}
    }

    //the player wins the pile
    public void shuffleInto(Player hand){
	System.out.println(hand.getName()+" has won all "+ pile.size()+" cards.");
	while(pile.size()>0){
	    Random rand=new Random();
	    int a=pile.size();
	    int x=rand.nextInt(a);
	    hand.add(pile.get(x));
	    pile.remove(x);
	}
    }
}

		  
