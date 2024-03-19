package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
        String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
        
        if (donneesEtal != null) {
            boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
            String nomVendeurEtal = donneesEtal[1];
            String produitVendu = donneesEtal[2];
            int quantiteInitiale = Integer.parseInt(donneesEtal[3]);
            int quantiteVendue = Integer.parseInt(donneesEtal[4]);

            // Affichage des données
            System.out.println("Étal occupé : " + etalOccupe);
            System.out.println("Nom du vendeur : " + nomVendeurEtal);
            System.out.println("Produit vendu : " + produitVendu);
            System.out.println("Quantité de produit à vendre au début du marché : " + quantiteInitiale);
            System.out.println("Quantité de produit vendu : " + quantiteVendue);
        } else {
            System.out.println("Aucun étal trouvé pour le vendeur " + nomVendeur);
        }
    }

}
