package activites_hotelieres;

public class ErrAdresse extends Exception {
	private String msg;
	public ErrAdresse() {
		msg="************Veuillez verifier l'adresse************";
	}
	public String getMessage() {
		return msg;
	}
}
