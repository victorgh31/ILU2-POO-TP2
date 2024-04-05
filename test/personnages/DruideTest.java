
package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DruideTest {

	@Test
	void testBooster() {
		Gaulois gaulois1 = new Gaulois("Astérix", 5);
		Druide druide1 = new Druide("Panoramix", 2, 5, 7);
		druide1.preparerPotion();
		druide1.booster(gaulois1);
		
		assertTrue(gaulois1.getEffetPotion() >= 5);
		assertTrue(gaulois1.getEffetPotion() <= 7);
	}
	
	@Test
	void testBoosterObelix() {
		Gaulois gaulois2 = new Gaulois("Obélix", 5);
		Druide druide2 = new Druide("Panasonix", 2, 5, 7);
		druide2.preparerPotion();
		druide2.booster(gaulois2);
		
		assertTrue(gaulois2.getEffetPotion() == 1);
	}
	
	@Test
	void testBoosterPlusPlus() {
		Gaulois gaulois3 = new Gaulois("Idefix", 5);
		Druide druide3 = new Druide("Paricilefrix", 2, 8, 10);
		druide3.preparerPotion();
		druide3.booster(gaulois3);
		
		assertTrue(gaulois3.getEffetPotion() >= 8);
		assertTrue(gaulois3.getEffetPotion() <= 10);
	}
}
