import java.util.ArrayList;

public class SlapJack{

    public static void PlayslapJack(Players players){
	Deck deck= new Deck();
	System.out.println(deck);
	deck.shuffle();
	System.out.println(deck);
	deck.passCards(players);
	players.printAllHands();
	Pile pile = new Pile();
	boolean slap=false;
	Boolean shouldSlap=false;
	//runs until there is one player
	while(players.playerCount()>1){
	    //runs until one player loses
	    System.out.println(players.endGame());
	    while(players.endGame()==false){
		//each round runs until someone slaps the pile
		while(slap==false){
		    Player temp = players.getPlayer();
		    pile.addCard(temp);
		    System.out.println(temp.getName() +" put down a "+pile.getTop());
		    slap=temp.toSlap(pile);
		    if(temp.hasCards()==false){
			slap=true;
		    }
		    System.out.println(pile);
		    players.rotatePlayers();
		}
		players.printAllHands();
		shouldSlap = pile.shouldSlap();
		if(shouldSlap==true){
		    players.rotatePlayers();
		    Player temp = players.getPlayer();
		    pile.shuffleInto(temp);
		    players.rotatePlayers();
		}else{
		    Player temp = players.getPlayer();
		    pile.shuffleInto(temp);
		}
		slap=false;
	    }
	}
    }

    public static void main(String[] args){
	Players players = new Players("Gavin");
	PlayslapJack(players);
    }
}
