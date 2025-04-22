package activites_hotelieres;

public class ErrReservation extends Exception {
	private String msg;
	public ErrReservation(int n) {
		switch(n) {
		case 1:msg="************la chambre est deja reserver************";break;
		case 2:msg="************la chambre est deja occuper************";break;
		case 3:msg="************Veuillez verifier le numero de la chambre************ ";break;
		case 4:msg="************Veuillez verifier la categorie de la chambre************ ";break;
		case 5:msg="************Toutes les chambres de cette categorie sont reserver************";break;
		case 6:msg="************Toutes les chambres de cette categorie sont occuper/reserver************";break;
		case 7:msg="************l'hotel est fermee dans cette periode************";break;
		
		}
	}
	public String getMessage() {
		return msg;
	}
}
