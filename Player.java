import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;
import java.util.Scanner;

public class Player{

    public String name,slapKey,noSlapKey;
    public Queue<Card> hand=new ConcurrentLinkedQueue<Card>();
    public ArrayList<Card> UnoHand = new ArrayList<Card>();

    // Computer
    public Player(){
	name="Comp";
    }

    //Different contructor for real player
    public Player(String name){
	this.name=name;
    }

    public String getName(){
	return name;
    }

    public String toString(){
	return name+": "+printHand();
    }

    public boolean hasCards(){
	return !hand.isEmpty();
    }

    //prints out the hand
    //removes Hand, must have problem somewhere...
    public String printHand(){
	String s = "";
	for (Card c: hand){
	    s = s + c + " ";
	}
	return s;
    }

    //adds the card to your hand
    public void addCard(Card card){
	hand.add(card);
    }

    //takes the card out of tyour hand and returns it
    public Card getCard(){
	Card card=hand.peek();
	hand.remove();
	return card;
    }

    public boolean toSlap(Pile pile){
	System.out.println(name+", please enter <space> to slap or anything else to pass. ");
	Scanner s = new Scanner(System.in);
	String cmd = s.nextLine();
	Boolean yesNO=true;
	if(cmd.equals(" ")){
	    return true;
	}else{
	    return false;
	}
    }

}
