import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;
import java.util.Scanner;

public class Player{

    public String name,slapKey,noSlapKey;
    public int x,y, rotation;
    public boolean slapped;
    public Queue<Card> hand=new ConcurrentLinkedQueue<Card>();
    public ArrayList<Card> UnoHand = new ArrayList<Card>();
    // Computer
    public Player(int c){
	name="Comp"+c;
	if(c==1){
	    x=414;
	    y=500;
	    rotation=0;
	}else if(c==2){
	    x=800;
	    y=264;
	    rotation=90;
	}else if(c==3){
	    x=414;
	    y=4;
	    rotation=180;
	}else{
	    x=4;
	    y=264;
	    rotation=270;
	}
    }

    //Different contructor for real player
    public Player(String name, int c){
	this.name=name;
	if(c==1){
	    x=414;
	    y=500;
	    rotation=0;
	}else if(c==2){
	    x=800;
	    y=264;
	    rotation=90;
	}else if(c==3){
	    x=414;
	    y=4;
	    rotation=180;
	}else{
	    x=4;
	    y=264;
	    rotation=270;
	}
    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }

    public String getName(){
	return name;
    }

    public boolean hasSlapped(){
	return slapped;
    }

    public String toString(){
	return name+": "+printHand();
    }

    public boolean hasCards(){
	return !hand.isEmpty();
    }

    public Queue<Card> getHand(){
	return hand;
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

    public synchronized void keyPressed(KeyEvent e){	
	int key = e.getKeyCode();
	if(key == KeyEvent.VK_SPACE){
	    slapped=true;
	}else{
	    slapped=false;
	}
    }

    public synchronized void keyReleased(KeyEvent e){	
	int key = e.getKeyCode();
	if(key == KeyEvent.VK_SPACE){
	    slapped=false;
	}else{
	    slapped=true;
	}
    }

}
