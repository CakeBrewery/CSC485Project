import java.util.*;

public class Game {
  private ArrayList<Player> radiant = new ArrayList<Player>();
  private ArrayList<Player> dire = new ArrayList<Player>();

  public ArrayList<Player> getPlayers(){
    return radiant+dire;
  }

}
