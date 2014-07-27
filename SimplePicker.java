import java.util.*;

public class SimplePicker extends PlayerPicker {

	public void allPick(Pool pool){

		ArrayList<Player> teamA = new ArrayList<Player>();
    ArrayList<Player> teamB = new ArrayList<Player>();

    ArrayList<Player> looking = pool.getLooking();
      	
   	for(int i = 0; i < 5; i++) {
   	  teamA.add(looking.get(i));
    	teamB.add(looking.get(i+5));
   	}

   	pool.joinGame(teamA, teamB);
	}
	
	public void oneVersusOne(Pool pool){
		//Not implemented
	}
}


