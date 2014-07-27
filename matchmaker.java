import java.util.*;

public class matchmaker {

  //Pool of all players in the system 
  public static Pool pool = new Pool();

  public static void generatePlayers(int num){
    for(int i=0;i<num;i++){
      Player p = new Player();
      pool.add(p);
    }
  }

  public static void generateGame(){
    SimplePicker sp = new SimplePicker();
    sp.allPick(pool);
  }

  public static void main(String[] args) {
    if(args.length == 0){
      System.out.println("Usage: java matchmaker <number_of_players>");
    }else{

      try{
        int numToGenerate = Integer.parseInt(args[0]);
        System.out.println("Generating "+numToGenerate+" Players");
        generatePlayers(numToGenerate);
        System.out.println(pool);

        //Printing status of before generating matches:
        System.out.println("\n\nLobby BEFORE Generating Matches\n---");
        for(Player p : pool.getLooking()){
          System.out.println(p);
        }

        System.out.println("\nInGame BEFORE Generating Matches\n---");
        for(Player p : pool.getInGame()){
          System.out.println(p);
        }

        //Generating matches
        System.out.println("\nGenerating Matches...");
        while(pool.getLookingCount() >= 10){
          generateGame();
        }

        System.out.println("Generated " + pool.getCurrentMatches().size() + " Matches");

        //Printing status after generating matches: 
        System.out.println("\n\nLobby AFTER Generating Matches\n---");
        for(Player p : pool.getLooking()){
          System.out.println(p);
        }

        System.out.println("\nInGame AFTER Generating Matches\n---");
        for(Player p : pool.getInGame()){
          System.out.println(p);
        }

      }catch (NumberFormatException e) {
        System.out.println("Incorrect usage!");
      }




    }
  }

}
