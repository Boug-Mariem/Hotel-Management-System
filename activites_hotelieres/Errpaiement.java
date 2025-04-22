package activites_hotelieres;

public class Errpaiement extends Exception {
	private String msg;
	public Errpaiement(int n) {
		switch(n) {
		case 1:msg="************Veuillez verifier le mode de paiement************";break;
		case 2:msg="************Veuillez verifier le montant************";break;
		}
	}
	public String getMessage() {
		return msg;
	}
}
