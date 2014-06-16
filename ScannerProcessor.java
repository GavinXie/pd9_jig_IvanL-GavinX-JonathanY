import java.util.*;
import java.io.*;
public class ScannerProcessor{
    public static String returnGame(){
	while(true){
	    Scanner sc = new Scanner(System.in);
	    try{
		String a = sc.nextLine();
		if (a.equalsIgnoreCase("Crazy Eights") || a.equalsIgnoreCase("Slapjack")){
		    return a;
		}
		else {
		    System.out.println("The games we have to offer are Slapjack and Crazy Eights");
		}
	    }
	    catch (Exception e){
		    System.out.println("The games we have to offer are Slapjack and Crazy Eights");
	    }
	}
    }
    public static String returnName(){
	while(true){
	    Scanner sc = new Scanner(System.in);
	    try {
		String a = sc.nextLine();
		if (a.equals("Comp")){
		    System.out.println("This is a special name exclusive to AI, you must choose a different name");
		}
		else {
		    return a;
		}
	    }
	    catch(Exception e){
		System.out.println("How did you mess up in spelling your own name!?");
	    }
	}
    }
    public static int returnSomething(String type){
	if (type.equals("Y/N")){
	    while (true){ //THE RIDE NEVER ENDS (until you enter the right answer)
		Scanner sc = new Scanner(System.in);
		try {
		    String a = sc.nextLine();
		    if (a.equalsIgnoreCase("Yes") || a.equalsIgnoreCase("Y")
			){
			return 1;
		    }
		    else if (a.equalsIgnoreCase("No") || a.equalsIgnoreCase("N")){
			return 0;
		    }
		    else {
			System.out.println("This is not an accepted response, this is a Yes/No Question");
		    }
		}
		catch(Exception e){
		    System.out.println("This is not an accepted response, this is a Yes/No Question");
		}
	    }
	}
	else if (type.equals("Suits")){
	    while(true){
		Scanner sc = new Scanner(System.in);
		try{
		    String a = sc.nextLine();
		    if (a.equalsIgnoreCase("Diamonds")){
			System.out.println("Diamonds was selected");
			return 1;
		    }
		    else if (a.equalsIgnoreCase("Clubs")){
			System.out.println("Clubs was selected");
			return 2;
		    }
		    else if (a.equalsIgnoreCase("Hearts")){
			System.out.println("Hearts was selected");
			return 3;
		    }
		    else if (a.equalsIgnoreCase("Spades")){
			System.out.println("Spades was selected");
			return 4;
		    }
		    else {
			System.out.println("The response you selected was not a valid suit. Choose between Diamonds/Clubs/Hearts/Spades");
		
		    }
		}
		catch (Exception e){
		    System.out.println("The response you selected was not a valid suit. Choose between Diamonds/Clubs/Hearts/Spades");
		    
		}
	    }
	}
	return returnSomething("Suits");
    }
    public static int returnRange(int start, int end){
	while (true){
	    try{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a >= start && a <= end){
		    return a;
		}
		else {
		    System.out.println("This isn't a valid position in the range");
		}
	    }
	    catch(Exception e){
		System.out.println("This isn't a valid position in the range");
	    }
	}
    }
}
