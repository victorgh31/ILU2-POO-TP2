package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
            System.out.println("L'identité du vendeur est vérifiée.");
            if (controlPrendreEtal.resteEtals()) {
                System.out.println("Il reste des étals disponibles dans le village.");
                System.out.print("Entrez le produit à vendre : ");
                String produit = scan.nextLine();
                System.out.print("Entrez le nombre de produits à vendre : ");
                int nbProduit = scan.nextInt();
                int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
                if (numeroEtal != -1) {
                    System.out.println("L'étal a été attribué au vendeur avec succès. Numéro de l'étal : " + numeroEtal);
                } else {
                    System.out.println("Impossible d'attribuer un étal au vendeur. Veuillez réessayer plus tard.");
                }
            } else {
                System.out.println("Tous les étals sont occupés pour le moment. Veuillez réessayer plus tard.");
            }
        } else {
            System.out.println("L'identité du vendeur n'a pas pu être vérifiée. Impossible de prendre un étal.");
        }
	}

	private void installerVendeur(String nomVendeur) {
		prendreEtal(nomVendeur);
	}
}
