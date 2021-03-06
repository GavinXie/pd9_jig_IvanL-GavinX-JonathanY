import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SuperDriver{
    public static void main(String[] args) throws InterruptedException{
        String[] noargs = new String[0];
        if (args.length != 0){
            if (args.length == 1 ){
                if (args[0].equalsIgnoreCase("Slapjack")){
                    Driver.main(noargs);
                    return;
                }
            }
            if (args.length == 2){
                if ((args[0]+ " " +args[1]).equalsIgnoreCase("Crazy Eights")){
                    CrazyEightsDriver.main(noargs);
                    return;
                }
            }
        }
        else {
            System.out.println("Please pick to play Crazy Eights or Slapjack");
            String b = ScannerProcessor.returnGame();
            String[] c = b.split(" ");
            Driver.main(c);
            return;
        }
    }
}
