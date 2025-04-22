package activites_hotelieres;

import java.time.LocalDate;

public class Chambre
{
    private static int num;
	private int numero;
    private int nb_lit1;
    private int nb_lit2;
    private int etage;
    private Categ_chambre categ;
    private Consommer[] liste_consommer=new Consommer[100];
    int inserer_cons;
    private Reserver[] liste_reservation=new Reserver[100];
    int inserer_res;
    private Occuper[] liste_occupation=new Occuper[100];
    int inserer_occ;
	public Chambre(int nb_lit1, int nb_lit2, int etage, Categ_chambre categ) {		
		numero=num;
		this.nb_lit1 = nb_lit1;
		this.nb_lit2 = nb_lit2;
		this.etage = etage;
		this.categ = categ;
		num++;
	}
	@Override
	public String toString() {
		return "  *chambre numero "+numero+" contient "+nb_lit1+" lit a 1 et "+nb_lit2+" lit a 2"+"\n   contient: "+categ.getNom();
	}
	public int getNumero() {
		return numero;
	}
	
	public int getNb_lit1() {
		return nb_lit1;
	}
	public int getNb_lit2() {
		return nb_lit2;
	}
	public int getEtage() {
		return etage;
	}
	public Categ_chambre getCateg() {
		return categ;
	}
	public Consommer[] getListe_consommer() {
		return liste_consommer;
	}
	public Reserver[] getListe_reservation() {
		return liste_reservation;
	}
	public int getInserer_res() {
		return inserer_res;
	}
	public Occuper[] getListe_occupation() {
		return liste_occupation;
	}
	
	public int getInserer_occ() {
		return inserer_occ;
	}
	public boolean estreserver(LocalDate dres1, int p) {
		int i=0;
		while(i<inserer_res ) {
			if((dres1.isBefore(liste_reservation[i].getDebut()) && dres1.plusDays(p).isBefore(liste_reservation[i].getDebut())||(dres1.isAfter(liste_reservation[i].getFin()))))
				i++;
			else return true;
		}
		return false;
	}
	public void inserer_reservation(Reserver res1) {
		liste_reservation[inserer_res]=res1;
		inserer_res++;		
	}
	public void affiche_reservations() {
		for(int i=0;i<inserer_res;i++)
			System.out.println(liste_reservation[i]);
		System.out.print("\n");
	}
	public boolean estoccuper(LocalDate dres1, int p) {
		int i=0;
		while(i<inserer_occ ) {
			if((dres1.isBefore(liste_occupation[i].getDebut()) && dres1.plusDays(p).isBefore(liste_occupation[i].getDebut())||(dres1.isAfter(liste_occupation[i].getFin()))))
				i++;
			else
				return true;
		}
		return false;
	}
	public void inserer_occupation(Occuper occ1) {
		liste_occupation[inserer_occ]=occ1;
		inserer_occ++;
		
	}
	public void affiche_occupation() {
		for(int i=0;i<inserer_occ;i++) {
			System.out.println(liste_occupation[i]);
		}
		System.out.print("\n");
		
	}
	
	public boolean estreserver_parautre(LocalDate dres1, int p,Responsable r) {
		int i=0;
		while(i<inserer_res) {
			if((dres1.isBefore(liste_reservation[i].getDebut()) && dres1.plusDays(p).isBefore(liste_reservation[i].getDebut())||(dres1.isAfter(liste_reservation[i].getFin()))))
				i++;
			else {
				if(liste_reservation[i].getResponsable().getNum_client()!=r.getNum_client())
					return true;
				else
					return false;
			}		
		}
		return false;
	}
	
	public boolean estoccupation_parreservation(LocalDate dres1, int p,Responsable r) {
		int i=0;
		while(i<inserer_res)
			if((dres1.equals(liste_reservation[i].getDebut()) && p==liste_reservation[i].getPeriode() && liste_reservation[i].getResponsable().getNum_client()==r.getNum_client() ))
				return true;
		return false;
	}
	
	
	public void inserer_consommation(Consommer cons) {
		liste_consommer[inserer_cons]=cons;
		inserer_cons++;		
	}
	public void affiche_consommation_totle() {
		double prix=0;
		for(int i=0;i<inserer_cons;i++) {
			System.out.println(liste_consommer[i]);
			prix=prix+liste_consommer[i].getPrix();
		}
		System.out.println("le prix totale est: "+prix);
		System.out.print("\n");
	}
	public void affiche_consommation_occupation(int ind_occupation) {
		Occuper occ=liste_occupation[ind_occupation];
		double prix=0;
		for(int i=0;i<inserer_cons;i++) {
			if( liste_consommer[i].getDate().isAfter(occ.getDebut()) && liste_consommer[i].getDate().isBefore(occ.getFin()) || liste_consommer[i].getDate().equals(occ.getFin()) || liste_consommer[i].getDate().equals(occ.getDebut())) {
				System.out.println(liste_consommer[i]);
				prix=prix+liste_consommer[i].getPrix();
			}
		}
		System.out.println("le prix totale des consommatioms est: "+prix);
		System.out.print("\n");	
	}
	// surcharge de la fonction affiche_consommation_occupation
	public double affiche_consommation_occupation(Occuper occ) {
		double prix=0;
		for(int i=0;i<inserer_cons;i++) {
			if( liste_consommer[i].getDate().isAfter(occ.getDebut()) && liste_consommer[i].getDate().isBefore(occ.getFin()) || liste_consommer[i].getDate().equals(occ.getFin()) || liste_consommer[i].getDate().equals(occ.getDebut())) {
				System.out.println(liste_consommer[i]);
				prix=prix+liste_consommer[i].getPrix();
			}
		}
		System.out.println("le prix totale des consommatioms est: "+prix);
		//System.out.print("\n");	
		return prix;
	}
	
	
	
	public Occuper[] getliste_occuper_nom_payer(Responsable r) {
		Occuper[] liste_non_payer=new Occuper[10];
		int j=0;
		for(int i=0;i<inserer_occ;i++) {
			if(liste_occupation[i].getResponsable().getNum_client()==r.getNum_client() && liste_occupation[i].isPayer()==false) {
				liste_non_payer[j]=liste_occupation[i];
				j++;
			}	
		}
		return liste_non_payer;
	}
	public boolean verifconsommation(LocalDate date, Responsable r) {
		int i=0;
		while (i<inserer_occ) {
			if(date.isAfter(liste_occupation[i].getDebut()) && date.isBefore(liste_occupation[i].getFin()) || date.equals(liste_occupation[i].getDebut()) || date.equals(liste_occupation[i].getFin()) ) {
				if(r.equals(liste_occupation[i].getResponsable() ) )
					return true;
				
			}
			i++;
		}
		return false;
	}
	
	
    
    
}