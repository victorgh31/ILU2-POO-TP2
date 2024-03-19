package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		return village.rechercherEtal(village.trouverHabitant(nomVendeur));
	}
	
    public void partirVendeur(Gaulois vendeur) {
        // Implémentez la logique pour retirer le vendeur de l'étal ici
        Etal etal = village.rechercherEtal(vendeur);
        if (etal != null) {
            etal.libererEtal();
        }
    }
}


