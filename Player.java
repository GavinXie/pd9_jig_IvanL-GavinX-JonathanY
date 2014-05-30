import java.io.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.*;

public class Player{

    public String name;
    public Queue<Card> hand=new Queue<Card>();
    public ArrayList<Card> hand2 = new ArrayList<Card>();

    public Player(String name){
	name=this.name;
    }

    public String getName(){
	return name;
    }

    public void add(Card card){
	hand.add(card);
    }


}
