package activites_hotelieres;
import java.time.LocalDate;
public class Reserver {
	private static int num;
	private int numero;
	private int periode;
	private Responsable responsable;
	private LocalDate debut;
	private LocalDate fin;
	private int numch=-1;
	//il manque encore si la chambre est vide le temps de la reservation ou non 
	public Reserver(Responsable r,LocalDate d,int p,int numch) {
		num++;
		responsable=r;
		numero=num;
		periode=p;
		debut=d;
		this.numch=numch;
		fin=debut.plusDays(p);
	}
	
	public int getNumero() {
		return numero;
	}
	public int getPeriode() {
		return periode;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public int getNumch() {
		return numch;
	}
	public String toString() {
		String msg;
		msg="Reservation numero"+numero+"\ndebut : "+debut+"\nfin : "+fin+"\nperiode : "+periode+"\nResonsable : "+responsable.getNum_client()+" "+responsable.getNom()+" "+responsable.getPrenom()+"\nchambre : "+numch;
		return msg;
	}
	
}
