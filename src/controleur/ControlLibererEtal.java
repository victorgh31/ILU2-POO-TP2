package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        
        if (etal != null) {
            boolean etalOccupe = etal.isEtalOccupe();
            String nomVendeurEtal = etal.getVendeur().getNom();
            String produitVendu = etal.getProduit();
            int quantiteInitiale = etal.getQuantiteInitiale();
            int quantiteVendue = etal.getQuantiteInitiale() - etal.getQuantite();

            donneesEtal[0] = String.valueOf(etalOccupe);
            donneesEtal[1] = nomVendeurEtal;
            donneesEtal[2] = produitVendu;
            donneesEtal[3] = String.valueOf(quantiteInitiale);
            donneesEtal[4] = String.valueOf(quantiteVendue);
        }
        return donneesEtal;
	}
	
	public Etal isVendeur(String nomVendeur) {
		Etal vendeurReconnu = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return vendeurReconnu;
	}
}
