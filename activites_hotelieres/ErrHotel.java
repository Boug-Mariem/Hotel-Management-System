package activites_hotelieres;

public class ErrHotel extends Exception {
	String msg;
	public ErrHotel(int n) {
		switch(n) {
		case 1:msg="************Veuillez verifier nombres d'etoiles************";
		}
	}
	public String getMessage() {
		return msg;
	}
}
