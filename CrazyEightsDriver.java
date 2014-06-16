public class CrazyEightsDriver{
    private Pile pile;
    private Card topCard;
    private UnoPlayer Player1, Player2;
    private Deck deck;
    private boolean winnarFound = false;
    private int CurrentSuit,turn;
    public static void CreatePlayers(){
        System.out.println("What is Player 1's name?");
        Scanner Bob = new Scanner(System.in);
        String s = Bob.getNextLine();
        Player1 = new Player(s);
        System.out.println("Player 1 created, name is" + " " + s);
        Player2 = new Player();
    }
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
                        DrawCards(4);
                    }
                }
                else if (Selected.getValue() == pile.getFirst().getValue() ||
			 Selected.getSuit()==CurrentSuit){
                    if(Selected.getValue() == 2){
                        DrawCards(2);
                    }
                    else if(Selected.getValue() == 11){
                        turn++;
                    }
                    else if(Selected.getValue() == 12){
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
    }
    public static computerTurn(){
	for (int i =0; i<Player2.hand.size
		 }
	public static void main(String[]args){
	    CreatePlayers();
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
