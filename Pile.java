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

    public String toString(){
	String pilePrint ="Pile: ";
	for(int x=0;x<pile.size();x++){
	    pilePrint=pilePrint+pile.get(x)+" ";
	}
	return pilePrint;
    }
    
    public Card getTop(){
	return pile.get(pile.size()-1);
    }

    //First card is taken from player's hand and added to the pile
    public void addCard(Player player){
	Player temp=new Player();
	Card card=player.getCard();
	/*
	//if the player cannot put any more cards in the pile, he has lost 
	if(card.equals(null)){
	    System.out.println(player.getName()+" has lost");
	} 
	//if he can add a card, he does and the card count increments
	*/
	
	    pile.add(card);
	    cardCount++;
    }
   //Less restrictive add catered to allow a card to be added in the beginning of Crazy Eights.
     public void addCard(Card a){
    	pile.add(a);
    	cardCount++;
    	System.out.println(a);
     }
     
    public boolean shouldSlap(){
	Card card=pile.get(pile.size()-1);
	//if the value of the card is the same as the current count 
	if(cardCount%13==card.getValue()||card.getValue()==11){
	    return true;
	}else{
	    return false;
	}
    }

    //the player wins the pile
    public void shuffleInto(Player hand){
	System.out.println(hand.getName()+" has won all "+ pile.size()+" cards.");
	int a=pile.size();
	for(int i=0;i<a;i++){
	    System.out.println("WorkPlaceX"+pile.size());
	    Random rand=new Random();
	    int r=pile.size();
	    int x=rand.nextInt(r);
	    hand.addCard(pile.get(x));
	    pile.remove(x);
	    System.out.println(hand);
	}
	System.out.println("Mission Accomplished");
    }
}

		  
