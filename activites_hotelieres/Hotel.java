package activites_hotelieres;
import java.util.Arrays;

import java.time.LocalDate;

public class Hotel
{
    private String nom;
    private static int num;
    private Adresse ad_hotel;
    private LocalDate debut;
    private LocalDate fin;
    private Categ_hotel categ;
    private Chambre[] liste_chambres=new Chambre[25];
    private Consommation[] liste_consommation=new Consommation[20];
    private Facture[] liste_facture=new Facture[100];
    private int inser_facture;
    
    public Hotel(Adresse ad,LocalDate d,LocalDate f,Categ_hotel cat) {
    	ad_hotel=ad;
    	debut=d;
    	fin=f;
    	num++;
    	categ=cat;
    	nom="hotel "+num;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Hotel.num = num;
	}

	public Adresse getAd_hotel() {
		return ad_hotel;
	}

	public void setAd_hotel(Adresse ad_hotel) {
		this.ad_hotel = ad_hotel;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Categ_hotel getCateg() {
		return categ;
	}

	public void setCateg(Categ_hotel categ) {
		this.categ = categ;
	}

	public Chambre[] getListe_chambres() {
		return liste_chambres;
	}
	public Chambre getChambre(int n) {
		return liste_chambres[n];
	}

	public void setListe_chambres(Chambre[] liste_chambres) {
		this.liste_chambres = liste_chambres;
	}

	@Override
	public String toString() {
		return "Hotel:\n  nom :"+nom+"\n  categorie: "+categ.getNom()+"\n  Date ouverture : "+debut+" Date fermeture: "+fin+"\n  Adress:\n"+ad_hotel;
	}

	public void initialiser_chambre() {
		Categ_chambre cat1=new Categ_chambre(false,false,false,100);
		Categ_chambre cat2=new Categ_chambre(true,false,false,125);
		Categ_chambre cat3=new Categ_chambre(false,true,false,120);
		Categ_chambre cat4=new Categ_chambre(false,false,true,120);
		Categ_chambre cat5=new Categ_chambre(true,true,false,130);
		Categ_chambre cat6=new Categ_chambre(false,true,true,140);
		Categ_chambre cat7=new Categ_chambre(true,false,true,135);
		Categ_chambre cat8=new Categ_chambre(true,true,true,150);
		
		liste_chambres[0]=new Chambre(1,0,1, cat1);
		liste_chambres[1]=new Chambre(0,1,1, cat1);
		liste_chambres[2]=new Chambre(1,1,1, cat1);
		
		liste_chambres[3]=new Chambre(1,0,2, cat2);
		liste_chambres[4]=new Chambre(0,1,2, cat2);
		liste_chambres[5]=new Chambre(1,1,2, cat2);
		
		liste_chambres[6]=new Chambre(1,0,3, cat3);
		liste_chambres[7]=new Chambre(0,1,3, cat3);
		liste_chambres[8]=new Chambre(1,1,3, cat3);
		
		liste_chambres[9]=new Chambre(1,0,4, cat4);
		liste_chambres[10]=new Chambre(0,1,4, cat4);
		liste_chambres[11]=new Chambre(1,1,4, cat4);
		
		liste_chambres[12]=new Chambre(1,0,5, cat5);
		liste_chambres[13]=new Chambre(0,1,5, cat5);
		liste_chambres[14]=new Chambre(1,1,5, cat5);
		
		liste_chambres[15]=new Chambre(1,0,6, cat6);
		liste_chambres[16]=new Chambre(0,1,6, cat6);
		liste_chambres[17]=new Chambre(1,1,6, cat6);
		
		liste_chambres[18]=new Chambre(1,0,7, cat7);
		liste_chambres[19]=new Chambre(0,1,7, cat7);
		liste_chambres[20]=new Chambre(1,1,7, cat7);
		
		liste_chambres[21]=new Chambre(1,0,8, cat8);
		liste_chambres[22]=new Chambre(0,1,8, cat8);
		liste_chambres[23]=new Chambre(1,1,8, cat8);
		liste_chambres[24]=new Chambre(1,2,8, cat8);
		
	}
	void affiche_chambre() {
		System.out.println("les chambres de l'hotel sont: ");
		for(int i=0;i<25;i++)
			System.out.println(liste_chambres[i]);
	}
	public void initialiser_consommation() {
		Categorie_pd continental = new Categorie_pd("continental",15);
		Categorie_pd americain  = new Categorie_pd("americain",16);
		Categorie_pd anglais  = new Categorie_pd("anglais",17);
		Categorie_pd buffet  = new Categorie_pd("buffet",18);
		Categorie_pd asiatique  = new Categorie_pd("asiatique" ,19);
		Categorie_pd vegan  = new Categorie_pd("vegan",19.5);
				
		liste_consommation[0]=new Petit_dejeuners(continental);
		liste_consommation[1]=new Petit_dejeuners(americain);
		liste_consommation[2]=new Petit_dejeuners(anglais);
		liste_consommation[3]=new Petit_dejeuners(buffet);
		liste_consommation[4]=new Petit_dejeuners(asiatique);
		liste_consommation[5]=new Petit_dejeuners(vegan);
		
		liste_consommation[6]=new Service("blanchisserie",7,"f");
		liste_consommation[7]=new Service("sauna",70,"f");
		liste_consommation[8]=new Service("parking",2.4,"f");
		
		liste_consommation[9]=new Service("blanchisserie",35,"p");
		liste_consommation[10]=new Service("sauna",100,"p");
		liste_consommation[11]=new Service("parking",10,"p");
		
		liste_consommation[12]=new Article_minibar("chips",3000);
		liste_consommation[13]=new Article_minibar("fruits secs",5000);
		liste_consommation[14]=new Article_minibar("bonbons",200);
		liste_consommation[15]=new Article_minibar("eau",1200);
		liste_consommation[16]=new Article_minibar("boissons",400);
		
		liste_consommation[17]=new Telephonique("reception",0);
		liste_consommation[18]=new Telephonique(ad_hotel.getNon_pays(),0.300);
		liste_consommation[19]=new Telephonique("a_pays",1);
	} 
	void affiche_petit_dej() {
		System.out.println("les petit dejeuners de l'hotel sont: ");
		for(int i=0;i<6;i++)
			System.out.println(liste_consommation[i]);
	}
	void affiche_services_forfaitaire() {
		System.out.println("les servives,avec prix forfaitaire,de l'hotel sont: ");
		for(int i=6;i<9;i++)
			System.out.println(liste_consommation[i]);
	}
	void affiche_services_proportionnel() {
		System.out.println("les servives,avec prix proportionnnel,de l'hotel sont: ");
		for(int i=9;i<12;i++)
			System.out.println(liste_consommation[i]);
	}
	void affiche_Article_minibar() {
		System.out.println("Article_minibar de l'hotel sont: ");
		for(int i=12;i<17;i++)
			System.out.println(liste_consommation[i]);
	}
	void affiche_Telephonique() {
		System.out.println("les servives Telephonique de l'hotel sont: ");
		for(int i=17;i<20;i++)
			System.out.println(liste_consommation[i]);
	}

	public Chambre verifreservation(int numch, LocalDate dres1, int p)throws ErrReservation {
		int i=0;
		while(i<25 && liste_chambres[i]!=null && liste_chambres[i].getNumero()!=numch ) i++;
		if(i==25 ||liste_chambres[i]==null)
			throw new ErrReservation(3);
		boolean reserver=liste_chambres[i].estreserver(dres1,p);
		if(reserver)
			throw new ErrReservation(1);
		return liste_chambres[i];
	}

	public Chambre verifier_reservation_categorie(Categ_chambre categorie, LocalDate dres1, int p)throws ErrReservation {
		int i =0;
		boolean existcat=false;
		while(i<25 && liste_chambres[i]!=null) {
			if(liste_chambres[i].getCateg().equals(categorie)) {
				existcat=true;
				Chambre ch=this.verifreservation01(liste_chambres[i].getNumero(),dres1,p);
				if(ch!=null)
					return ch;
			}
			i++;
		}
		if(existcat)
			throw new ErrReservation(5);
		else
			throw new ErrReservation(4);
	}

	public Chambre verifreservation01(int numch, LocalDate dres1, int p) {
		int i=0;
		while(i<25 && liste_chambres[i]!=null && liste_chambres[i].getNumero()!=numch ) i++;
		if(i==25 ||liste_chambres[i]==null)
			return null;
		boolean reserver=liste_chambres[i].estreserver(dres1,p);
		if(reserver)
			return null;
		return liste_chambres[i];
	}

	public Chambre verifoccupation(int numch, LocalDate dres1, int p,Responsable r)throws ErrReservation{
		int i=0;
		while(i<25 && liste_chambres[i]!=null && liste_chambres[i].getNumero()!=numch)i++;
		if(i==25 ||liste_chambres[i]==null)
			throw new ErrReservation(3);
		boolean reserver=liste_chambres[i].estreserver_parautre(dres1,p,r);
		boolean Occuper=liste_chambres[i].estoccuper(dres1,p);
		if(Occuper)
			throw new ErrReservation(2);
		if(reserver)
			throw new ErrReservation(1);
		return liste_chambres[i];
	}

	public Chambre verifier_occupation_categorie(Categ_chambre categorie, LocalDate dres1, int p,Responsable r)throws ErrReservation {
		int i =0;
		boolean existcat=false;
		while(i<25 && liste_chambres[i]!=null) {
			if(liste_chambres[i].getCateg().equals(categorie)) {
				existcat=true;
				Chambre ch=this.verifoccupation01(liste_chambres[i].getNumero(),dres1,p,r);
				if(ch!=null)
					return ch;
			}
			i++;
		}
		if(existcat)
			throw new ErrReservation(6);
		else
			throw new ErrReservation(4);
	}
	public Chambre verifoccupation01(int numch, LocalDate dres1, int p,Responsable r) {
		int i=0;
		while(i<25 && liste_chambres[i]!=null && liste_chambres[i].getNumero()!=numch)i++;
		if(i==25 ||liste_chambres[i]==null)
			return null;
		boolean reserver=liste_chambres[i].estreserver_parautre(dres1,p,r);
		boolean Occuper=liste_chambres[i].estoccuper(dres1,p);
		if(Occuper)
			return null;
		if(reserver)
			return null;
		return liste_chambres[i];
	}

	public Facture getFacture(Responsable r, LocalDate fin,double remise) {
		Occuper [] liste_occupation_nom_payer=new Occuper[100];
		int ins=0;
		for(int i=0;i<25;i++) {
			Occuper [] liste_occupation_nom_payer_chambre=new Occuper[10];
			liste_occupation_nom_payer_chambre=liste_chambres[i].getliste_occuper_nom_payer(r);
			int j=0;
			while(liste_occupation_nom_payer_chambre[j]!=null) {
				liste_occupation_nom_payer[ins]=liste_occupation_nom_payer_chambre[j];
				ins++;
				j++;
			}
		}
		Facture f=new Facture(r,remise,fin,liste_occupation_nom_payer);
		liste_facture[inser_facture]=f;
		inser_facture++;
		
		return f;
	}
	
}
