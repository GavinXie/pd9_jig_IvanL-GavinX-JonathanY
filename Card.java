public class Card{

    private int index, value, suit;
    

    public Card(int x, int suit){
	value=x;
	this.suit = suit;
    }

    public String toString(){
    	if (suit == 1){
    		return ""+value + " of Diamonds";
    	}
    	else if (suit == 2){
		return ""+value + " of Clubs";
    	}
    	else if (suit == 3){
    		return ""+value + " of Hearts";
    	}
    	else {
    		return ""+value + "  of Spades";
    	}
    }
    public int getIndex(){
	return index;
    }
    public int getValue(){
	return value;
    }
    public int getSuit(){
    	return suit;
    }
}
