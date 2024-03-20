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
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {     	
			System.out.println("Bonjour " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
	    	System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
	    	
	    	if (!controlPrendreEtal.resteEtals()) {
	    		System.out.println("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
	    	} else {
	    		System.out.println("C'est parfait, il me reste un étal pour vous !");
	    		System.out.println("Il me faudrait quelques renseignements :");
	    		System.out.println("Quel produit souhaitez-vous vendre ?");
	    		//clavuer
	    		System.out.println("Combien souhaitez-vous en vendre ?");
	    	}
		}	
            
	}

	private void installerVendeur(String nomVendeur) {
		prendreEtal(nomVendeur);
	}
}
