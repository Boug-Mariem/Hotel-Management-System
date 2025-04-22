package activites_hotelieres;

public class ErrConsommation extends Exception {
	private String msg;
	public ErrConsommation() {
		msg="************Veuillez verifier la consommation************";
	}
	public String getMessage() {
		return msg;
	}
}
