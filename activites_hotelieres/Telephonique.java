package activites_hotelieres;

import java.util.Date;
//le prix est d'une sec en euro
public class Telephonique extends Consommation {
	private String destination;
	
	public Telephonique(String dest,double prix) {
		super(prix);
		destination=dest;
	}

	@Override
	public String toString() {
		return "   Telephonique [destination=" + destination + "]= "+super.getPrix()+" euros";
	}
	
}
