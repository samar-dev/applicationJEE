package domaine;

public class User {
	int iduser;
	String nom,prenom;
	String login, password;
	
	
	
	public User(int iduser, String nom, String prenom, String login, String password) {
		super();
		this.iduser = iduser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
