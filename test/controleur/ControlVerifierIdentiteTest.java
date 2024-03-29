package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;

    @BeforeEach
    public void initialiserVillage() {
        village = new Village("Test Village", 10, 5);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
    }

    @Test
    void testVerifierIdentiteVendeurExiste() {
        // Ajouter un vendeur au village
        village.ajouterHabitant(new Gaulois("Asterix", 10));

        // Vérifier l'identité du vendeur existant
        assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
    }

    @Test
    void testVerifierIdentiteVendeurExistePas() {
        // Vérifier l'identité d'un vendeur qui n'existe pas
        assertFalse(controlVerifierIdentite.verifierIdentite("Obelix"));
    }

    @Test
    void testVerifierIdentiteVillageVide() {
        // Vérifier l'identité d'un vendeur dans un village vide
        assertFalse(controlVerifierIdentite.verifierIdentite("Asterix"));
    }
}

