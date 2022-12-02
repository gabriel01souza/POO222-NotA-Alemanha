package module_alemanha;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private String name;
	private String nickname;
	private double height;
	private double weight;
	private LocalDate birthDate;
	private String position;
	private String currentClub;

	public Player() {
	}

	public int getIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(this.birthDate, dataAtual);
		return periodo.getYears();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number >= 0) {
			this.number = number;
		} else {
			throw new IllegalArgumentException("The player's number can't be negative!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isBlank()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("The name can't be empty!");
		}
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		if (name != null && !name.isBlank()) {
			this.nickname = nickname;
		} else {
			throw new IllegalArgumentException("The nickname can't be empty!");
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height >= 0) {
			this.height = height;
		} else {
			throw new IllegalArgumentException("The player's height can't be negative!");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight >= 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException("The player's weight can't be negative!");
		}
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		if (!birthDate.isAfter(LocalDate.now()) || birthDate.equals(LocalDate.now())) {
			this.birthDate = birthDate;
		} else {
			throw new IllegalArgumentException("The birthdate need to be before today's date.");
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (!position.isBlank()) {
			this.position = position;
		} else {
			throw new IllegalArgumentException("The position can't be empty!");
		}
	}

	public String getCurrentClub() {
		return currentClub;
	}

	public void setCurrentClub(String currentClub) {
		if (!currentClub.isBlank()) {
			this.currentClub = currentClub;
		} else {
			throw new IllegalArgumentException("The currentClub can't be empty!");
		}
	}

}
