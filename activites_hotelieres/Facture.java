package activites_hotelieres;
import java.time.LocalDate;
public class Facture {
	private static int num;
	private int numero;
	private String mode_paiement ;//cache ou cheque ou carte
	private LocalDate date_paiement;
	private double remise;
	private Responsable clientR;
	private Occuper[] liste_occupation_nom_payer=new Occuper[100];
	private double prix;
	private boolean payer=false;
	
	public Facture(Responsable clientR ,double remise,LocalDate date_paiement, Occuper[] liste_occupation_nom_payer) {
		num++;
		numero=num;
		this.clientR=clientR;		
		this.remise=remise;
		this.date_paiement=date_paiement;
		this.liste_occupation_nom_payer=liste_occupation_nom_payer;
	}
	@Override
	public String toString() {
		return "Facture numero: "+numero+" associe au client numero: "+clientR.getNum_client();
	}
	
	public void affichefacture() {
		double prix=0;
		int i=0;
		while(liste_occupation_nom_payer[i]!=null) {
			System.out.println(liste_occupation_nom_payer[i].getchambre());
			prix=prix+liste_occupation_nom_payer[i].getchambre().getCateg().getPrix()*liste_occupation_nom_payer[i].getPeriode();
			prix=prix+liste_occupation_nom_payer[i].getchambre().affiche_consommation_occupation(liste_occupation_nom_payer[i]);
			i++;
		}
		System.out.println("la remise est :"+remise+"%");
		System.out.println("le prix sans remise est :"+prix);
		prix=(100-remise)*prix/100;
		System.out.println("le prix a payer est :"+prix);
		this.prix=prix;
		System.out.println("les mode de paiement sont: cache , cheque , carte:");
	}
	
	 
	public void payer(String mode_paiement,double montant)throws Errpaiement {
		if(mode_paiement.compareTo("carte")!=0 && mode_paiement.compareTo("cheque")!=0 && mode_paiement.compareTo("cache")!=0)
			throw new Errpaiement(1);
		this.mode_paiement=mode_paiement;
		if(montant !=prix)
			throw new Errpaiement(2);
		this.payer=true;
		int i=0;
		while(liste_occupation_nom_payer[i]!=null) {
			liste_occupation_nom_payer[i].setPayer(true);
			i++;
		}
		System.out.println("Paiement avec succes : montant= "+montant+" mode_paiement= "+mode_paiement);
	 }
	
}
