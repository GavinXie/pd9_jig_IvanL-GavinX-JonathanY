import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Deck{

    public ArrayList<Card> deck= new ArrayList<Card>();

    public Deck(){
	for(int x=1;x<14;x++){
	    for(int i=0;i<4;i++){
	    	Card temp=new Card(x,i + 1);}
		deck.add(temp);
	    }
	}
    }

    public String toString(){
	String deckPrint ="";
	for(int x=0;x<52;x++){
	    deckPrint=deckPrint+deck.get(x)+" ";
	}
	return deckPrint;
    }
    
    public int getSize(){
	return deck.size();
    }

    public void shuffle(){
	ArrayList<Card> temp=new ArrayList<Card>();
	while(deck.size()>0){
	    Random rand=new Random();
	    int x=rand.nextInt(deck.size());
	    temp.add(deck.get(x));
	    deck.remove(x);
	}
	deck=temp;
    }

  
    public void passCards(Player player, Player player2){
	int x=52;
	while(x>0){
	    Card temp=deck.get(x-1);
	    deck.remove(x-1);
	    if(x%2==0){
		player.addCard(temp);
	    }else{
		player2.addCard(temp);
	    }
	    x--;
        }
    }
}
