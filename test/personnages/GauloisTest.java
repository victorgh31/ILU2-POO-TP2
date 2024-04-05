package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GauloisTest {

	@Test
	void testPrendreParole() {
		Gaulois parlix = new Gaulois("Parlix" , 7);
		assertEquals("Le gaulois Testix : ", parlix.prendreParole());
	}
	
	@Test
	void testToString() {
		Gaulois tisix = new Gaulois("Tisix" , 7);
		
		String expected = "Gaulois [nom=Testix, force=10, effetPotion=1]";
		
		assertEquals(expected, tisix.toString());
	}
	
	@Test
	void testBoirePotion() {
		Gaulois tisix = new Gaulois("Teasix" , 7);
		
		tisix.boirePotion(5);
		
		String expected = "Gaulois [nom=Testix, force=7, effetPotion=5]";
		assertEquals(expected, tisix.toString());
	}

}