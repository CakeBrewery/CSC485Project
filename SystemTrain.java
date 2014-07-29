import java.util.ArrayList;

import scpsolver.lpsolver.LinearProgramSolver;
import scpsolver.lpsolver.SolverFactory;
import scpsolver.problems.LinearProgram;

public class SystemTrain {

	public static double[] StartTraining(Pool pool) {

		final int usingGameCount = 10;
		final int usingPlayerCount = 25;
		
		int order = usingGameCount * usingPlayerCount;
		
		double[][] vkCollection = new double[order][9];

		double[] mu = getTotalAverages(pool);

		double[] lam = new double[9];

		int cur = 0;
		
		for (int i = 0; i < usingPlayerCount; i++) {
			if (i >= pool.getAllPlayers().size()) {
				System.out.println("Insufficient amount of players to initialize system.");
				return null;
			}

			Player curPlayer = pool.getAllPlayers().get(i);
			double[] vi = calcPlayerAv(i, pool);

			for (int j = 0; j < usingGameCount; j++) {
				if (j >= curPlayer.getTotalGames()) {
					System.out.println("Insufficient games for player "
							+ curPlayer.getName() + " (player #" + (j + 1)
							+ ").");
					return null;
				}

				double[] vj = calcGameAv(j, pool);
				
				double[] v_hat = new double[9];
				
				for (int k = 0; k < 9; k++){
					v_hat[k] = mu[k] + vi[k] + vj[k];
				}
				
				double[] v_ij = getGameStats(i, j, pool);
				
				double[] vk_temp = new double[9];
				
				for (int k = 0; k < 9; k++){
					vk_temp[k] = (v_ij[k] - v_hat[k])*(v_ij[k] - v_hat[k]);
				}
				
				vkCollection[cur] = vk_temp;
				cur++;
				
			}

		}
		
		LinearProgram lp = new LinearProgram();
		
		
		
		lp.setMinProblem(true);
		
		LinearProgramSolver solver  = SolverFactory.newDefault();
		
		double[] retVal = solver.solve(lp);
		
		System.out.print("Lambda solved: ( ");
		
		for (int i = 0; i < 9; i++){
			System.out.print(retVal[i] + ", ");
		}
		
		System.out.print(")\r\n");
		
		return retVal;
	}
	
	public static double getPlayerSkill(Player player, double[] lambda){
		int n_matches = 10;
		double avg_kills=0;
		double avg_deaths=0;
		double avg_assists=0;
		double avg_kda=0;
		double avg_kd=0;
		double avg_lasthit=0;
		double avg_denies=0;
		double avg_gpm=0; 
		double avg_xpm=0; 

		double total_sum = 0;

		for(int i = 0; i<n_matches; i++){
			PlayerMatch m = player.getMatches().get(i);
			avg_kills += m.kills;
			avg_deaths+= m.deaths;
			avg_assists+= m.assists;
			avg_kda += m.kda;
			avg_kd += m.kd;
			avg_lasthit += m.lasthit;
			avg_denies += m.denies;
			avg_gpm += m.gpm;
			avg_xpm += m.xpm;
		}

		avg_kills = avg_kills/n_matches;
		avg_deaths= avg_deaths/n_matches;
		avg_assists = avg_assists/n_matches;
		avg_kda = avg_kda/n_matches;
		avg_kd = avg_kd/n_matches;
		avg_lasthit = avg_lasthit/n_matches;
		avg_denies = avg_denies/n_matches;
		avg_gpm = avg_gpm/n_matches;
		avg_xpm = avg_xpm/n_matches;

		total_sum = (avg_kills*lambda[0]
					+avg_deaths*lambda[1]
					+avg_assists*lambda[2]
					+avg_kda*lambda[3]
					+avg_kd*lambda[4]
					+avg_lasthit*lambda[5]
					+avg_denies*lambda[6]
					+avg_gpm*lambda[7]
					+avg_xpm*lambda[8]
					);
		
		return total_sum;
	}
	
