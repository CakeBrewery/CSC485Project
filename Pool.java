import java.util.*;

public class Pool {

  private ArrayList<Player> looking = new ArrayList<Player>();
  private ArrayList<Player> inGame = new ArrayList<Player>();
  private ArrayList<Games> matches = new ArrayList<Games>();

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

  public void joinGame(Collection<Player> c){
    for(Player p: c){
      occupy(p);
    }
  }


}
