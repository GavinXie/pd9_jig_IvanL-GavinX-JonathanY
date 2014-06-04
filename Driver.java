public class Driver{

    public static void main(String[] args){
	Deck deck= new Deck();
	System.out.println(deck);
	deck.shuffle();
	System.out.println(deck);
	Player player1=new Player();
	Player player2=new Player();
	deck.passCards(player1, player2);
	System.out.println(player1.printHand());
	System.out.println(player2.printHand());
    }
}
