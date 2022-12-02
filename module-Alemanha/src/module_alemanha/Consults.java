package module_alemanha;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import fifa.NationalTeamStats;

public class Consults implements NationalTeamStats {
	private int calls;
	private HashMap<Integer, Integer> callsPlayer = new HashMap<Integer, Integer>();

	@Override
	public int getHowManyQuestions() {
		return this.calls;
	}

	@Override
	public int getHowManyCallsToPlayer(int number) {
		if (callsPlayer.containsKey(number)) {
			int result = callsPlayer.get(number);
			return result;
		}
		return 0;
	}

	public Consults() {
		super();
	}

	public int getCalls() {
		return calls;
	}

	public void setCalls(int call) {
		this.calls = call;
	}

	public void setCallsPlayer(Player p, boolean begin) {
		int inc = 0;
		switch (p.getNumber()) {
		case 10:
			File f = new File("player10.txt");
			if (begin) {
				inc = ler(f, f.exists());
			} else {
				inc = gravar(f);
			}
			callsPlayer.put(p.getNumber(), inc);
			break;
		case 12:
			File f1 = new File("player12.txt");
			if (begin) {
				inc = ler(f1, f1.exists());
			} else {
				inc = gravar(f1);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 9:
			File f2 = new File("player9.txt");
			if (begin) {
				inc = ler(f2, f2.exists());
			} else {
				inc = gravar(f2);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 4:
			File f3 = new File("player4.txt");
			if (begin) {
				inc = ler(f3, f3.exists());
			} else {
				inc = gravar(f3);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 2:
			File f4 = new File("player2.txt");
			if (begin) {
				ler(f4, f4.exists());
			} else {
				inc = gravar(f4);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 13:
			File f5 = new File("player13.txt");
			if (begin) {
				ler(f5, f5.exists());
			} else {
				inc = gravar(f5);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 16:
			File f6 = new File("player16.txt");
			if (begin) {
				inc = ler(f6, f6.exists());
			} else {
				inc = gravar(f6);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 17:
			File f7 = new File("player17.txt");
			if (begin) {
				inc = ler(f7, f7.exists());
			} else {
				inc = gravar(f7);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 8:
			File f8 = new File("player8.txt");
			if (begin) {
				ler(f8, f8.exists());
			} else {
				inc = gravar(f8);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 22:
			File f9 = new File("player22.txt");
			if (begin) {
				ler(f9, f9.exists());
			} else {
				inc = gravar(f9);
			}
			callsPlayer.put(p.getNumber(), inc);				
			break;
		case 19:
			File f10 = new File("player19.txt");
			if (begin) {
				inc = ler(f10, f10.exists());
			} else {
				inc = gravar(f10);				
			}
			callsPlayer.put(p.getNumber(), inc);
			break;
		default:
			break;
		}
	}

	public int ler(File file, boolean fileExists) {
		try {
			if (!fileExists) {
				file.createNewFile();
				FileOutputStream fw = new FileOutputStream(file);
				fw.write(0);
				fw.close();
			} else {
				FileInputStream fr = new FileInputStream(file);
				int a = fr.read();
				fr.close();
				return a;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int gravar(File file) {
		try {
			FileInputStream fr = new FileInputStream(file);
			int result = fr.read();
			result = result + 1;
			clear(file);
			FileOutputStream fw = new FileOutputStream(file);
			fw.write(result);
			fr.close();
			fw.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void clear(File file) {
		try {
			FileWriter fw = new FileWriter(file, false);
			PrintWriter pw = new PrintWriter(fw, false);
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception exception) {
			System.out.println("Exception have been caught");
		}
	}
}
