package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		
		Gaulois vendeur = village.trouverHabitant(nomVendeur);

        if (vendeur != null && village.rechercherEtal(vendeur) != null) {
            return true;
        }
        
		return false;
	}
}
