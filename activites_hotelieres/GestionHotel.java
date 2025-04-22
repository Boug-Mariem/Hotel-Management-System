package activites_hotelieres;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GestionHotel {
	private Hotel hotel;

	public void afficheHotel() {
		System.out.println("BIENVENUE");
		System.out.println(hotel);
		System.out.print("\n");
		hotel.affiche_chambre();
		System.out.println("\n");
		hotel.affiche_petit_dej();
		System.out.println("\n");
		hotel.affiche_services_forfaitaire();
		System.out.println("\n");
		hotel.affiche_services_proportionnel();
		System.out.println("\n");
		hotel.affiche_Article_minibar();
		System.out.println("\n");
		hotel.affiche_Telephonique();
		System.out.println("\n");
	}

	public void reservationChambreNumro(int numch, LocalDate Dres, int periode, Responsable r) {
		try {
			if (Dres.isBefore(hotel.getDebut()) || Dres.isAfter(hotel.getFin()))
				throw new ErrReservation(7);
			Chambre ch = hotel.verifreservation(numch, Dres, periode);
			// faire la reservation
			Reserver res1 = new Reserver(r, Dres, periode, numch);
			ch.inserer_reservation(res1);
			System.out.println(res1);
		} catch (ErrReservation a) {
			System.out.println(a.getMessage());
		}
	}

	public void reservationChambreCategorie(Categ_chambre cat, LocalDate Dres, int periode, Responsable r) {
		try {
			if (Dres.isBefore(hotel.getDebut()) || Dres.isAfter(hotel.getFin()))
				throw new ErrReservation(7);
			Chambre ch = hotel.verifier_reservation_categorie(cat, LocalDate.of(2022, 1, 2), periode);
			// faire la reservation
			Reserver res1 = new Reserver(r, Dres, periode, ch.getNumero());
			ch.inserer_reservation(res1);
			System.out.println(res1);
		} catch (ErrReservation a) {
			System.out.println(a.getMessage());
		}
	}

	public void occupationChambreNumero(int numch, LocalDate Dres, int periode, Responsable r, Client[] client_occup) {
		try {
			if (Dres.isBefore(hotel.getDebut()) || Dres.isAfter(hotel.getFin()))
				throw new ErrReservation(7);
			Chambre ch = hotel.verifoccupation(numch, Dres, periode, r);
			// faire la occupation
			Occuper occ1 = new Occuper(Dres, periode, ch, r, client_occup);
			ch.inserer_occupation(occ1);
			System.out.println(occ1);
			boolean ocupper_par_res = ch.estoccupation_parreservation(Dres, periode, r);
			if (ocupper_par_res)
				System.out.println("~~~~~~~~~~l'occupation a fait l'objet de la reservation~~~~~~~~~~");
			else
				System.out.println("~~~~~~~~~~l'occupation n'a pas fait l'objet de la reservation~~~~~~~~~~");
		} catch (ErrReservation a) {
			System.out.println(a.getMessage());
		}
	}

	public void occupationChambreCategorie(Categ_chambre cat, LocalDate Dres, int periode, Responsable r,
			Client[] client_occup) {
		try {
			if (Dres.isBefore(hotel.getDebut()) || Dres.isAfter(hotel.getFin()))
				throw new ErrReservation(7);
			Chambre ch = hotel.verifier_occupation_categorie(cat, Dres, periode, r);
			// faire la occupation
			Occuper occ1 = new Occuper(Dres, periode, ch, r, client_occup);
			ch.inserer_occupation(occ1);
			System.out.println(occ1);
			boolean ocupper_par_res = ch.estoccupation_parreservation(Dres, periode, r);
			if (ocupper_par_res)
				System.out.println("~~~~~~~~~~l'occupation a fait l'objet de la reservation~~~~~~~~~~");
			else
				System.out.println("~~~~~~~~~~l'occupation n'a pas fait l'objet de la reservation~~~~~~~~~~");
		} catch (ErrReservation a) {
			System.out.println(a.getMessage());
		}
	}

	public Facture creerFcature(Responsable r, LocalDate date, double remise) {
		Facture f = hotel.getFacture(r, LocalDate.of(2022, 1, 6), 0);
		System.out.println(f);
		f.affichefacture();
		System.out.print("\n");
		return f;
	}

	public void payer(Facture f, String mode_paiement, double montant) {
		try {
			f.payer(mode_paiement, montant);
		} catch (Errpaiement a) {
			System.out.println(a.getMessage());
		}
	}

	public Client creerClient(String nom, String prenom, String nom_rue, int num_immeuble, String nom_commune,
			int code_postale, String non_pays) {
		try {
			if (hotel.getAd_hotel().getNom_rue().compareTo(nom_rue) == 0
					&& hotel.getAd_hotel().getNum_immeuble() == num_immeuble
					&& hotel.getAd_hotel().getNom_commune().compareTo(nom_commune) == 0
					&& hotel.getAd_hotel().getCode_postale() == code_postale
					&& hotel.getAd_hotel().getNon_pays().compareTo(non_pays) == 0)
				throw new ErrAdresse();
			Adresse AC = new Adresse(nom_rue, num_immeuble, nom_commune, code_postale, non_pays);
			Client C = new Client(nom, prenom, AC);
			return C;
		} catch (ErrAdresse a) {
			System.out.println(a.getMessage());
		}
		return null;
	}

	public Responsable creerResponsable(String nom, String prenom, String nom_rue, int num_immeuble, String nom_commune,
			int code_postale, String non_pays) {
		try {
			if (hotel.getAd_hotel().getNom_rue().compareTo(nom_rue) == 0
					&& hotel.getAd_hotel().getNum_immeuble() == num_immeuble
					&& hotel.getAd_hotel().getNom_commune().compareTo(nom_commune) == 0
					&& hotel.getAd_hotel().getCode_postale() == code_postale
					&& hotel.getAd_hotel().getNon_pays().compareTo(non_pays) == 0)
				throw new ErrAdresse();
			Adresse AR = new Adresse(nom_rue, num_immeuble, nom_commune, code_postale, non_pays);
			Responsable R = new Responsable(nom, prenom, AR);
			return R;
		} catch (ErrAdresse a) {
			System.out.println(a.getMessage());
		}
		return null;
	}

	public Hotel creerHotel(int nbreEtoile, LocalDate Datedebut, LocalDate Datefin, String nom_rue, int num_immeuble,
			String nom_commune, int code_postale, String non_pays) {
		try {
			if (nbreEtoile > 5 || nbreEtoile < 1)
				throw new ErrHotel(1);
			Categ_hotel categ_hotel = new Categ_hotel(nbreEtoile);
			Adresse ad_hotel = new Adresse(nom_rue, num_immeuble, nom_commune, code_postale, non_pays);
			hotel = new Hotel(ad_hotel, Datedebut, Datefin, categ_hotel);
			hotel.initialiser_chambre();
			hotel.initialiser_consommation();
			return hotel;
		} catch (ErrHotel a) {
			System.out.println(a.getMessage());
		}
		return null;

	}

	public Consommer creerConsommationForfaitaire(LocalDate date, LocalDateTime heure, Consommation coms, int numch,
			Responsable r) {
		try {
			if (hotel.getChambre(numch).verifconsommation(date, r) == false)
				throw new ErrConsommation();
			Consommer cons = new Consommer(date, heure, coms, numch);
			hotel.getChambre(numch).inserer_consommation(cons);
			return cons;
		} catch (ErrConsommation a) {
			System.out.println(a.getMessage());
		}
		return null;

	}

	public Consommer creerConsommationProportionnel(LocalDate date, LocalDateTime heure, Consommation coms,
			int quantite, int numch, Responsable r) {
		try {
			if (hotel.getChambre(numch).verifconsommation(date, r) == false)
				throw new ErrConsommation();
			Consommer cons = new Consommer(date, heure, coms, quantite, numch);
			hotel.getChambre(numch).inserer_consommation(cons);
			return cons;
		} catch (ErrConsommation a) {
			System.out.println(a.getMessage());
		}
		return null;

	}

	public void afficheConsommation(int numch, int numocc) {
		hotel.getChambre(numch).affiche_consommation_occupation(numocc);
	}

	public GestionHotel() {	
	}
	
	private void gestion() {
	/////////////////////////////// creation de l'hotel//////////////////////////////////////////////////////////////////
	hotel = creerHotel(5, LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 31), "Charles de Gaulle", 1763,
	"Gland", 69004, "France");
	//////////////////////////////// affichage de l'hotel///////////////////////////////////////////////////////////////////////
	afficheHotel();
	///////////////////////////////////////// creation des clients/////////////////////////////////////////////////////////////////////////////////////
	Client C1 = creerClient("C1", "c1", "rue de c1", 1, "commune de c1", 1111, "pays c1");
	Client C2 = creerClient("C2", "c2", "rue de c2", 2, "commune de c2", 2222, "pays c2");
	Responsable R1 = creerResponsable("R1", "r1", "rue de r1", 1, "commune de r1", 1111, "pays r1");
	Responsable R2 = creerResponsable("R2", "r2", "rue de r2", 2, "commune de r2", 2222, "pays r2");
	//////////////////////////////// verifier la reservation avec numero de chambres//////////////////////////////////////////
	for (int i = 0; i < 2; i++) {
	reservationChambreNumro(0, LocalDate.of(2022, 1, 2), 4, R1);
	}
	///////////////////////////// verifier la reservation avec categorie de chambres///////////////////////////////////////////
	for (int i = 0; i < 5; i++) {
	reservationChambreCategorie(cat8, LocalDate.of(2022, 1, 2), 4, R2);
	}
	/////////////////////////// verifier occupation par numero
	/////////////////////////// chambre////////////////////////////////////////////////////////////////////////
	Client[] client_occup1 = { R1, C1 };
	occupationChambreNumero(0, LocalDate.of(2022, 1, 2), 4, R1, client_occup1);
	// on va esseyer d'occuper une chambre qui est deja reserver par un autre
	// responsable
	/*
	* Client[] client_occup2 = { R2, C1 };
	* occupationChambreNumero(0,LocalDate.of(2022, 1, 3),4,R2,client_occup2);
	*/
	// on va essyer d'occuper une chambre deja occuper par le meme reservateur
	/*
	* Client[] client_occup3 = { R1, C1, C2 };
	* occupationChambreNumero(0,LocalDate.of(2022, 1, 3),4,R1,client_occup3);
	*/
	// on va essyer d'occuper une chambre deja occuper par un autre reservateur
	/*
	* Client[] client_occup4 = { R2, C1 ,C2};
	* occupationChambreNumero(0,LocalDate.of(2022, 1, 3),4,R2,client_occup4);
	*/
	
	/////////////////////////// verifier occupation par categorie
	/////////////////////////// chambre////////////////////////////////////////////////////////////////////////
	Client[] client_occup_cat1 = { R2, C1 };
	occupationChambreCategorie(cat1, LocalDate.of(2022, 1, 2), 4, R2, client_occup_cat1);
	
	///////////////////////// faire des
	///////////////////////// consommations///////////////////////////////////////////////////////////////////
	Consommer cons1 = creerConsommationForfaitaire(LocalDate.of(2022, 1, 2),
	LocalDateTime.parse("2022-01-02T12:39:10"), new Service("blanchisserie", 7, "f"), 0, R1);
	Consommer cons2 = creerConsommationProportionnel(LocalDate.of(2022, 1, 2),
	LocalDateTime.parse("2022-01-02T12:39:10"), new Service("parking", 10, "p"), 3, 0, R1);
	afficheConsommation(0, 0);
	/////////////////////////// paiement//////////////////////////////////////////////////////////////////////////////
	Facture f1 = creerFcature(R1, LocalDate.of(2022, 1, 6), 0);
	payer(f1, "carte", 437);			
	
	}
	
	
	public static void main(String[] args) {
		new GestionHotel().gestion();
	}
	
/////////////////////////////////////LES CATEGORIES DES CHAMBRES//////////////////////////////////////////////////////////////////////////
	Categ_chambre cat1 = new Categ_chambre(false, false, false, 100);
	Categ_chambre cat2 = new Categ_chambre(true, false, false, 125);
	Categ_chambre cat3 = new Categ_chambre(false, true, false, 120);
	Categ_chambre cat4 = new Categ_chambre(false, false, true, 120);
	Categ_chambre cat5 = new Categ_chambre(true, true, false, 130);
	Categ_chambre cat6 = new Categ_chambre(false, true, true, 140);
	Categ_chambre cat7 = new Categ_chambre(true, false, true, 135);
	Categ_chambre cat8 = new Categ_chambre(true, true, true, 150);

}
