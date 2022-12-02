package module_alemanha;
import java.io.Serializable;

public class TechnicalCommittee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3959253213519546454L;
	private String name;
	private String nickname;
	private String role;
	private int age;

	public TechnicalCommittee() {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		if (!role.isBlank()) {
			this.role = role;
		} else {
			throw new IllegalArgumentException("The role can't be empty!");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("The age can't be zero or negative!");
		}
	}

	public String getDiretorio() {
		return System.getProperty("user.dir");
	}

}
