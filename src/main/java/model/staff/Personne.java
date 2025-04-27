package model.staff;
public class Personne {
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    public Personne(String nom, String prenom, String mail, String password) {
        this.nom = nom;
        this.prenom = prenom;
        setMail(mail);
        setPassword(password);
    }
    public Personne() {this.mail = null;
    this.password = null;
    this.prenom = null;
    this.nom = null;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public final  void setMail(String mail) {
        if (mail != null && mail.contains("@") && mail.contains(".")) {
            this.mail = mail;
        } else {
            throw new IllegalArgumentException("Email is not valid.");
        }
    }
    public final  void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }
    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
