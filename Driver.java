import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver extends JFrame{
    public Driver(){
	add(new GUI());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(900,600);
	setLocationRelativeTo(null);
	setTitle("SlapJack");
	setResizable(false);
	setVisible(true);
    }

    public static void main(String[] args){
	new Driver();
    }
}
