import java.util.*;

public class SimplePicker extends PlayerPicker {

	public void allPick(Pool pool){

		ArrayList<Player> teamA = new ArrayList<Player>();
    ArrayList<Player> teamB = new ArrayList<Player>();

    ArrayList<Player> looking = pool.getLooking();
      	
   	for(int i = 0; i < 5; i++) {
      Player p1 = looking.get(i);
      Player p2 = looking.get(i+5);

      p1.ingame = true; 
      p1.gamenum = pool.getCurrentMatches().size() +1;
      p1.faction = "Radiant";

      p2.ingame = true; 
      p2.gamenum = pool.getCurrentMatches().size() +1;
      p2.faction = "Dire";

   	  teamA.add(p1);
    	teamB.add(p2);
   	}

   	pool.joinGame(teamA, teamB);
	}
	
	public void oneVersusOne(Pool pool){
		//Not implemented
	}
}


