public class Driver{

    public static void main(String[] args){
	Deck deck= new Deck();
	System.out.println(deck);
	deck.shuffle();
	System.out.println(deck.getSize());
	System.out.println(deck);
    }
}
