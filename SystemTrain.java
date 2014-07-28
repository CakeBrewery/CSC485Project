import java.util.ArrayList;


public class SystemTrain {

	public static float[] StartTraining(Pool pool){
		float[] mu = getTotalAverages(pool);
		
		
	}

	private static float[] getTotalAverages(Pool pool) {
		float av_kills = 0; 
		float av_deaths = 0; 
		float av_assists = 0; 
		float av_kda = 0;
		float av_kd = 0;
		float av_lasthit = 0; 
		float av_denies = 0; 
		float av_gpm = 0; 
		float av_xpm = 0; 
		
		int total = 0;
		
		for (Player curPlayer : pool.getLooking()){
			for (PlayerMatch curMatch : curPlayer.getMatches()){
				av_kills += curMatch.kills; 
				av_deaths += curMatch.deaths; 
				av_assists += curMatch.assists; 
				av_kda += curMatch.kda;
				av_kd += curMatch.kd;
				av_lasthit += curMatch.lasthit; 
				av_denies += curMatch.denies; 
				av_gpm += curMatch.gpm; 
				av_xpm += curMatch.xpm; 
				total++;
			}
		}
		
		av_kills = av_kills/total; 
		av_deaths = av_deaths/total; 
		av_assists = av_assists/total; 
		av_kda = av_kda/total;
		av_kd = av_kd/total;
		av_lasthit = av_lasthit/total; 
		av_denies = av_denies/total; 
		av_gpm = av_gpm/total; 
		av_xpm = av_xpm/total; 
		
		float[] retVal = {av_kills, av_deaths, av_assists, av_kda, av_kd, av_lasthit, av_denies, av_gpm, av_xpm};
		return retVal;
	}
	
	public static float[] calcGameAv(int j, Pool pool){
		float av_kills = 0; 
		float av_deaths = 0; 
		float av_assists = 0; 
		float av_kda = 0;
		float av_kd = 0;
		float av_lasthit = 0; 
		float av_denies = 0; 
		float av_gpm = 0; 
		float av_xpm = 0; 
		
		int total = 0;
		
		for (Player curPlayer : pool.getLooking()){
			ArrayList<PlayerMatch> match = curPlayer.getMatches();
			
			PlayerMatch curMatch = match.get(match.size() - j);
			
			av_kills += curMatch.kills; 
			av_deaths += curMatch.deaths; 
			av_assists += curMatch.assists; 
			av_kda += curMatch.kda;
			av_kd += curMatch.kd;
			av_lasthit += curMatch.lasthit; 
			av_denies += curMatch.denies; 
			av_gpm += curMatch.gpm; 
			av_xpm += curMatch.xpm; 
			total++;
		}
		
		av_kills = av_kills/total; 
		av_deaths = av_deaths/total; 
		av_assists = av_assists/total; 
		av_kda = av_kda/total;
		av_kd = av_kd/total;
		av_lasthit = av_lasthit/total; 
		av_denies = av_denies/total; 
		av_gpm = av_gpm/total; 
		av_xpm = av_xpm/total; 
		
		float[] retVal = {av_kills, av_deaths, av_assists, av_kda, av_kd, av_lasthit, av_denies, av_gpm, av_xpm};
		return retVal;
	}

	public static float[] calcPlayerAv(int i, Pool pool){
		float av_kills = 0; 
		float av_deaths = 0; 
		float av_assists = 0; 
		float av_kda = 0;
		float av_kd = 0;
		float av_lasthit = 0; 
		float av_denies = 0; 
		float av_gpm = 0; 
		float av_xpm = 0; 
		
		int total = 0;
		
		Player curPlayer = pool.getLooking().get(i-1);
		
		for (PlayerMatch curMatch : curPlayer.getMatches()){
			av_kills += curMatch.kills; 
			av_deaths += curMatch.deaths; 
			av_assists += curMatch.assists; 
			av_kda += curMatch.kda;
			av_kd += curMatch.kd;
			av_lasthit += curMatch.lasthit; 
			av_denies += curMatch.denies; 
			av_gpm += curMatch.gpm; 
			av_xpm += curMatch.xpm; 
			total++;
		}
		
		av_kills = av_kills/total; 
		av_deaths = av_deaths/total; 
		av_assists = av_assists/total; 
		av_kda = av_kda/total;
		av_kd = av_kd/total;
		av_lasthit = av_lasthit/total; 
		av_denies = av_denies/total; 
		av_gpm = av_gpm/total; 
		av_xpm = av_xpm/total; 
		
		float[] retVal = {av_kills, av_deaths, av_assists, av_kda, av_kd, av_lasthit, av_denies, av_gpm, av_xpm};
		return retVal;
	}
	
}
