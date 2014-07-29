import java.util.*;

public class Player {

  private String[] defaultNames = {"Agnes","Alfred","Archy","Bart","Benjamin","Bertram","Bruni","Buster","Edith","Ester","Flo","Francis","Francisco","Gil","Gob","Gus","Hank","Harold","Harriet","Henry","Jacques","Jorge","Juan","Kitty","Lionel","Louie","Lucille","Lupe","Mabel","Maeby","Marco","Marta","Maurice","Maynard","Mildred","Monty","Mordecai","Morty","Pablo","Seymour","Stan","Tobias","Vivian","Walter","Wilbu"};
  Random rdm = new Random();

  //Profile data
  private ArrayList<PlayerMatch> matches = new ArrayList<PlayerMatch>();
  private String name;
  private int mmr = 0;
  private int totalGames = 0;
  private int gamesWon = 0;
  private boolean banned = false;
  private boolean troll = false;
  private int current_party_id = 0;

  //Player status
  public boolean ingame = false;
  public int gamenum = 0;
  public String faction = null;

  //total match statistics
    private int totalkills = 0;
    private int totaldeaths = 0;
    private int totalassists = 0;
    private int totalkda = 0;
    private int totalkd = 0;
    private int totallasthit = 0;
    private int totaldenies = 0;
    private int totalgpm = 0;
    private int totalxpm = 0;


  public Player() {
    this.initRand(25);
    this.totalGames = matches.size();
  }

  public Player(String label) {
    this.initRand(25);
    this.name = label;
  }

  public void initRand(int num_matches) {
    this.name = defaultNames[this.rdm.nextInt(this.defaultNames.length)];
    this.mmr = this.rdm.nextInt(10000);
    		
    for(int i = 0; i < num_matches; i++){
      PlayerMatch match = new PlayerMatch();
      match.kills = this.rdm.nextInt(100);
      this.totalkills += match.kills;
      match.deaths = this.rdm.nextInt(100);
      this.totaldeaths += match.deaths;
      match.assists = this.rdm.nextInt(100);
      this.totalassists += match.assists;
      match.lasthit = this.rdm.nextInt(400);
      this.totallasthit += match.lasthit;
      match.denies = this.rdm.nextInt(400);
      this.totaldenies += match.denies;
      match.gpm = this.rdm.nextInt(1000);
      this.totalgpm+= match.gpm;
      match.xpm = this.rdm.nextInt(1000);
      this.totalxpm += match.xpm;
      matches.add(match);
    }
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

  public ArrayList<PlayerMatch> getMatches(){
      return this.matches;
  }

  public String getName(){
    return name;
  }

  public String toString(){
    if(this.ingame){
      return ("In Game No. " + this.gamenum + " (" + this.faction + ") " + this.name+" MMR:"+this.mmr+" W/L/T:"+this.gamesWon+"/"+(this.totalGames-this.gamesWon)+"/"+this.totalGames);
    }
    else{
      return (this.name+" MMR:"+this.mmr+" W/L/T:"+this.gamesWon+"/"+(this.totalGames-this.gamesWon)+"/"+this.totalGames);
    }
  }
}
