import java.util.*;

public class SimplePicker extends PlayerPicker {

	public void allPick(Pool pool){

		ArrayList<Player> teamA = new ArrayList<Player>();
    ArrayList<Player> teamB = new ArrayList<Player>();

    ArrayList<Player> looking = pool.getLooking();
	Collections.sort(looking, new Player());
	Collections.reverse(looking);
      	
   	for(int i = 0; i < 10; i = i+2) {
      Player p1 = looking.get(i);
      Player p2 = looking.get(i+1);

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


