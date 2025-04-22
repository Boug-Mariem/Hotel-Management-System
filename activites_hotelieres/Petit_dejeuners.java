package activites_hotelieres;

import java.util.Date;
//utiliser par client 
public class Petit_dejeuners extends Consommation {
	private Categorie_pd categ;

	public Petit_dejeuners(Categorie_pd categ) {
		super(categ.getPrix());
		this.categ=categ;
	}
	
	public Categorie_pd getCateg() {
		return categ;
	}
	@Override
	public String toString() {
		return "   "+categ.getNom()+"  "+categ.getPrix()+" euro";
	}
}
