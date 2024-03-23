package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlAfficherMarche;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

    public void acheterProduit(String nomAcheteur) {
    	if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) { 
    		System.out.println("Je suis désolé " + nomAcheteur +
    				" mais il faut être un habitant de notre village pour commercer ici.");
    	} else {
	    	System.out.println("Quel produit voulez-vous acheter ?");
	        String produit = scan.next();
	        Gaulois[] infosVendeurs = controlAcheterProduit.donnerVendeurs(produit);
        
	        if (infosVendeurs.length == 0) {
	        	System.out.println("Désolé, mais personne ne vend ce produit au marché.");
	        } else {
		        StringBuilder question = new StringBuilder();
		        question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
		        
				for (int i=0; i<infosVendeurs.length; i++) {
					question.append(i+1 + " - " + infosVendeurs[i].getNom() + "\n");
				}
				
				int choixUtilisateur = Clavier.entrerEntier(question.toString());
				String nomVendeur = infosVendeurs[choixUtilisateur-1].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur "+ nomVendeur + 
						".\nBonjour " + nomAcheteur);
				
				System.out.println("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteSouhaitee = Integer.parseInt(scan.next());
				
				int quantiteAchetee = controlAcheterProduit.quantiteAchetee(nomVendeur, quantiteSouhaitee);
				
				if (quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit +
							", malheureusement il n'y en a plus !");
					
				//quantiteAchetee = quantiteDisponible (voir classe Etal)	
				} else if (quantiteSouhaitee > quantiteAchetee) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit +
							", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee + 
							". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
				} else {
					System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à Bonemine.");
				}
	        }
        }
    }
}
