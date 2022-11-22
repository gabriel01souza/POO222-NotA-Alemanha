import java.io.Serializable;

public class PressOfficer  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String tel1;
	private String tel2;
	private String email;

	public PressOfficer() {
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

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		if (!tel1.isBlank()) {
			this.tel1 = tel1;			
		} else {
			throw new IllegalArgumentException("The number phone can't be empty!");			
		}
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		if (!tel2.isBlank()) {
			this.tel2 = tel2;			
		} else {
			throw new IllegalArgumentException("The number phone can't be empty!");			
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!email.isBlank()) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("The email can't be empty!");			
		}

	}

}
