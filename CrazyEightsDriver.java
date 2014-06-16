import java.util.*;
import java.io.*;
public class CrazyEightsDriver{
    private static Pile pile;
    private static Card topCard;
    private static ArrayList<Player> Players;
    private static Deck deck;
    private static String winningPlayer,type;
    private static boolean winnarFound = false, counter;
    private static int CurrentSuit,turn,stakes;
    public static void SlowerTyping(String a){
	System.out.println();
	for (int i = 0; i < a.length(); i++){
	    try{
		Thread.sleep(15);
		System.out.print(a.charAt(i));
	    }
	    catch (InterruptedException e){
		return;
	    }
	}
	System.out.println();
    }

    public static void CreatePlayers(int number, int Comp) throws InterruptedException{
	Players = new ArrayList<Player>();
	for (int i = 0; i < number; i++){
	    Thread.sleep(200);
	    SlowerTyping("What is Player " + (i + 1) + "'s name?");
	    String s = ScannerProcessor.returnName();
	    Player Aplayer = new Player(s);
	    SlowerTyping("Player " + (i+1) + " created, name is" + " " + s);
	    Players.add(Aplayer);
	}
	for (int i = 0; i < Comp; i++){
	    Players.add(new Player());
	}
    }    
    public static void playerTurn(Player a) throws InterruptedException{
	Thread.sleep(300);
	SlowerTyping("Hand");
	Thread.sleep(300);
	SlowerTyping(a.toString2());
	Thread.sleep(200);
	SlowerTyping("The current number of Cards held by each player");
	for (int i = 0; i < Players.size(); i++){
	    SlowerTyping(Players.get(i).getName() + " " + Players.get(i).UnoHand.size());
	}
	if (counter){
	    Thread.sleep(750);
	    SlowerTyping("Your Opponent has placed a " + type + ". The stakes are " + stakes + ". Will you counter it?");
	    int Response = ScannerProcessor.returnSomething("Y/N");
	    if (Response == 0){
		for (int i = 0; i < stakes; i++){
		    Card Drew = deck.drawCard();
		    a.UnoHand.add(Drew);
		    SlowerTyping("You Drew a " + Drew);
		    Thread.sleep(400);
		}
		stakes = 0;
		counter = false;
		type = "";
		return;
	    }
	    else {
		if (type.equals("Ace")){
		    int acePos = -1;
		    for (int i = 0; i < a.UnoHand.size(); i++){
			if (a.UnoHand.get(i).getValue() == 1){
			    acePos = i;
			    break;
			}
		    }
		    if (acePos == -1){
			Thread.sleep(300);
			SlowerTyping("You can't counter this, drawing Cards...");
			for (int i = 0; i < stakes; i++){
			    Card Drew = deck.drawCard();
			    a.UnoHand.add(Drew);
			    SlowerTyping("You Drew a " + Drew);
			    Thread.sleep(400);
			}
			stakes = 0;
			counter = false;
			type = "";
			return;
		    }
		    else{
			Thread.sleep(300);
			pile.addCard(a.UnoHand.remove(acePos));
			topCard = pile.getTop();
			SlowerTyping("Please select a new suit");
			CurrentSuit = ScannerProcessor.returnSomething("Suits");
			stakes += 4;
			if (a.UnoHand.isEmpty()){
			    winnarFound = true;
			    winningPlayer = a.getName();
			}
			return;
		    }
		}
		else {
		    ArrayList<Card> canCounter = new ArrayList<Card>();
		    for (int i = 0; i<a.UnoHand.size(); i++){
			if (a.UnoHand.get(i).getValue() == 2 ||
			    a.UnoHand.get(i).getValue() == 1){
			    canCounter.add(a.UnoHand.get(i));
			}
		    }
		    if (canCounter.size() == 0){
			Thread.sleep(300);
			SlowerTyping("You can't counter this, drawing Cards...");
			for (int i = 0; i < stakes; i++){
			    Card Drew = deck.drawCard();
			    a.UnoHand.add(Drew);
			    SlowerTyping("You Drew a " + Drew);
			}
			stakes = 0;
			counter = false;
			type = "";
			return;			
		    }
		    else {
			Thread.sleep(300);
			SlowerTyping("These are your selectable counterable cards, choose one (0-position based)");
			SlowerTyping(canCounter.toString());
			int range = ScannerProcessor.returnRange(0, canCounter.size() - 1);
			Thread.sleep(300);
			SlowerTyping("You are countering with a(n) " + canCounter.get(range));
			int thepos = 0;
			for (int i = 0; i < a.UnoHand.size(); i++){
			    if (a.UnoHand.get(i).equals(canCounter.get(range))){
				thepos = i;
			    }
			}
			pile.addCard(a.UnoHand.remove(thepos));
			if (canCounter.get(range).getValue() == 1){
			    Thread.sleep(300);
			    SlowerTyping("Please select a new suit");
			    CurrentSuit = ScannerProcessor.returnSomething("Suits");
			    stakes += 4;
			    topCard = pile.getTop();
			    type = "Ace";
			    if (a.UnoHand.isEmpty()){
				winnarFound = true;
				winningPlayer = a.getName();
			    }
			    return;
			}
			else {
			    if (a.UnoHand.isEmpty()){
				winnarFound = true;
				winningPlayer = a.getName();
			    }
			    stakes += 2;
			    topCard = pile.getTop();
			    CurrentSuit = topCard.getSuit();
			    return;
			}
		    }
		}
	    }
	}
	Thread.sleep(300);
	if (topCard.getValue() != 8 || topCard.getValue() != 1){
	    SlowerTyping("Current Card on top is " + topCard);
	    Thread.sleep(200);
	    SlowerTyping("The Current allowed Suit is " + decipher(CurrentSuit));
			       
	}
	else {
	    SlowerTyping("An eight or ace was played, current accepted suit is " + decipher(CurrentSuit));
	}
	boolean HasCard = false;
	for (int i = 0; i< a.UnoHand.size(); i++){
	    if (a.UnoHand.get(i).getValue() == topCard.getValue() ||
		a.UnoHand.get(i).getSuit()==CurrentSuit ||
		a.UnoHand.get(i).getValue() == 1 ||
		a.UnoHand.get(i).getValue() == 8
		){
		HasCard = true;
		break;
	    }
	}
	Thread.sleep(500);
	if (!HasCard){
	    SlowerTyping("No Cards Compatible, must draw a card");
	    Card Drew = deck.drawCard();
	    a.UnoHand.add(Drew);
	    SlowerTyping("You Drew a " + Drew);
	    return;
	}
	SlowerTyping("Select a compatible card from your UnoHand (0-index position based)");
	try{
	    Scanner sc = new Scanner(System.in);
	    int pos = sc.nextInt();
	    Card Selected = a.UnoHand.get(pos);
	    Thread.sleep(300);
	    if (Selected.getValue() == 8 || Selected.getValue() == 1){
		pile.addCard(a.UnoHand.remove(pos));
		topCard = pile.getTop();
		SlowerTyping("Please choose a Suit (Diamonds/Clubs/Hearts/Spades)");
		CurrentSuit = ScannerProcessor.returnSomething("Suits");
		if (Selected.getValue() == 1){ // Draw 4
		    SlowerTyping("You have played an ace!");
		    counter = true;
		    stakes += 4;
		    type = "Ace";
		}
	    }
	    else if (Selected.getValue() == topCard.getValue() ||
		     Selected.getSuit()==CurrentSuit){
		pile.addCard(a.UnoHand.remove(pos));
		topCard = pile.getTop();
		CurrentSuit = pile.getTop().getSuit();
		Thread.sleep(500);
		SlowerTyping("You have Played a(n) " + topCard);
		if(Selected.getValue() == 2){ //Draw 2
		    SlowerTyping("You have played a Draw two!");
		    counter = true;
		    stakes += 2;
		    type = "two";
		}
		else if(Selected.getValue() == 11){ // Skip Card
		    SlowerTyping("You have skipped the next guy's turn");
		    turn++;
		}
		else if(Selected.getValue() == 12){ // Reverse Card
		    SlowerTyping("You have reversed the order of Players!");
		    Reverse();
		}
	    
	    }
	    else{
		System.out.print("Card can't be played");
		playerTurn(a);
		return;
	    }
	    if (a.UnoHand.isEmpty()){
		winnarFound = true;
		winningPlayer = a.getName();
		return;
	    }
	}
	catch(Exception e){
	    SlowerTyping("Failed to select card");
	    playerTurn(a);
	}

    }
    public static String decipher(int suit){
	if (suit == 1){
	    return "Diamonds";
	}else if (suit == 2){
	    return "Clubs";
	}else if (suit == 3){
	    return "Hearts";
	}else if (suit == 4){
	    return "Spades";
	}
	return "This won't happen";
    }
    public static void computerTurn(Player AI) throws InterruptedException{
	if (counter){
	    Thread.sleep(500);
	    if (type.equals("Ace")){
		for (int i = 0; i < AI.UnoHand.size(); i++){
		    if (AI.UnoHand.get(i).getValue() == 1){
			pile.addCard(AI.UnoHand.remove(i));
			topCard = pile.getTop();
			SlowerTyping("Computer Player has countered an ace!");
			CurrentSuit = (int)(Math.random() * 4 + 1);
			SlowerTyping("Computer has changed the suit to " + decipher(CurrentSuit));
			stakes += 4;
			return;
		    }
		}
		SlowerTyping("Computer couldn't counter!");
		for (int i = 0; i < stakes; i++){
		    AI.UnoHand.add(deck.drawCard());
		}
		counter = false;
		stakes = 0;
		type = "";
		return;
	    }
	    else {
		for (int i = 0; i < AI.UnoHand.size(); i++){
		    if (AI.UnoHand.get(i).getValue() == 1 || AI.UnoHand.get(i).getValue() == 2){
			pile.addCard(AI.UnoHand.remove(i));
			topCard = pile.getTop();
			if (topCard.getValue() == 1){
			    SlowerTyping("Computer Player has stopped playing around and countered with an ace!");
			    stakes += 4;
			    type = "Ace";
			    CurrentSuit = (int)(Math.random() * 4 + 1);
			    SlowerTyping("Computer has changed the suit to " + decipher(CurrentSuit));
			    return;
			}
			else {
			    SlowerTyping("Computer Player has countered with a " + topCard);
			    stakes +=2;
			    return;
			}
		    }
		}
		SlowerTyping("Computer couldn't counter the two");
		for (int i = 0; i < stakes; i++){
		    AI.UnoHand.add(deck.drawCard());
		}
		return;
	    }
	}
	Card Remove = null;
	for (int i =0; i < AI.UnoHand.size(); i++){	 
	    if (AI.UnoHand.get(i).getValue() == topCard.getValue() || AI.UnoHand.get(i).getSuit() == CurrentSuit ||
		AI.UnoHand.get(i).getValue() == 8 || AI.UnoHand.get(i).getValue() == 1){
		Remove = AI.UnoHand.remove(i);
		pile.addCard(Remove);
		topCard = Remove;
		CurrentSuit = topCard.getSuit();
		break;
	    }
	}
	if (Remove == null){
	    Thread.sleep(300);
	    AI.UnoHand.add(deck.drawCard());
	    SlowerTyping("Computer drew a card");
	    return;
	}
	Thread.sleep(300);
	SlowerTyping("Computer has played " + Remove);
	if (Remove.getValue() == 8 || Remove.getValue() == 1){
	    CurrentSuit = (int)(Math.random() * 4 + 1);
	    Thread.sleep(250);
	    SlowerTyping("Computer has changed the suit to " + decipher(CurrentSuit));
	}
	if (Remove.getValue() == 1){
	    Thread.sleep(300);
	    SlowerTyping("Computer has played an ace!");
	    counter = true;
	    stakes += 4;
	    type = "Ace";
	}
	else if (Remove.getValue() == 11){
	    Thread.sleep(300);
	    SlowerTyping("Computer has Skipped the next guy!");
	    turn++;
	}
	else if (Remove.getValue() == 12){
	    Thread.sleep(300);
	    SlowerTyping("Computer has just flipped us upside down by reversing the order!");
	    Reverse();
	}
	else if (Remove.getValue() == 2){
	    Thread.sleep(300);
	    SlowerTyping("Computer has played a two!");
	    counter = true;
	    stakes += 2;
	    type = "two";
	}
	if (AI.UnoHand.isEmpty()){
	    winnarFound = true;
	    winningPlayer = AI.getName();
	    return;
	}
    }
    public static void Reverse(){ // How do you reverse? Just add the players in the reverse order!
	ArrayList<Player> newPlayerOrder = new ArrayList<Player>();
	for (int i = Players.size() - 1; i >= 0; i--){
	    newPlayerOrder.add(Players.get(i));
	}
	Players = newPlayerOrder;
    }
	

		     
    public static void main(String[]args)throws InterruptedException{
	SlowerTyping("How Many Human Players will there be? (4 max)");
	int Human = ScannerProcessor.returnRange(1,4);
	int Computer = 0;
	SlowerTyping("Spawning " + Human + " human players");
	if (Human != 4){
	    SlowerTyping("How many AI players wanted (Total amt of players can't exceed 4)");
	    Computer = ScannerProcessor.returnRange(0,4-Human);
	    if (Computer == 0){
		if (Human == 1){
		    SlowerTyping("One Computer Players will spawn since you're all alone!");
		    CreatePlayers(Human, 1);
		}
		else {
		    SlowerTyping("No Computer Players will spawn at all");
		    CreatePlayers(Human,0);
		}
	    }
	    else {
		SlowerTyping(Computer + " players will spawn");
		CreatePlayers(Human,Computer);
	    }
	}
	deck = new Deck();
	deck.shuffle();
	for (int i = 0; i<Players.size(); i++){
	    for (int j = 0; j < 5; j++){
		Players.get(i).UnoHand.add(deck.drawCard());
	    }
	}
	topCard = deck.drawCard();
	CurrentSuit = topCard.getSuit();
	Thread.sleep(300);
	SlowerTyping("Good Luck!");
	Thread.sleep(300);
	pile = new Pile();
	pile.addCard(topCard);
	while (!winnarFound){
	    for (int i = 0; i < Players.size(); i++){
		if (winnarFound){
		    break;
		}
		Player CurrentPlayer = Players.get(turn%Players.size());
		if (CurrentPlayer.getName().equals("Comp")){
		    computerTurn(CurrentPlayer);
		}
		else {
		    playerTurn(CurrentPlayer);
		}
		turn++;
	    }
	}
	Thread.sleep(300);
	if (winningPlayer.equals("Comp")){
	    SlowerTyping("GAME OVER, RISE OF COMPUTER");
	}
	else {
	    SlowerTyping("Congratulations " + winningPlayer + " you are the Crazy Eights Champ!");
	}
    }
}
