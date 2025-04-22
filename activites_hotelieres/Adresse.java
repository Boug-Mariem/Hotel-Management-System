package activites_hotelieres;

public class Adresse
{
    private String nom_rue;
    private int num_immeuble;
    private String nom_commune;
    private int code_postale;
    private String non_departement;//ou etat si pertinent 
    private String non_pays;
    private int num_tel;//s'il existe
    private String adresse_cur;//s'il existe
    private String adresse_web;//s'il existe
	
    
    public Adresse(String nom_rue, int num_immeuble, String nom_commune, int code_postale,String non_pays) {
		super();
		this.nom_rue = nom_rue;
		this.num_immeuble = num_immeuble;
		this.nom_commune = nom_commune;
		this.code_postale = code_postale;
		this.non_pays = non_pays;
	}
       
	public Adresse(String nom_rue, int num_immeuble, String nom_commune, int code_postale, String non_departement,
			String non_pays, int num_tel, String adresse_cur, String adresse_web) {
		super();
		this.nom_rue = nom_rue;
		this.num_immeuble = num_immeuble;
		this.nom_commune = nom_commune;
		this.code_postale = code_postale;
		this.non_departement = non_departement;
		this.non_pays = non_pays;
		this.num_tel = num_tel;
		this.adresse_cur = adresse_cur;
		this.adresse_web = adresse_web;
	}




	public String getNom_rue() {
		return nom_rue;
	}
	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}
	public int getNum_immeuble() {
		return num_immeuble;
	}
	public void setNum_immeuble(int num_immeuble) {
		this.num_immeuble = num_immeuble;
	}
	public String getNom_commune() {
		return nom_commune;
	}
	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}
	public int getCode_postale() {
		return code_postale;
	}
	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}
	public String getNon_departement() {
		return non_departement;
	}
	public void setNon_departement(String non_departement) {
		this.non_departement = non_departement;
	}
	public String getNon_pays() {
		return non_pays;
	}
	public void setNon_pays(String non_pays) {
		this.non_pays = non_pays;
	}
	public int getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
	}
	public String getAdresse_cur() {
		return adresse_cur;
	}
	public void setAdresse_cur(String adresse_cur) {
		this.adresse_cur = adresse_cur;
	}
	public String getAdresse_web() {
		return adresse_web;
	}
	public void setAdresse_web(String adresse_web) {
		this.adresse_web = adresse_web;
	}
    @Override
    public String toString() {
    	return "   rue : "+nom_rue+"\n   immeuble: "+num_immeuble+"  commune: "+nom_commune+"\n   code postale: "+code_postale+"  pays :"+non_pays;
    }
    

}

