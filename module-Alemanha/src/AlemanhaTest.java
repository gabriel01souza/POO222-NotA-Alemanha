import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class AlemanhaTest {
	
	private Alemanha german;
		
	@Test
	public void AlemanhagetHowManyMembers() {
		german = new Alemanha();
		assertEquals(16, german.getHowManyMembers());
	}
	
	@Test
	public void AlemanhagetHowManyMembersError() {
		german = new Alemanha();
		assertNotEquals(15, german.getHowManyMembers());
	}
	
	@Test
	public void AlemanhagetOldestPlayer() {
		german = new Alemanha();
		assertEquals(37,german.getOldestPlayer());
	}
	
	@Test
	public void AlemanhagetOldestPlayerError() {
		german = new Alemanha();
		assertNotEquals(35,german.getOldestPlayer());
	}
	
	@Test
	public void AlemanhagetYoungestPlayer() {
		german = new Alemanha();
		assertEquals(23, german.getYoungestPlayer());
	}
	
	@Test
	public void AlemanhagetYoungestPlayerError() {
		german = new Alemanha();
		assertNotEquals(20, german.getYoungestPlayer());
	}
	
	@Test
	public void AlemanhagetAverageAge() {
		german = new Alemanha();
		assertEquals(31, german.getAverageAge());
	}
	
	@Test
	public void AlemanhagetAverageAgeError() {
		german = new Alemanha();
		assertNotEquals(28, german.getAverageAge());
	}
	
	@Test
	public void AlemanhagetCountryName() {
		String countryName = "Alemanha";
		german = new Alemanha();
		assertEquals(countryName, german.getCountryName());
	}
	
	@Test
	public void AlemanhagetCountryNameError() {
		String countryName = "Brazil";
		german = new Alemanha();
		assertNotEquals(countryName, german.getCountryName());
	}
	
	@Test
	public void AlemanhaConsults() {
		german = new Alemanha();
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
