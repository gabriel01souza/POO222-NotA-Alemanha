import java.util.HashMap;

import fifa.NationalTeamStats;

public class Consults implements NationalTeamStats {
	private int calls;
	private HashMap<Integer, Integer> callsPlayer = new HashMap<Integer, Integer>();;
	
	@Override
	public int getHowManyQuestions() {
		return this.calls;
	}

	@Override
	public int getHowManyCallsToPlayer(int number) {
		int result = callsPlayer.get(number);
		return result;
	}

	public Consults() {
		super();
	}

	public int getCalls() {
		return calls;
	}

	public void setCalls(int call) {
		this.calls += call;
	}

	public void setCallsPlayer(int i, Player p) {
		int aux = 0;
		if (this.callsPlayer.containsKey(p.getNumber())) {
			aux = this.callsPlayer.get(p.getNumber());			
		}
		this.callsPlayer.put(p.getNumber(), aux + i);
	}
}
