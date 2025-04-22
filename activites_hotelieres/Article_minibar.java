package activites_hotelieres;

import java.util.Date;

public class Article_minibar extends Consommation {
	private String nom;

	public Article_minibar(String nom,double p) {
		super(p);
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "   Article_minibar [nom=" + nom + "]= "+super.getPrix()+" euros";
	}
	
}
