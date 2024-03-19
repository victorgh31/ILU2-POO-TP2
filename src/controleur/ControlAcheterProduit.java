package controleur;

import java.util.Scanner;

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

    public void acheterProduit(String nomAcheteur) {
        Scanner scanner = new Scanner(System.in);

        // Demander le produit à acheter
        System.out.println("Quel produit voulez-vous acheter ?");
        String produit = scanner.nextLine();

        // Demander le nom du vendeur
        System.out.println("Chez quel commerçant voulez-vous acheter " + produit + " ?");
        String nomVendeur = scanner.nextLine();

        // Trouver l'étal du vendeur
        Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);

        // Vérifier l'identité de l'acheteur
        if (controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
            if (etalVendeur != null) {
                // Demander la quantité à acheter
                System.out.println("Combien de " + produit + " voulez-vous acheter ?");
                int quantiteAcheter = scanner.nextInt();

                // Acheter le produit
                boolean achatReussi = village.acheterProduit(nomAcheteur, etalVendeur.getVendeur(), produit, quantiteAcheter);
                if (achatReussi) {
                    System.out.println(nomAcheteur + " a acheté " + quantiteAcheter + " " + produit + " chez " + nomVendeur);
                } else {
                    System.out.println("L'achat de " + produit + " chez " + nomVendeur + " a échoué.");
                }
            } else {
                System.out.println("Le commerçant " + nomVendeur + " n'existe pas.");
            }
        } else {
            System.out.println("Vous n'êtes pas autorisé à effectuer des achats.");
        }
    }

}
