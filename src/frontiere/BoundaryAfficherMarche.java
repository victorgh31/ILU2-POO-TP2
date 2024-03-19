package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
        String[] infosEtals = controlAfficherMarche.afficherEtalsMarche();
        if (infosEtals.length > 0) {
            System.out.println("Voici les étals disponibles sur le marché :");
            for (int i = 0; i < infosEtals.length; i += 3) {
                String nomVendeur = infosEtals[i];
                int quantiteRestante = Integer.parseInt(infosEtals[i + 1]);
                String produit = infosEtals[i + 2];
                System.out.println("Vendeur : " + nomVendeur + ", Produit : " + produit + ", Quantité restante : " + quantiteRestante);
            }
        } else {
            System.out.println("Il n'y a aucun étal disponible sur le marché pour le moment.");
        }
    }
}
