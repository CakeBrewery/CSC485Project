import java.util.*;

public class matchmaker {

  public static void main(String[] args) {
    if(args.length == 0){
      System.out.println("Usage: java matchmaker <number_of_players>");
    }else{

      try{
        int no_to_generate = Integer.parseInt(args[0]);
        System.out.println("Generating "+no_to_generate+" Players");
      }catch (NumberFormatException e) {
        System.out.println("Incorrect usage!");
      }
    }
  }

}
