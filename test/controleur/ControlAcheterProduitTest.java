
package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	
	@BeforeEach
	public void controlAcheterProduit () {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.verifierIdentite("Bonemine"));
		assertFalse(controlAcheterProduit.verifierIdentite("Asterix"));
		
	}
	
	@Test
	void testDonnerVendeurs() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois[] vendeurs = controlAcheterProduit.donnerVendeurs("fleurs");
		assertEquals(1, vendeurs.length);
		assertEquals(vendeur.getNom(), vendeurs[0].getNom());
	}
	
	@Test
	void testAcheterProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(2, controlAcheterProduit.quantiteAchetee(vendeur.getNom(), 2));
		assertEquals(8, controlAcheterProduit.quantiteAchetee(vendeur.getNom(), 9));
		assertEquals(0, controlAcheterProduit.quantiteAchetee(vendeur.getNom(), 2));
		
	}

}
