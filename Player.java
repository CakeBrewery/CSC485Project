import java.util.Random;

public class Player {

	private String name;
	private int mmr = 0;
	private int totalGames = 0;
	private int gamesWon = 0;
	private boolean banned = false;

	public Player(){
		this.name = "Player";
		Random rdm = new Random();
		this.mmr = rdm.nextInt(10000);
	}

	public Player(String label){
		this.name = label;
		Random rdm = new Random();
		this.mmr = rdm.nextInt(10000);
	}

	public int getMMR(){
		return this.mmr;
	}

	public void setMMR(int mmr){
		this.mmr = mmr;
	}

	public int getTotalGames(){
		return this.totalGames;
	}

	public int getGamesWon(){
		return this.gamesWon;
	}

	public String toString(){
		return (this.name+" MMR:"+this.mmr+" W/L/T:"+this.gamesWon+"/"+(this.totalGames-this.gamesWon)+"/"+this.totalGames);
	}

}
