public class Card{

    public int index, value;
    public String suit;

    public Card(int x, String s){
	value=x;
	suit = s;
    }

    public String toString(){
	return ""+value + " " + suit;
    }
    public int getIndex(){
	return index;
    }
    public int getValue(){
	return value;
    }
    public String getSuit(){
    	return suit;
    }
}
