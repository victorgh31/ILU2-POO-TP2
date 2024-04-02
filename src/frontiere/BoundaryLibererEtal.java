package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = donneesEtal[0].equals("0");
			String produit = donneesEtal[2];
			String quantiteInitial = donneesEtal[3];
			String quantiteVendu = donneesEtal[4];
			if (etalOccupe) {
				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit+".");
				System.out.println("En revoir " + nomVendeur + ", passez une bonne journée");
			}
		}
	}
}
