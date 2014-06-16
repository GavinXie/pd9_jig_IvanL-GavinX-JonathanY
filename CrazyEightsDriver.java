public class CrazyEightsDriver{
    private Pile pile;
    private Card topCard;
    private ArrayList<Player> Players;
    private Deck deck;
    private boolean winnarFound = false;
    private int CurrentSuit,turn;
    public static void CreatePlayers(int number, int Comp){
	Players = new ArrayList<Player>();
	for (int i = 0; i < number; i++){
	    System.out.println("What is Player " + i + "'s name?");
	    Scanner Bob = new Scanner(System.in);
	    String s = Bob.getNextLine();
	    Player Aplayer = new Player(s);
	    System.out.println("Player " + i + " created, name is" + " " + s);
	}
	for (int i = 0; i < Comp; i++){
	    
		 }
	// public static void Counter(Player Counterer, int type, int stake){
	// 	if (type == 2){
	// 	    for (int i = 0; i<	    
	public static boolean playerTurn(Player a){
	    if (!a.hand.hasCards()){
		winnarFound = true;
		return;
	    }
	    boolean HasCard = false;
	    for (int i = 0; i<Unohand.size(); i++){
		if (a.hand.get(i).getValue() == pile.getFirst().getValue() ||
		    a.hand.get(i).getSuit()==CurrentSuit){
		    HasCard = true;
		    break;
		}
	    }
	    if (!HasCard){
		a.hand.addCard(deck.drawCard());
	    }
	    System.out.println("Select a compatible card from your hand (positio
n based)");
	    Scanner sc = new Scanner(System.in);
	    int pos = sc.nextInt();
	    Card Selected = a.hand.get(pos);
	    try{
		if (Selected.getValue() == 8 || Selected.getValue() == 1){
		    pile.add(a.hand.remove(pos));
		    Scanner suit  = new Scanner(System.in);
		    String Timmy = suit.nextLine();
		    if (Timmy.equalsIgnoreCase("Diamonds")){
			CurrentSuit = 1;
		    }
		    else if (Timmy.equalsIgnoreCase("Clubs")){
			CurrentSuit = 2;
		    }
		    else if (Timmy.equalsIgnoreCase("Hearts")){
			CurrentSuit = 3;
		    }
		    else{
			CurrentSuit = 4;
		    }
		    if (Selected.getValue() == 1){
			OpponentCounter(4,0);
			
		    }
		}
		else if (Selected.getValue() == pile.getFirst().getValue() ||
			 Selected.getSuit()==CurrentSuit){
		    if(Selected.getValue() == 2){
			DrawCards(2);
		    }
		    else if(Selected.getValue() == 11){ // Skip Card
			turn++;
		    }
		    else if(Selected.getValue() == 12){ // Reverse Card
		    }
		    pile.add(a.hand.remove(pos));
		    CurrentSuit = pile.getFirst().getSuit();
		}
		else{
		    System.out.print("Card can't be played");
		    playerTurn(a);
		}
	    }
	    catch(Exception e){
		System.out.println("Failed to select card");
		playerTurn(a);
	    }

	}

	 
		     
	public static computerTurn(){
	    for (int i =0; i<Player2.hand.size(); i++){
	    }
		     
	    public static void main(String[]args){
		System.out.println("How Many Players will there be? (4 max)");
		Scanner sc = new Scanner(System.in);
		int Human = sc.nextInt();
		int Computer = 0;
		if (a < 1){
		    System.out.println("Too few players selected, defaulting to 2 Human Players");
		    a = 2;
		}
		else if (a > 4){
		    System.out.println("Too many players selected, defaulting to 4");
		    CreatePlayers(4);
		}
		else{
		    System.out.println("Spawning " + a + " human players");
		}
		if (a != 4){
		    System.out.println("How many AI players wanted (Total amt of players can't exceed 4)");
		    Scanner sc2 = new Scanner(System.in);
		    Computer = sc.nextInt();
		    if (Computer + a > 4){
			System.out.println("Too many Players selected, spawning " + (4-a) +" Computer Players");
			CreatePlayers(a,4-a);
		    }
		    else if (Computer <= 0){
			if (a == 1){
			    System.out.println("One Computer Players will spawn since you're all alone!");
			    CreatePlayers(a, 1);
			}
			else {
			    System.out.println("No Computer Players will spawn at all");
			    CreatePlayers(a,0);
			}	    
		    }
		}
		deck = new Deck();
		deck.shuffle();
		deck.passCards();
		topCard = deck.draw();
		CurrentSuit = topCard.getSuit();
		thePile.add(topCard);
		while (!winnarFound){
		    if (turn % 2 == 0){
			playerTurn(Player1);
		    }
		    else {
			playerTurn(Player2);
		    }
		    turn++;
		}
	    }
	}
