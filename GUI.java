import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Math;

public class GUI extends JPanel implements ActionListener{

    public Timer timer;
    public Players Players;
    public Player main;

    public GUI(){
	addKeyListener(new KeySensor());
	setFocusable(true);
	timer = new Timer(10,this);
	timer.start();
	Players=new Players(2);
	Players.addPlayer(main);
    }

    public void paint(Graphics g){
	super.paint();
	Graphics2D g2 = (Graphics2D)g;
        for(Player temp : Players){
	    for(Card card:temp.getHand()){
		g2.drawImage(card.getBack(),temp.getX(),temp.getY(),72,96,this);
	    }	
	}
	Toolkit.getDefaultToolkit().sync();
	g.dispose();
    }

    public void actionPerformed(ActionEvent e){
	if(main.hasSlapped()){
	    
	}
    }

    public class KeySensor extends KeyAdapter {
	public void keyReleased(KeyEvent e){
	    if(main.hasSlapped()){
		main.keyReleased(e);
	    }
	}
	public void keyPressed(KeyEvent e){
	    if(!main.hasSlapped()){
		main.keyPressed(e);
	    }
	}
    }
}
