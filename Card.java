import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Card{

    public int index, value, suit, x,y;
    protected Image image;
    String cardName, suitName;

    public Card(int v, int s, int x, int y){
	value=v;
	suit=s;
	this.x=x;
	this.y=y;
	if(suit==1){
	    suitName="Diamonds";
	}else if(suit==2){
	    suitName="Clubs";
	}else if(suit==3){
	    suitName="Hearts";
	}else{
	    suitName="Spades";
	}
        cardName=value+" of "+suitName;
        ImageIcon icon = new ImageIcon(type);
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
}
