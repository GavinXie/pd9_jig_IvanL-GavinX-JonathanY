import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;

public class Players{

    public Queue<Player> thePlayers=new ConcurrentLinkedQueue<Player>();

    //needs a scanner method for input a pllayer name
    public Players(int x){
	String s = "Player";
	for(int i=1; i==x;i++){
	    System.out.println(s);
	    Player temp = new Player(s+i,i);
	    System.out.println(s+""+i);
	    thePlayers.add(temp);
	}
    }

    public Players(String s, int x){
	Player temp=new Player(s, 1);
	thePlayers.add(temp);
	for(int i=2;i<x+2;i++){
	    temp=new Player(i);
	    thePlayers.add(temp);
	}
    }

    public Player getPlayer(){
	return thePlayers.peek();
    }

    public int playerCount(){
	return thePlayers.size();
    }

    public Queue<Player> getPlayers(){
	return thePlayers;
    }

    public void printAllHands(){
	for(Player temp:thePlayers){
	    System.out.println(temp.getName()+": "+temp.printHand());
	}
    }

    public void addPlayer(Player main){
	thePlayers.add(main);
    }

    public void rotatePlayers(){
	Player temp=thePlayers.peek();
	thePlayers.add(temp);
	thePlayers.poll();
    }

    public boolean shouldEndPlayer(){
	for(Player temp:thePlayers){
	    if(temp.hasCards()==false){
		return true;
	    }
	}
	return false;
    
    }

    public boolean endGame(){
	for(Player temp:thePlayers){
	    if(temp.hasCards()==false){
		System.out.println(temp.getName()+" has lost!");
		thePlayers.remove(temp);
		String names="";
		for(Player player:thePlayers){
		    names=names+player.getName()+" ";
		}
		System.out.println("Players left: "+names);
		return true;
	    }
	}
	return false;
    }

}
