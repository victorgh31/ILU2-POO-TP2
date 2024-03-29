package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
    private Village village;
    private ControlAfficherVillage controlAfficherVillage;

    @BeforeEach
    public void initialiserVillage() {
        village = new Village("Test Village", 10, 5);
        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);
        controlAfficherVillage = new ControlAfficherVillage(village);
    }

    @Test
    void testDonnerNomsVillageois() {
        // Ajouter des habitants au village
        village.ajouterHabitant(new Gaulois("Asterix", 10));
        village.ajouterHabitant(new Druide("Panoramix", 8, 5, 15));

        // Récupérer les noms des villageois à travers le contrôleur
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();

        // Vérifier que les noms des villageois sont corrects
        assertNotNull(nomsVillageois);
        assertEquals(3, nomsVillageois.length); // Chef + 2 villageois ajoutés
        assertEquals("Abraracourcix", nomsVillageois[0]); // Chef
        assertEquals("Asterix", nomsVillageois[1]); // Villageois 1
        assertEquals("le druide Panoramix", nomsVillageois[2]); // Villageois 2 (Druide)
    }
    
    @Test
    void testDonnerNomVillage() {
        assertEquals("Test Village", controlAfficherVillage.donnerNomVillage());
    }

    @Test
    void testDonnerNbEtals() {
        assertEquals(5, controlAfficherVillage.donnerNbEtals());
    }


}

