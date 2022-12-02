package module_alemanha;

import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class alemanha implements NationalTeamInfos {
	private String name;

	private List<Player> players = new ArrayList<Player>();
	private List<TechnicalCommittee> technicalCommittee = new ArrayList<TechnicalCommittee>();
	private List<PressOfficer> pressOfficers = new ArrayList<PressOfficer>();
	private Consults c = new Consults();

	public alemanha() {
		this.name = "Alemanha";
		if (players.isEmpty() || technicalCommittee.isEmpty() || pressOfficers.isEmpty()) {

			try {
				ObjectInputStream bfs1 = new ObjectInputStream(getClass().getResourceAsStream("/Files/teamGerman.txt"));
				ObjectInputStream bfs2 = new ObjectInputStream(
						getClass().getResourceAsStream("/Files/technicalCommittes.txt"));
				ObjectInputStream bfs3 = new ObjectInputStream(
						getClass().getResourceAsStream("/Files/pressOfficers.txt"));

				while (players.size() <= 10) {
					players.add((Player) bfs1.readObject());
				}
				while (technicalCommittee.size() <= 2) {
					technicalCommittee.add((TechnicalCommittee) bfs2.readObject());
				}
				while (pressOfficers.size() <= 1) {
					pressOfficers.add((PressOfficer) bfs3.readObject());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		c.setCalls(ler(true));
		players.forEach(p -> c.setCallsPlayer(p, Boolean.TRUE));
	}

	public void addPlayer(Player player) {
		if (player != null) {
			this.players.add(player);
		}
	}

	public void addTechnicalCommittee(TechnicalCommittee committee) {
		if (committee != null) {
			this.technicalCommittee.add(committee);
		}
	}

	public void addPressOfficer(PressOfficer pressOfficer) {
		if (pressOfficer != null) {
			this.pressOfficers.add(pressOfficer);
		}
	}

	@Override
	public int getHowManyMembers() {
		incCalls();
		int membersTeam = 0;
		membersTeam = players.size();
		membersTeam += technicalCommittee.size();
		membersTeam += pressOfficers.size();
		return membersTeam;
	}

	@Override
	public int getOldestPlayer() {
		incCalls();
		Player playerOld = null;
		for (Player p : players) {
			if (playerOld != null) {
				if (playerOld.getIdade() < p.getIdade()) {
					playerOld = p;
				}
			} else {
				playerOld = p;
			}
		}
		return playerOld.getNumber();
	}

	@Override
	public int getYoungestPlayer() {
		incCalls();
		Player playerYoung = null;
		for (Player p : players) {
			if (playerYoung != null) {
				if (p.getIdade() < playerYoung.getIdade()) {
					playerYoung = p;
				}
			} else {
				playerYoung = p;
			}
		}
		return playerYoung.getNumber();
	}

	@Override
	public double getAverageAge() {
		incCalls();
		int sumAge = 0;
		for (Player p : players) {
			sumAge += p.getIdade();
		}
		return sumAge / players.size();
	}

	@Override
	public String getPlayer(int number) {
		incCalls();
		for (Player p : players) {
			if (number == p.getNumber()) {
				incrementarCallPlayer(p);
				return organizarFormatJson(p);
			}
		}
		return "Não existe jogador com este número!";
	}

	public void incrementarCallPlayer(Player p) {
		c.setCallsPlayer(p, Boolean.FALSE);
	}

	public String organizarFormatJson(Player player) {
		return "{number:" + player.getNumber() + " ," + "name:\"" + player.getName() + "\" ," + "nickname:\""
				+ player.getNickname() + "\" ," + "height:" + player.getHeight() + " ," + "weight:" + player.getWeight()
				+ " ," + "birthDate:\"" + player.getBirthDate() + "\" ," + "position:\"" + player.getPosition() + "\" ,"
				+ "currentClub:\"" + player.getCurrentClub() + "\"}";
	}

	@Override
	public String getPressOfficerContacts() {
		incCalls();
		if (!pressOfficers.isEmpty()) {
			return organizarFormatJsonPO(pressOfficers.get(0));
		}

		return null;
	}

	public String organizarFormatJsonPO(PressOfficer pressOfficer) {
		return "{name:\"" + pressOfficer.getName() + "\"," + " tel1:\"" + pressOfficer.getTel1() + "\"," + " tel2:\""
				+ pressOfficer.getTel2() + "\"," + " emailAccount:\"" + pressOfficer.getEmail() + "\"}";
	}

	@Override
	public String getCountryName() {
		incCalls();
		return getName();
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Image getFlagImage() {
		incCalls();
		try {
			return ImageIO.read(getClass().getResource("/Files/German.png").toURI().toURL());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Path getTechnicalCommittee() {
		incCalls();
		File file = new File("");
		return file.getAbsoluteFile().toPath();
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		incCalls();
		return this.c;
	}

	public void incCalls() {
		int incrementoAtual = ler(false);
		clear();
		try {
			BufferedWriter fos = new BufferedWriter(new FileWriter("incremento.txt"));
			fos.write(incrementoAtual);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setCalls(incrementoAtual);
	}

	public int ler(boolean isBegin) {
		try	{
			boolean criou = false;
			File file = new File("incremento.txt");
			if (!file.exists()) {
				file.createNewFile();
				criou = true;
			}
			FileReader in = new FileReader(file);
			if (criou) {
				FileWriter fw = new FileWriter(file);
				fw.write(0);
				fw.close();
			}
			int s = in.read();				
			if (!isBegin) {
				return s + 1;				
			} else {
				return s;
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler increment!");
			e.printStackTrace();
		}
		return 0;
	}

	public void clear() {
		try {
			FileWriter fw = new FileWriter("incremento.txt", false);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception exception) {
			System.out.println("Exception have been caught");
		}
	}
}
