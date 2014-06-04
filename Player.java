import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;
import java.util.Scanner;

public class Player{

    public String name,slapKey,noSlapKey;
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

    public boolean hasCards(){
	return !hand.isEmpty();
    }

    //prints out the hand
    //removes Hand, must have problem somewhere...
    public String printHand(){
	Queue<Card> temp;
	temp=hand;
	String s="";
	while(temp.peek()!=null){
	    s=s+temp.poll()+" ";
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
	Scanner s = new Scanner(System.in);
	String cmd = s.nextLine();
	Boolean yesNO=true;
	if(cmd.equals(" ")){
	}else{
	    yesNO=false;
	}
	if(pile.shouldSlap()==true&&yesNO==true){
	    return true;
	}else{
	    return false;
	}
    }

}
