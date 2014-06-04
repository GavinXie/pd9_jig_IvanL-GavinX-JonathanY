public class Driver{

    public static void slapJack(Player player1, Player player2){
	Deck deck= new Deck();
	System.out.println(deck);
	deck.shuffle();
	System.out.println(deck);
	deck.passCards(player1, player2);
	System.out.println("Player 1: "+ player1.printHand());
	System.out.println("Player 2: "+ player2.printHand());
	System.out.println("Apparently player.printHand()the player toString removes the data...");
	System.out.println("Player 1: "+ player1.printHand());
	System.out.println("Player 2: "+ player2.printHand());
	Pile pile = new Pile();
	boolean goodSlap=true;
	while(player1.hasCards()&&player2.hasCards()){
	    pile.addCard(player1);
	    goodSlap= player1.toSlap(pile);
	    if(goodSlap){
		pile.shuffleInto(player1);
	    }else{
		pile.shuffleInto(player2);
	    }
	    pile.addCard(player2);
	    goodSlap= player2.toSlap(pile);
	    if(goodSlap){
		pile.shuffleInto(player2);
	    }else{
		pile.shuffleInto(player1);
	    }
	    System.out.println("Player 1: " + player1.printHand());
	    System.out.println("Player 2: " + player2.printHand());
	}
    }

    public static void main(String[] args){
	Player player1 = new Player();
	Player player2 = new Player();
	slapJack(player1, player2);
    }
}
