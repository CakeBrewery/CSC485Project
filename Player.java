import java.util.Random;

public class Player {

  private String[] defaultNames = {"Agnes","Alfred","Archy","Bart","Benjamin","Bertram","Bruni","Buster","Edith","Ester","Flo","Francis","Francisco","Gil","Gob","Gus","Hank","Harold","Harriet","Henry","Jacques","Jorge","Juan","Kitty","Lionel","Louie","Lucille","Lupe","Mabel","Maeby","Marco","Marta","Maurice","Maynard","Mildred","Monty","Mordecai","Morty","Pablo","Seymour","Stan","Tobias","Vivian","Walter","Wilbu"};
  Random rdm = new Random();

  //Profile data
  private String name;
  private int mmr = 0;
  private int totalGames = 0;
  private int gamesWon = 0;
  private boolean banned = false;
  private boolean troll = false;

  //Match statistics
  private int kills = 0; 
  private int deaths = 0; 
  private int assists = 0; 
  private int kda = 0;
  private int kd = 0;
  private int lasthit = 0; 
  private int denies = 0; 
  private int gpm = 0; 
  private int xpm = 0; 

  public Player() {
    this.initRand();
  }

  public Player(String label) {
    this.initRand();
    this.name = label; 
  }

  public void initRand() {
    this.name = defaultNames[this.rdm.nextInt(this.defaultNames.length)];
    this.mmr = this.rdm.nextInt(10000);
    this.totalGames=this.rdm.nextInt(1250);
    this.gamesWon = this.rdm.nextInt(this.totalGames); 

    this.kills = this.rdm.nextInt(100);
    this.deaths = this.rdm.nextInt(100);
    this.assists = this.rdm.nextInt(100);
    this.lasthit = this.rdm.nextInt(400);
    this.denies = this.rdm.nextInt(400);
    this.gpm = this.rdm.nextInt(1000);
    this.xpm = this.rdm.nextInt(1000);
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
