import java.util.Random;

public class Player {

	private String name;
	private int mmr = 0;
	private int totalGames = 0;
	private int gamesWon = 0;
	private boolean banned = false;
  private String[] defaultNames = {"Agnes","Alfred","Archy","Bart","Benjamin","Bertram","Bruni","Buster","Edith","Ester","Flo","Francis","Francisco","Gil","Gob","Gus","Hank","Harold","Harriet","Henry","Jacques","Jorge","Juan","Kitty","Lionel","Louie","Lucille","Lupe","Mabel","Maeby","Marco","Marta","Maurice","Maynard","Mildred","Monty","Mordecai","Morty","Pablo","Seymour","Stan","Tobias","Vivian","Walter","Wilbu"};

	public Player(){
    Random rdm = new Random();
		this.name = defaultNames[rdm.nextInt(this.defaultNames.length)];
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
