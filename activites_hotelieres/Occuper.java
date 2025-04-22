package activites_hotelieres;
import java.time.LocalDate;;
public class Occuper {
	private LocalDate debut;
	private LocalDate fin;
	private Chambre chambre;
	private int periode;// debut.until(fin)
	private Responsable responsable;
	private Client[] liste_client=new Client[10];
	private boolean payer=false;
	public Occuper(LocalDate debut,int periode,Chambre chambre,Responsable responsable,Client[] liste_client) {
		this.debut=debut;
		this.chambre=chambre;
		this.periode=periode;// debut.until(fin)
		this.responsable=responsable;
		this.liste_client=liste_client;
		fin=debut.plusDays(periode);
	}
	public LocalDate getDebut() {
		return debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public Chambre getchambre() {
		return chambre;
	}
	public int getPeriode() {
		return periode;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public Client[] getListe_client() {
		return liste_client;
	}
	public boolean isPayer() {
		return payer;
	}
	
	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	public String toString() {
		String msg;
		msg="Occupation:"+"\ndebut : "+debut+"\nfin : "+fin+"\nperiode : "+periode+"\nResonsable : "+responsable.getNum_client()+" "+responsable.getNom()+" "+responsable.getPrenom()+"\nchambre : "+chambre.getNumero();
		return msg;
	}
	

}
