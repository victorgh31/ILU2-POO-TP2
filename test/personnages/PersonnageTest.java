package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {

	@Test
	void testPersonnage() {
		Personnage victor = null;
		try {
			victor = new Personnage("Victor", -7); // maillot de basket Peru
		} catch (AssertionError pbForce) {
			System.out.println("Il est interdit d'avoir une force inférieure à 0 !");
		}
		assertNull(victor);
	}
	
	@Test
	void testGetForce() {
		Personnage victor = new Personnage("Victor", 7);
		assertEquals(7, victor.getForce());
	}
	
	@Test
	void testGetNom() {
		Personnage victor = new Personnage("Victor", 7);
		assertEquals("Victor", victor.getNom());
	}

	@Test
	void testToString() {
		Personnage victor = new Personnage("Victor", 7);
		assertEquals("[nom=Victor, force=7]", victor.toString());
	}
	
	/* Demander pour le test sur parler */
	
	@Test
	void testPrendreParole() {
		Personnage victor = new Personnage("Victor", 7);
		assertEquals("Victor : ", victor.prendreParole());
	}
}
