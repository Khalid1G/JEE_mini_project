package Beans;

public class User {

	private long id;
	private String nom;
	private String prenom;
	private String role;
	private String tel;
	private String adress;
	private String email;
	private String password;
	private String avatar;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	
	
	public User(long id, String nom, String prenom, String role, String tel, String adress, String email,
			String password, String avatar, String created_at, String updated_at, String deleted_at) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.tel = tel;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public User(String nom, String prenom, String role, String tel, String adress, String email, String password,
			String avatar, String created_at, String updated_at, String deleted_at) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.tel = tel;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
}
