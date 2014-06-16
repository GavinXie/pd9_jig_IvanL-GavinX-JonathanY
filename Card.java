import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Card{

    public int index, value, suit, x,y;
    protected Image image;
    String cardName, suitName,valueName;

    public Card(int v, int s, int x, int y){
	value=v;
	suit=s;
	this.x=x;
	this.y=y;
	if (value == 1){
	    valueName = "Ace";
	}else if(value == 11){
	    valueName = "Jack";
	}else if (value == 12){
	    valueName = "Queen";
	}else if (value == 13){
	    valueName = "King";
	}else{
	    valueName = value;
	}
	if(suit==1){
	    suitName="Diamonds";
	}else if(suit==2){
	    suitName="Clubs";
	}else if(suit==3){
	    suitName="Hearts";
	}else{
	    suitName="Spades";
	}
        cardName=valueName+" of "+suitName;
        ImageIcon icon = new ImageIcon(cardName);
        image = icon.getImage();
    }

    public String toString(){
	return cardName;
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
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public Image getPic(){
	return image;
    }
			 
}
