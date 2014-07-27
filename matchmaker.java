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
    while(pool.getLookingCount() >= 10){
      ArrayList<Player> teamA = new ArrayList<Player>();
      ArrayList<Player> teamB = new ArrayList<Player>();

      //TODO: pick 10 players

      //TODO: split players into teams

      pool.joinGame(teamA, teamB);

    }
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
      }catch (NumberFormatException e) {
        System.out.println("Incorrect usage!");
      }




    }
  }

}
