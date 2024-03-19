package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}
    /**
     * Renvoie les informations sur tous les étals du marché.
     * Chaque étal est décrit sur 3 cases du tableau successives :
     * le nom du vendeur, le nombre de produit qu'il lui reste à vendre, le type de produit à vendre.
     * @return un tableau de chaînes contenant les informations sur les étals du marché
     */
    public String[] afficherEtalsMarche() {
        return village.donnerEtatMarche();
    }
}