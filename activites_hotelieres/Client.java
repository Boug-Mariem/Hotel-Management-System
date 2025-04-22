package activites_hotelieres;

public class Client
{
	private static int num;
    private int num_client;
    private String nom;
    private String prenom;
    private Adresse ad_client;
    //pour le responsable pas ici liste de types chambre
	public Client(String nom, String prenom, Adresse ad_client) {
		num++;
		this.num_client = num;
		this.nom = nom;
		this.prenom = prenom;
		this.ad_client = ad_client;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getNum_client() {
		return num_client;
	}
	public String getNom() {
		return nom;
	}
	public Adresse getAd_client() {
		return ad_client;
	}
	
	    
}

