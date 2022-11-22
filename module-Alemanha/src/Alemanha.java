import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Alemanha implements NationalTeamInfos {
	private String name;
	
	private List<Player> players = new ArrayList<Player>();
	private List<TechnicalCommittee> technicalCommittee = new ArrayList<TechnicalCommittee>();
	private List<PressOfficer> pressOfficers = new ArrayList<PressOfficer>();
	private Consults c = new Consults();
	
	public Alemanha() {
		this.name = "Alemanha";
		if (players.isEmpty() || technicalCommittee.isEmpty() || pressOfficers.isEmpty()) {

			try {
				ObjectInputStream oisP = new ObjectInputStream(new FileInputStream("teamGerman.txt"));
				ObjectInputStream oisTC = new ObjectInputStream(new FileInputStream("technicalCommittes.txt"));
				ObjectInputStream oisPO = new ObjectInputStream(new FileInputStream("pressOfficers.txt"));
				
				while (players.size() <= 10) {
					players.add((Player) oisP.readObject());
				}
				
				while (technicalCommittee.size() <= 2) {
					technicalCommittee.add((TechnicalCommittee) oisTC.readObject());
				}
				
				while (pressOfficers.size() <= 1) {
					pressOfficers.add((PressOfficer) oisPO.readObject());
				}
				
				oisP.close();
				oisTC.close();
				oisPO.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		incCalls(1);
		int membersTeam = 0;
		membersTeam = players.size();
		membersTeam += technicalCommittee.size();
		membersTeam += pressOfficers.size();
		return membersTeam;
	}

	@Override
	public int getOldestPlayer() {
		incCalls(1);
		Player playerOld= null;
		for(Player p : players) {
			if (playerOld != null) {
				if (playerOld.getIdade() < p.getIdade()) {
					playerOld = p;
				}
			} else {
				playerOld = p;
			}
		}
		return playerOld.getIdade();
	}

	@Override
	public int getYoungestPlayer() {
		incCalls(1);
		Player playerYoung= null;
		for(Player p : players) {
			if (playerYoung != null) {
				if (p.getIdade() < playerYoung.getIdade()) {
					playerYoung = p;
				}
			} else {
				playerYoung = p;
			}
		}
		return playerYoung.getIdade();
	}

	@Override
	public double getAverageAge() {
		incCalls(1);
		int sumAge = 0;
		for (Player p : players) {
			sumAge += p.getIdade();
		}
		return sumAge/players.size();
	}

	@Override
	public String getPlayer(int number) {
		incCalls(1);
		for (Player p: players) {
			if (number == p.getNumber()) {
				c.setCallsPlayer(1, p);
				return organizarFormatJson(p);
			}
		}
		return null;
	}
	
	public String organizarFormatJson(Player player) {
		return  "{number:" + player.getNumber() + " ,"
		+ "name:\"" + player.getName() + "\" ,"
		+ "nickname:\"" + player.getNickname() + "\" ,"
		+ "height:" + player.getHeight() + " ,"
		+ "weight:" + player.getWeight() + " ,"
		+ "birthDate:\"" + player.getBirthDate() + "\" ,"
		+ "position:\"" + player.getPosition() + "\" ,"
		+ "currentClub:\""+ player.getCurrentClub() + "\"}";
	}
	
	@Override
    public String getPressOfficerContacts() {
		incCalls(1);
        if (!pressOfficers.isEmpty()) {
        	return organizarFormatJsonPO(pressOfficers.get(0));        	
        }
        
        return null;
    }

    public String organizarFormatJsonPO(PressOfficer pressOfficer) {
        return "{name:\"" + pressOfficer.getName() + "\","
                + " tel1:\"" + pressOfficer.getTel1() + "\","
                + " tel2:\"" + pressOfficer.getTel2() + "\"," 
                + " emailAccount:\"" + pressOfficer.getEmail() + "\"}";
    }

	@Override
	public String getCountryName() {
		incCalls(1);
		return getName();
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public Image getFlagImage() {
		incCalls(1);
		try {
			BufferedImage img = ImageIO.read(new File("German.png"));
	        ImageIcon icon= new ImageIcon(img);
	        Image i = icon.getImage();
	        return i;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Path getTechnicalCommittee() {
		incCalls(1);
		File file = new File("technicalCommittes.txt");
		return file.getAbsoluteFile().toPath();
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return this.c;
	}
	
	public void incCalls(int inc) {
		c.setCalls(inc);
	}
	
}
