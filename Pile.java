import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Pile{

    public ArrayList<Card> pile=new ArrayList<Card>();

    public Pile(){
	
    }

    public void addCard(ArryaList<Player> players){
	Card card=hand.poll();
	if(card.equals(null)){
	    System.out.println(name+" has lost");
	}else{
	    pile.add(card);
	}
    }

    public void add(Card card){
	pile.add(Card);
    }

    public void shuffleInto(Player hand){
	while(pile.size()>0){
	    Random rand=new Random();
	    int x=rand.nextInt(deck.size());
	    hand.add(pile.get(x));
	    pile.remove(x);
	}
    }

}

		  
