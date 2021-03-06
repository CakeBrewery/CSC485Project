import java.util.*;

public class Pool {

  private ArrayList<Player> looking = new ArrayList<Player>();
  private ArrayList<Player> inGame = new ArrayList<Player>();
  private ArrayList<Game> currentMatches = new ArrayList<Game>();

  public Pool(){

  }
  public ArrayList<Player> getAllPlayers(){
	  ArrayList<Player> retVal = new ArrayList<Player>();
	  
	  retVal.addAll(inGame);
	  retVal.addAll(looking);
	  
	  return retVal;
  }

  public void add(Player p){
    looking.add(p);
  }

  public void remove(Player p){
    looking.remove(p);
  }

  public void occupy(Player p){
    looking.remove(p);
    inGame.add(p);
  }

  public int getLookingCount(){
    return this.looking.size(); 
  }

  public ArrayList<Player> getLooking(){
    return this.looking;
  }

  public ArrayList<Player> getInGame(){
    return this.inGame;
  }

  public ArrayList<Game> getCurrentMatches(){
    return this.currentMatches;
  }

  public void joinGame(ArrayList<Player> radiant, ArrayList<Player> dire){
    //set all players to occupied
    for(Player p: radiant){
      occupy(p);
    }

    for(Player p: dire){
      occupy(p);
    }

    //add game to current matches
    currentMatches.add(new Game(radiant, dire));
  }

  public String toString(){
    String str =  "Count:"+(looking.size()+inGame.size())+ "["+looking.size()+"/"+inGame.size()+"]"+" Current matches:"+currentMatches.size();
    return str;
  }


}
