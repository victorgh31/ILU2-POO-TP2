package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		// On vérifie s'il reste des étals disponibles dans le village
		return village.rechercherEtalVide();
	}

/*	
	public boolean prendreEtal(String nomVendeur, String produit, int nbProduit) {
		// On prend un étal si l'identité du vendeur est vérifiée
        if (!controlVerifierIdentite.verifierIdentite(nomVendeur)) {      	
	        return false;
		} else {
    		return true;
	    }
	}
*/
	
	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		return village.installerVendeur(gaulois, produit, nbProduit);
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		// On vérifie l'identité du vendeur à l'aide du contrôleur ControlVerifierIdentite
        return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
}
