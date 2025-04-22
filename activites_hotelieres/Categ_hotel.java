package activites_hotelieres;

public class Categ_hotel {
	private int num_etoiles;
	private String nom;
	
	public Categ_hotel(int n) {
		num_etoiles=n;
		if(n==1)
			nom="economique";
		if(n==2)
			nom="milieu de gamme";
		if(n==3)
			nom="milieu de gamme-superieur";
		if(n==4)
			nom="milieu de haute gamme";
		if(n==5)
			nom="milieu tres haute gammes";	
	}

	public int getNum_etoiles() {
		return num_etoiles;
	}

	public String getNom() {
		return nom;
	}
	

}
