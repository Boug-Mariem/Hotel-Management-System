package activites_hotelieres;
//utiliser par l'hotel
public class Categorie_pd {
	private String nom;
	private double prix;
	public Categorie_pd(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
