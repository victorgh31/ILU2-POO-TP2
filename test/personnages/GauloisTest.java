package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GauloisTest {

	@Test
	void testPrendreParole() {
		Gaulois parlix = new Gaulois("Parlix" , 7);
		assertEquals("Le gaulois Parlix : ", parlix.prendreParole());
	}
	
	@Test
	void testToString() {
		Gaulois string = new Gaulois("String" , 7);		
//		String expected = "Gaulois [nom=String, force=10, effetPotion=1]";
//		assertEquals(expected, string.toString());
		assertEquals("Gaulois [nom=String, force=7, effetPotion=1]", string.toString());
	}
	
	@Test
	void testBoirePotion() {
		Gaulois tisix = new Gaulois("Tisix" , 7);
		
		tisix.boirePotion(5);
		
		String expected = "Gaulois [nom=Tisix, force=7, effetPotion=5]";
		assertEquals(expected, tisix.toString());
	}

}