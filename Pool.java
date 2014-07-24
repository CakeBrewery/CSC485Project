import java.util.*;

public class Pool {

  private ArrayList<Player> playerPool = new ArrayList<Player>();

  public void add(Player p){
    playerPool.add(p);
  }

  public void remove(Player p){
    playerPool.remove(p);
  }
}