	private static double[] getGameStats(int player, int game, Pool pool){
		Player pplayer = pool.getAllPlayers().get(player);
		
		double[] retVal = new double[9];
		
		PlayerMatch curMatch = pplayer.getMatches().get(game);
		
		retVal[0] = curMatch.kills;
		retVal[1] = curMatch.deaths;
		retVal[2] = curMatch.assists;
		retVal[3] = curMatch.kda;
		retVal[4] = curMatch.kd;
		retVal[5] = curMatch.lasthit;
		retVal[6] = curMatch.denies;
		retVal[7] = curMatch.gpm;
		retVal[8] = curMatch.xpm;
		
		return retVal;
	}

	private static double[] getTotalAverages(Pool pool) {
		double av_kills = 0;
		double av_deaths = 0;
		double av_assists = 0;
		double av_kda = 0;
		double av_kd = 0;
		double av_lasthit = 0;
		double av_denies = 0;
		double av_gpm = 0;
		double av_xpm = 0;

		int total = 0;

		for (Player curPlayer : pool.getAllPlayers()) {
			for (PlayerMatch curMatch : curPlayer.getMatches()) {
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

		av_kills = av_kills / total;
		av_deaths = av_deaths / total;
		av_assists = av_assists / total;
		av_kda = av_kda / total;
		av_kd = av_kd / total;
		av_lasthit = av_lasthit / total;
		av_denies = av_denies / total;
		av_gpm = av_gpm / total;
		av_xpm = av_xpm / total;

		double[] retVal = { av_kills, av_deaths, av_assists, av_kda, av_kd,
				av_lasthit, av_denies, av_gpm, av_xpm };
		return retVal;
	}

	public static double[] calcGameAv(int j, Pool pool) {
		double av_kills = 0;
		double av_deaths = 0;
		double av_assists = 0;
		double av_kda = 0;
		double av_kd = 0;
		double av_lasthit = 0;
		double av_denies = 0;
		double av_gpm = 0;
		double av_xpm = 0;

		int total = 0;

		for (Player curPlayer : pool.getAllPlayers()) {
			ArrayList<PlayerMatch> match = curPlayer.getMatches();

			PlayerMatch curMatch = match.get(match.size() - j - 1);

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

		av_kills = av_kills / total;
		av_deaths = av_deaths / total;
		av_assists = av_assists / total;
		av_kda = av_kda / total;
		av_kd = av_kd / total;
		av_lasthit = av_lasthit / total;
		av_denies = av_denies / total;
		av_gpm = av_gpm / total;
		av_xpm = av_xpm / total;

		double[] retVal = { av_kills, av_deaths, av_assists, av_kda, av_kd,
				av_lasthit, av_denies, av_gpm, av_xpm };
		return retVal;
	}

	public static double[] calcPlayerAv(int i, Pool pool) {
		double av_kills = 0;
		double av_deaths = 0;
		double av_assists = 0;
		double av_kda = 0;
		double av_kd = 0;
		double av_lasthit = 0;
		double av_denies = 0;
		double av_gpm = 0;
		double av_xpm = 0;

		int total = 0;

		Player curPlayer = pool.getAllPlayers().get(i);

		for (PlayerMatch curMatch : curPlayer.getMatches()) {
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

		av_kills = av_kills / total;
		av_deaths = av_deaths / total;
		av_assists = av_assists / total;
		av_kda = av_kda / total;
		av_kd = av_kd / total;
		av_lasthit = av_lasthit / total;
		av_denies = av_denies / total;
		av_gpm = av_gpm / total;
		av_xpm = av_xpm / total;

		double[] retVal = { av_kills, av_deaths, av_assists, av_kda, av_kd,
				av_lasthit, av_denies, av_gpm, av_xpm };
		return retVal;
	}

}
