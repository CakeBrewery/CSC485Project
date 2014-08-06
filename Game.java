import java.util.*;

public class Game {
  private ArrayList<Player> radiant = new ArrayList<Player>();
  private ArrayList<Player> dire = new ArrayList<Player>();

  public Game(ArrayList<Player> radiant, ArrayList<Player> dire){
    this.radiant = radiant;
    this.dire = dire;
  }

  public ArrayList<Player> getPlayers(){
    ArrayList<Player> participants = new ArrayList<Player>();
    participants.addAll(radiant);
    participants.addAll(dire);
    return participants;
  }

  public ArrayList<Player> getRadiantPlayers(){
    return this.radiant;
  }

  public ArrayList<Player> getDirePlayers(){
    return this.dire;
  }

  public String toString(){
    return "This prints out stats";
  }
}