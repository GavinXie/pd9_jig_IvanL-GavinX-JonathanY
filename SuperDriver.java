public class SuperDriver{
    public static void main(String[] args){
        String[] noargs = new String[0];
        if (args.length != 0){
            if (args.length == 1 ){
                if (args[0].equalsIgnoreCase("Slapjack")){
                    SlapjackDriver.main(noargs);
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
            Scanner a = new Scanner(System.in);
            String b = "";
            if (a.hasNextLine()){
                b = a.nextLine();
            }
            else {
                System.out.println("No input recieved.");
            }
            String[] c = b.split(" ");
            Driver.main(c);
            return;
        }
    }
}
