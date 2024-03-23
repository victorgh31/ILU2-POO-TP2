package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] donnerVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int quantiteAchetee(String nomVendeur, int quantiteSouhaitee) {
		Etal vendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return vendeur.acheterProduit(quantiteSouhaitee);
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
}