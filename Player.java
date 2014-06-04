import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;

public class Player{

    public String name;
    public Queue<Card> hand=new ConcurrentLinkedQueue<Card>();
    // Computer
    public Player(){
	name="Comp";
    }

    //Different contructor for real player
    public Player(String name){
	name=this.name;
    }

    public String getName(){
	return name;
    }

    //prints out the hand
    public String printHand(){
	Queue<Card> temp;
	temp=hand;
	int size=hand.size();
	for(int x=0;x<size;x++){
	    temp.add(hand.peek());
	    hand.remove(hand.peek());
	}
	String hand="";
	while(temp.peek()!=null){
	    hand=hand+temp.poll()+" ";
	}
	return hand;
    }
    //adds the card to your hand
    public void addCard(Card card){
	hand.add(card);
    }

    //takes the card out of tyour hand and returns it
    public Card getCard(){
	return hand.poll();
    }

}
