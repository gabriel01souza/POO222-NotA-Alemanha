package module_alemanha;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class AlemanhaTest {

	private alemanha german;

	@Test
	public void AlemanhagetHowManyMembers() {
		german = new alemanha();
		assertEquals(16, german.getHowManyMembers());
	}

	@Test
	public void AlemanhagetHowManyMembersError() {
		german = new alemanha();
		assertNotEquals(15, german.getHowManyMembers());
	}

	@Test
	public void AlemanhagetOldestPlayer() {
		german = new alemanha();
		assertEquals(37, german.getOldestPlayer());
	}

	@Test
	public void AlemanhagetOldestPlayerError() {
		german = new alemanha();
		assertNotEquals(35, german.getOldestPlayer());
	}

	@Test
	public void AlemanhagetYoungestPlayer() {
		german = new alemanha();
		assertEquals(23, german.getYoungestPlayer());
	}

	@Test
	public void AlemanhagetYoungestPlayerError() {
		german = new alemanha();
		assertNotEquals(20, german.getYoungestPlayer());
	}

	@Test
	public void AlemanhagetAverageAge() {
		german = new alemanha();
		assertEquals(31, german.getAverageAge());
	}

	@Test
	public void AlemanhagetAverageAgeError() {
		german = new alemanha();
		assertNotEquals(28, german.getAverageAge());
	}

	@Test
	public void AlemanhagetCountryName() {
		String countryName = "Alemanha";
		german = new alemanha();
		assertEquals(countryName, german.getCountryName());
	}

	@Test
	public void AlemanhagetCountryNameError() {
		String countryName = "Brazil";
		german = new alemanha();
		assertNotEquals(countryName, german.getCountryName());
	}

	@Test
	public void AlemanhaConsults() {
		german = new alemanha();
		german.getAverageAge();
		german.getHowManyMembers();
		german.getPlayer(9);
		german.getPlayer(10);
		german.getPlayer(10);

		assertEquals(5, german.getStatsResponsible().getHowManyQuestions());
		assertEquals(1, german.getStatsResponsible().getHowManyCallsToPlayer(9));
		assertEquals(2, german.getStatsResponsible().getHowManyCallsToPlayer(10));
	}
}
