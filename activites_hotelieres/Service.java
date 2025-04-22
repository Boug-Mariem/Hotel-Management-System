package activites_hotelieres;

import java.util.Date;
//f=forfaitaire  p=proportionnel
public class Service extends Consommation {
	private String nom;
	private String type;
	public Service(String nom,double prix,String type) {
		super(prix);
		this.nom=nom;
		this.type=type;
	}
	public String getNom() {
		return nom;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "   Service [nom=" + nom+"]= "+super.getPrix()+" euros";
	}
	
	
	
}

