package controleur;

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

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		// On prend un étal si l'identité du vendeur est vérifiée
        if (controlVerifierIdentite.verifierIdentite(nomVendeur)) {
            // On trouve un étal libre et on installe le vendeur
			int numeroEtal = -1;
			return numeroEtal;
		} else {
	        // Ici, l'identité n'est pas été vérifiée, donc on ne peut pas prendre d'étal
	        return -1;
	    }
	}

	public boolean verifierIdentite(String nomVendeur) {
		// On vérifie l'identité du vendeur à l'aide du contrôleur ControlVerifierIdentite
        return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
