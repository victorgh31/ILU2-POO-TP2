package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation ...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
		fail("Not yet implemented");
	}
	
    @Test
    void testIsHabitant() {
        Village village = new Village("Test Village", 10, 5);
        
        // On ajoute des habitants
        village.ajouterHabitant(new Gaulois("Asterix", 10));
        village.ajouterHabitant(new Druide("Panoramix", 8, 5, 15));
        
        ControlEmmenager controller = new ControlEmmenager(village);
        
        // On teste la méthode
        assertTrue(controller.isHabitant("Asterix"));
        assertTrue(controller.isHabitant("Panoramix"));
        // On vérifie qu'Obélix n'est pas dans le village
        assertFalse(controller.isHabitant("Obelix")); 
    }
	
    @Test
    void testAjouterDruide() {
        Village village = new Village("Test Village", 10, 5);
        
        ControlEmmenager controller = new ControlEmmenager(village);
        
        // On ajoute un druide
        controller.ajouterDruide("Panoramix", 8, 5, 15);
        
        // On vérifie que le druide ait été ajouté
        assertNotNull(village.trouverHabitant("Panoramix"));
        assertTrue(village.trouverHabitant("Panoramix") instanceof Druide);
    }
    
    @Test
    void testAjouterGaulois() {
        Village village = new Village("Test Village", 10, 5);
        
        ControlEmmenager controller = new ControlEmmenager(village);
        
        // On ajoute un gaulois
        controller.ajouterGaulois("Asterix", 10);
        
        // On vérifie que la gaulois ait été ajouté
        assertNotNull(village.trouverHabitant("Asterix"));
        assertTrue(village.trouverHabitant("Asterix") instanceof Gaulois);
    }
}

