package activites_hotelieres;

import java.util.Objects;

public class Categ_chambre {
	private String nom="";
	private boolean bain;
	private boolean douche;
	private boolean televiseur;
	private double prix;
	
	public Categ_chambre(boolean bain,boolean douche,boolean televiseur,double prix) {
		this.bain=bain;
		this.douche=douche;
		this.televiseur=televiseur;
		if(this.bain==true)
			nom=nom+"bain ";
		if(this.douche==true)
			nom=nom+"douche ";
		if(this.televiseur)
			nom=nom+"televiseur";
		this.prix=prix;
		if(nom=="")
			nom="rien";
	}

	public String getNom() {
		return nom+" : "+prix+" euros par nuit";
	}

	public boolean isBain() {
		return bain;
	}

	public boolean isDouche() {
		return douche;
	}

	public boolean isTeleviseur() {
		return televiseur;
	}

	public double getPrix() {
		return prix;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categ_chambre other = (Categ_chambre) obj;
		return Objects.equals(nom, other.nom);
	}
	
	
}
