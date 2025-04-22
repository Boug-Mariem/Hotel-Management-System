package activites_hotelieres;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Consommer {
	private LocalDate date;
	private LocalDateTime  heure;
	private int quantite=1;
	private Consommation c;
	private double prix;
	private int numch;
	
	public Consommer(LocalDate date,LocalDateTime  heure,Consommation c,int numch) {
		this.date=date;
		this.heure=heure;
		this.c=c;
		prix=c.getPrix();
		this.numch=numch;
		
	}
	public Consommer(LocalDate date,LocalDateTime  heure,Consommation c,int q,int numch) {
		this.date=date;
		this.heure=heure;
		this.c=c;
		quantite=q;
		prix=c.getPrix()*q;
		this.numch=numch;
	}
	public LocalDate getDate() {
		return date;
	}
	public LocalDateTime  getHeure() {
		return heure;
	}
	public int getQuantite() {
		return quantite;
	}
	public Consommation getC() {
		return c;
	}
	public double getPrix() {
		return prix;
	}
	public int getNumch() {
		return numch;
	}
	@Override
	public String toString() {
		return "Consommer [date=" + date + ", heure=" + heure + ", quantite=" + quantite + ", type de consommation " + c + ", prix=" + prix
				+ ", numero de chambre=" + numch + "]";
	}
	
	
}
